package net.seehop.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.seehop.spring.mapper.UserMapper;
import net.seehop.spring.pojo.User;
import net.seehop.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}

}
