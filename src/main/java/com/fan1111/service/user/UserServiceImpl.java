package com.fan1111.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fan1111.mapper.user.UserMapper;
import com.fan1111.entity.Role;
import com.fan1111.entity.User;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public User getUserLogin(String userCode, String userPassword) {
		return userMapper.getLoginUser(userCode, userPassword);
	}
	@Override
	public List<User> getUserList(String userName, Integer userRole) {
		
		return userMapper.getUserList(userName, userRole);
	}
	@Override
	public List<Role> getUserRoleList() {
		
		return userMapper.getUserRoleList();
	}
	@Override
	public Integer getUserCount(String userName, Integer userRole) {
		
		return userMapper.getUserCount(userName, userRole);
	}
	@Override
	public User getUserById(Integer id) {
		
		return userMapper.getUserById(id);
	}
	@Override
	public User getUserByUserCode(String userCode) {
		
		return userMapper.getUserByUserCode(userCode);
	}
	@Override
	public Boolean insertUser(User user) {
		Integer result = userMapper.insertUser(user);
		if(result>0){
			return true;
		}
		return false;
	}
	@Override
	public Boolean updateUser(User user) {
		Integer result = userMapper.updateUser(user);
		if(result>0){
			return true;
		}
		return false;
	}
	@Override
	public Boolean deleteUser(Integer id) {
		Integer result = userMapper.deleteUser(id);
		if(result>0){
			return true;
		}
		return false;
	}
	@Override
	public Boolean updatePasswordById(Integer id, String userPassword) {
		Integer result = userMapper.updatePasswordById(id, userPassword);
		if(result>0){
			return true;
		}
		return false;
	}

}
