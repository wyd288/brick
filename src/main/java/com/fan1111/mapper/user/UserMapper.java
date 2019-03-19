package com.fan1111.mapper.user;

import com.fan1111.entity.Role;
import com.fan1111.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	
	User getLoginUser(@Param("code")String userCode,@Param("password")String userPassword);
	
	Integer getUserCount(@Param("name")String userName,@Param("role")Integer userRole);
	
	List<User> getUserList(@Param("name")String userName,@Param("role")Integer userRole);
	
	List<Role> getUserRoleList();
	
	User getUserById(@Param("id")Integer id);
	
	User getUserByCode(@Param("code")String userCode);
	
	Integer insertUser(User user);
	
	Integer updateUser(User user);
	
	Integer deleteUser(@Param("id")Integer id);
	
	Integer updatePasswordById(@Param("id")Integer id,@Param("password")String userPassword);
}
