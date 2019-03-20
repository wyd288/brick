package com.fan1111.service.user;

import com.fan1111.entity.Role;
import com.fan1111.entity.User;

import java.util.List;

public interface UserService {
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	User getUserLogin(String code,String password);
	/**
	 * 获取用户总数
	 * @param userName
	 * @param userRole
	 * @return
	 */
	Integer getUserCount(String name,Integer role);
	/**
	 * 返回用户信息集合
	 * @param userName
	 * @param userRole
	 * @return
	 */
	List<User> getUserList(String name,Integer role);
	/**
	 * 返回用户角色信息集合
	 * @return
	 */
	List<Role> getUserRoleList();
	
	User getUserById(Integer id);
	
	
	User getUserByCode(String code);
	
	Boolean insertUser(User user);
	
	Boolean updateUser(User user);
	
	Boolean deleteUser(Integer id);
	
	Boolean updatePasswordById(Integer id,String password);
	
}
