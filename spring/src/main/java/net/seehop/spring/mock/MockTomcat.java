package net.seehop.spring.mock;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.seehop.spring.mapper.UserMapper;
import net.seehop.spring.mock.servlet.MockHttpServlet;
import net.seehop.spring.pojo.User;
import net.seehop.spring.service.UserService;
import net.seehop.spring.web.controller.UserController;

/**
 * 伪造/模仿的tomcat
 * 
 * @author Monty
 *
 */
public class MockTomcat {

	public static void main(String[] args) {
		/**
		 * spring应用上下文（容器/工厂），通过读取类路径下的spring配置文件来创建 相当于 tomcat 的容器
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		/**
		 * 在容器中所有MockHttpServlet的子类
		 */
		Map<String, MockHttpServlet> servlets = context.getBeansOfType(MockHttpServlet.class);
		servlets.keySet().forEach(key -> {
			System.out.println("key: " + key + " value : " + servlets.get(key));
		});

		MockHttpServlet servlet1 = (MockHttpServlet) context.getBean("mockServlet1");

		MockHttpServlet servlet11 = (MockHttpServlet) context.getBean("mockServlet1");
		servlet1.service();
		servlet11.service();

		UserController userController = (UserController) context.getBean("userController");
		UserService userService = (UserService) context.getBean("userServiceImpl");
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");

		System.out.println(userController);
		System.out.println(userService);
		System.out.println(userMapper);

		List<User> users = userController.getAllUser();
		for (User user : users) {
			System.out.println(user);
		}

	}

}
