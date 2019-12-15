package com.xieyangzhe.bookmarker;

import com.google.gson.Gson;
import com.xieyangzhe.bookmarker.dao.UserDao;
import com.xieyangzhe.bookmarker.pojo.User;
import com.xieyangzhe.bookmarker.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BookmarkerApplicationTests {
    
    @Resource
    UserDao userDao;
    @Resource
    UserDetailsServiceImpl userDetailsService;

    @Test
    void contextLoads() {
    }

    @Test
    void newTest() {
        userDetailsService.doRegister("joseph@xieyangzhe.com", "1234five", "Yangzhe Xie");
    }
}
