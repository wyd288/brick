package com.fan1111.service.user;

import com.fan1111.entity.Role;
import com.fan1111.entity.User;

import java.util.List;

/**
 * 用户模块服务接口
 * @author wangyds
 * @date 2019/4/10
 */
public interface UserService {
	/**
	 * 用户登录
	 * @param code
	 * @param password
	 * @return
	 */
	User getUserLogin(String code,String password);
	/**
	 * 获取用户总数
	 * @param name
	 * @param role
	 * @return
	 */
	Integer getUserCount(String name,Integer role);
	/**
	 * 返回用户信息集合
	 * @param name
	 * @param role
	 * @return
	 */
	List<User> getUserList(String name,Integer role);
	/**
	 * 返回用户角色信息集合
	 * @return
	 */
	List<Role> getUserRoleList();

	/**
	 * 根据ID获取用户
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);

	/**
	 * 根据编码获取用户
	 * @param code
	 * @return
	 */
	User getUserByCode(String code);

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	Boolean insertUser(User user);

	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	Boolean updateUser(User user);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	Boolean deleteUser(Integer id);

	/**
	 * 根据ID更新用户密码
	 * @param id
	 * @param password
	 * @return
	 */
	Boolean updatePasswordById(Integer id,String password);
	
}
