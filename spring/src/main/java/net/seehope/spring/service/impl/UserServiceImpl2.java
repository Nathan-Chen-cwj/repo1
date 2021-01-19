package net.seehope.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.seehope.spring.mapper.UserMapper;
import net.seehope.spring.pojo.User;
import net.seehope.spring.service.UserService;

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
