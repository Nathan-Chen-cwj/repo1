package net.seehop.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.seehop.spring.mapper.UserMapper;
import net.seehop.spring.pojo.User;
import net.seehop.spring.service.UserService;

@Service
public class UserServiceImpl2 implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAllUser() {

		List<User> users = userMapper.getAllUser();
		users.add(new User("1", "1000"));
		return users;
	}

}
