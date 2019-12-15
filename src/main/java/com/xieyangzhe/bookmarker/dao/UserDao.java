package com.xieyangzhe.bookmarker.dao;

import com.xieyangzhe.bookmarker.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 15/12/19
 */
@Mapper
public interface UserDao {
    List<User> selectAllUsers();

    User selectUserByEmail(String email);

    void insertUser(User user);
}
