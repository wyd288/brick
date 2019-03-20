package com.fan1111.service.user;

import com.fan1111.entity.Role;
import com.fan1111.entity.User;
import com.fan1111.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public User getUserLogin(String code, String password) {
		return userMapper.getLoginUser(code, password);
	}
	@Override
	public List<User> getUserList(String name, Integer role) {
		
		return userMapper.getUserList(name, role);
	}
	@Override
	public List<Role> getUserRoleList() {
		
		return userMapper.getUserRoleList();
	}
	@Override
	public Integer getUserCount(String name, Integer role) {
		
		return userMapper.getUserCount(name, role);
	}
	@Override
	public User getUserById(Integer id) {
		
		return userMapper.getUserById(id);
	}
	@Override
	public User getUserByCode(String code) {
		
		return userMapper.getUserByCode(code);
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
	public Boolean updatePasswordById(Integer id, String password) {
		Integer result = userMapper.updatePasswordById(id, password);
		if(result>0){
			return true;
		}
		return false;
	}

}
