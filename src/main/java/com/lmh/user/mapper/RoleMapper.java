package com.lmh.user.mapper;

import com.lmh.user.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<Role> getRoleByUid(@Param("uid") Integer uid);
}
