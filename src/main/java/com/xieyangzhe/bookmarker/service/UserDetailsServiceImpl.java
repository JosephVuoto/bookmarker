package com.xieyangzhe.bookmarker.service;

import com.xieyangzhe.bookmarker.dao.FolderDao;
import com.xieyangzhe.bookmarker.dao.UserDao;
import com.xieyangzhe.bookmarker.pojo.Folder;
import com.xieyangzhe.bookmarker.pojo.JwtUser;
import com.xieyangzhe.bookmarker.pojo.ResponseInfo;
import com.xieyangzhe.bookmarker.pojo.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yangzhe Xie
 * @date 15/12/19
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    UserDao userDao;
    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    FolderDao folderDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.selectUserByEmail(s);
        return new JwtUser(user);
    }

    public String getCurrentUserName() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public User getCurrentUser() {
        String username = getCurrentUserName();
        return userDao.selectUserByEmail(username);
    }

    public ResponseInfo doRegister(String email, String password,
                                   String nickname) {
        if (userDao.selectUserByEmail(email) != null) {
            return ResponseInfo.buildFailure(1003, "This email has already been registered");
        }
        User user = new User();
        user.setEmail(email);
        user.setNickname(nickname);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userDao.insertUser(user);

        Folder folder = new Folder();
        folder.setName("default");
        folder.setPath("/");
        folder.setUser(user.getUserId());
        folderDao.insertFolder(folder);

        return ResponseInfo.buildSuccess();
    }
}
