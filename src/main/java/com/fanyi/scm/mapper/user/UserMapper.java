package com.fanyi.scm.mapper.user;

import com.fanyi.scm.vo.Role;
import com.fanyi.scm.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户mapper接口
 * @author wangyds
 */
@Mapper
public interface UserMapper {
	/**
	 * 获取登陆用户信息
	 * @param code
	 * @param password
	 * @return
	 */
	User getLoginUser(@Param("code")String code, @Param("password")String password);

	/**
	 * 获取用户总数
	 * @param name
	 * @param role
	 * @return
	 */
	Integer getUserCount(@Param("name")String name,@Param("role")Integer role);

	/**
	 * 根据名字和权限获取用户
	 * @param name
	 * @param role
	 * @return
	 */
	List<User> getUserList(@Param("name")String name,@Param("role")Integer role);

	/**
	 * 获取权限列表
	 * @return
	 */
	List<Role> getUserRoleList();

	/**
	 * 根据ID获取用户
	 * @param id
	 * @return
	 */
	User getUserById(@Param("id")Integer id);

	/**
	 * 根据编码获取用户
	 * @param code
	 * @return
	 */
	User getUserByCode(@Param("code")String code);

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	Integer insertUser(User user);

	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	Integer updateUser(User user);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	Integer deleteUser(@Param("id")Integer id);

	/**
	 * 根据ID修改用户密码
	 * @param id
	 * @param password
	 * @return
	 */
	Integer updatePasswordById(@Param("id")Integer id,@Param("password")String password);
}
