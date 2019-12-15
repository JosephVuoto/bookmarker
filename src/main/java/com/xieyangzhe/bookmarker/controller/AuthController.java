package com.xieyangzhe.bookmarker.controller;

import com.xieyangzhe.bookmarker.pojo.ResponseInfo;
import com.xieyangzhe.bookmarker.service.UserDetailsServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yangzhe Xie
 * @date 15/12/19
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/register")
    public ResponseInfo registerUser(@RequestParam String email,
                                     @RequestParam String password,
                                     @RequestParam String nickname) {
        return userDetailsService.doRegister(email, password, nickname);
    }
}
