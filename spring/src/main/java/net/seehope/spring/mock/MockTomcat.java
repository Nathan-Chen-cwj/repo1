package net.seehope.spring.mock;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.seehope.spring.mapper.AccountMapper;
import net.seehope.spring.mapper.UserMapper;
import net.seehope.spring.mock.servlet.MockHttpServlet;
import net.seehope.spring.pojo.Account;
import net.seehope.spring.pojo.User;
import net.seehope.spring.service.AccountService;
import net.seehope.spring.service.UserService;
import net.seehope.spring.web.controller.UserController;

/**
 * 伪造/模仿的tomcat
 * 
 * @author Monty
 *
 */
public class MockTomcat {

	public static void main(String[] args) {

		try {
			/**
			 * spring应用上下文（容器/工厂），通过读取类路径下的spring配置文件来创建 相当于 tomcat 的容器
			 */

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

			/**
			 * 在容器中所有MockHttpServlet的子类
			 */
			/*
			 * Map<String, MockHttpServlet> servlets =
			 * context.getBeansOfType(MockHttpServlet.class); servlets.keySet().forEach(key
			 * -> { System.out.println("key: " + key + " value : " + servlets.get(key)); });
			 * 
			 * MockHttpServlet servlet1 = (MockHttpServlet) context.getBean("mockServlet1");
			 * 
			 * MockHttpServlet servlet11 = (MockHttpServlet)
			 * context.getBean("mockServlet1"); servlet1.service(); servlet11.service();
			 * 
			 * UserController userController = (UserController)
			 * context.getBean("userController"); UserService userService = (UserService)
			 * context.getBean("userServiceImpl"); UserMapper userMapper = (UserMapper)
			 * context.getBean("userMapper");
			 * 
			 * System.out.println(userController); System.out.println(userService);
			 * System.out.println(userMapper);
			 * 
			 * List<User> users = userController.getAllUser(); for (User user : users) {
			 * System.out.println(user); }
			 */

			AccountService accountService = (AccountService) context.getBean("accountServiceImpl");
			Account mt = new Account(1, "mt", 10d);
			Account linda = new Account(2, "linda", 10d);
			accountService.transferTx(mt, linda);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
