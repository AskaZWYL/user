package com.lmh.user.mapper;

import com.lmh.user.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getUserByName(@Param("username") String username);
//    User getUserRoleByUsername(@Param("username") String username);
}
