package com.xieyangzhe.bookmarker.filter;

import com.google.gson.Gson;
import com.xieyangzhe.bookmarker.common.JwtTokenUtils;
import com.xieyangzhe.bookmarker.pojo.JwtUser;
import com.xieyangzhe.bookmarker.pojo.LoginForm;
import com.xieyangzhe.bookmarker.pojo.ResponseInfo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        /* Request method has to be POST */
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        /* Instantiate a LoginUser object and send it to authenticationManager */
        LoginForm loginUser = new LoginForm(request.getParameter("email"), request.getParameter("password"));
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword())
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        /* In our case the principal is a object of JwtUser, which implemented UserDetails  */
        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();

        String role = "";
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        /* User role */
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();
        }

        /* Create a token for this user and send back as the HTTP response */
        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), role, false);
        Map<String, String> resp = new HashMap<>();
        resp.put("token", token);
        response.getWriter().write(new Gson().toJson(ResponseInfo.buildSuccess(resp)));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        int code;
        String msg;

        if (failed == null || failed.getMessage() == null) {
            code = 1001;
            msg = "Wrong username or password";
        } else if (failed.getMessage().equalsIgnoreCase("User is disabled")) {
            code = 1002;
            msg = "User have not been verified yet";
        } else if (failed.getMessage().equalsIgnoreCase("Bad credentials")
                || failed.getMessage().equalsIgnoreCase("User not found")) {
            code = 1001;
            msg = "Wrong username or password";
        } else {
            code = 1000;
            msg = failed.getMessage();
        }
        response.getWriter().write(new Gson().toJson(ResponseInfo.buildFailure(code, msg)));
    }

}

