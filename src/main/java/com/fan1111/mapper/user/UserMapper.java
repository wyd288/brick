package com.fan1111.mapper.user;

import com.fan1111.entity.Role;
import com.fan1111.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	
	User getLoginUser(@Param("code")String code,@Param("password")String password);
	
	Integer getUserCount(@Param("name")String name,@Param("role")Integer role);
	
	List<User> getUserList(@Param("name")String name,@Param("role")Integer role);
	
	List<Role> getUserRoleList();
	
	User getUserById(@Param("id")Integer id);
	
	User getUserByCode(@Param("code")String code);
	
	Integer insertUser(User user);
	
	Integer updateUser(User user);
	
	Integer deleteUser(@Param("id")Integer id);
	
	Integer updatePasswordById(@Param("id")Integer id,@Param("password")String password);
}
