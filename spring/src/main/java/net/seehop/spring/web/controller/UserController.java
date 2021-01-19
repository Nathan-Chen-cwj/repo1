package net.seehop.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import net.seehop.spring.pojo.User;
import net.seehop.spring.service.UserService;

@Controller
public class UserController {

	/**
	 * 1、 按照类自动装配 2. 找到的所有的类的bean中有没有beanid和成员变量的名字相同，如果有，直接注入
	 */

	@Autowired
	@Qualifier("userServiceImpl")
	public UserService userService;

	public List<User> getAllUser() {
		return userService.getAllUser();
	}

}
