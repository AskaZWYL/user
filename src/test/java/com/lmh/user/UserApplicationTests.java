package com.lmh.user;

import com.lmh.user.entity.Role;
import com.lmh.user.entity.User;
import com.lmh.user.mapper.RoleMapper;
import com.lmh.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

//    @Autowired
//    public UserApplicationTests(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

    @Test
    public void contextLoads() {
        User user = userMapper.getUserByName("root");
        System.out.println(user);
//        List<Role> roles = roleMapper.getRoleByUid(1);
//        System.out.println(roles);
    }

}
