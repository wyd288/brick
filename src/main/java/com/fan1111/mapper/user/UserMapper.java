package com.fan1111.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fan1111.entity.Role;
import com.fan1111.entity.User;

public interface UserMapper {
	
	User getLoginUser(@Param("userCode")String userCode,@Param("userPassword")String userPassword);
	
	Integer getUserCount(@Param("userName")String userName,@Param("userRole")Integer userRole);
	
	List<User> getUserList(@Param("userName")String userName,@Param("userRole")Integer userRole);
	
	List<Role> getUserRoleList();
	
	User getUserById(@Param("id")Integer id);
	
	User getUserByUserCode(@Param("userCode")String userCode);
	
	Integer insertUser(User user);
	
	Integer updateUser(User user);
	
	Integer deleteUser(@Param("id")Integer id);
	
	Integer updatePasswordById(@Param("id")Integer id,@Param("userPassword")String userPassword);
}
