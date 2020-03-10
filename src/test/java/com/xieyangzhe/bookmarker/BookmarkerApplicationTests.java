package com.xieyangzhe.bookmarker;

import com.google.gson.Gson;
import com.xieyangzhe.bookmarker.dao.FolderDao;
import com.xieyangzhe.bookmarker.dao.UserDao;
import com.xieyangzhe.bookmarker.pojo.Folder;
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
    FolderDao folderDao;
    @Resource
    UserDetailsServiceImpl userDetailsService;

    @Test
    void contextLoads() {
    }

    @Test
    void newTest() {
//        User user = new User();
//        user.setEmail("joseph@test.com");
//        user.setNickname("Demo");
//        user.setPassword("1234five");
//        userDao.insertUser(user);
//        System.out.println(user.getUserId());
//        Folder folder = new Folder();
//        folder.setName("default");
//        folder.setPath("/");
//        folder.setUser(9);
//        folderDao.insertFolder(folder);
//        System.out.println(userDao.selectAllUsers());
//        userDetailsService.doRegister("demo@test.com", "1234five", "demo");

        System.out.println(folderDao.selectFolderByUser(12));
    }
}
