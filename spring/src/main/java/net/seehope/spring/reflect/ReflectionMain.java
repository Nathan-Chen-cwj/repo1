package net.seehope.spring.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.seehope.spring.pojo.User;
import net.seehope.spring.service.UserService;

public class ReflectionMain {
	public static void main(String[] args) {

		try {

			/**
			 * 可以通过某个类的 全限定名 找到在JVM中的类
			 * 加载模板 可以通过模板创建实例，或者获取/设置 字段,方法，构造器
			 */

			User user = (User) Class.forName("net.seehope.spring.pojo.User").newInstance();

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserService service = (UserService) context.getBean("userServiceImpl");

			UserService proxyService = (UserService) JDKProxyFactory.binding(service,
					"net.seehope.spring.reflect.Interceptor1");
			UserService proxyService2 = (UserService) JDKProxyFactory.binding(proxyService,
					"net.seehope.spring.reflect.Interceptor2");
			List<User> users = proxyService2.getAllUser();
			for (User user2 : users) {
				System.out.println(user2);
			}

//			User userProxy = (User) JDKProxyFactory.binding(user);

//			showClz(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
//		User user = new User("mt12345687", "211234658");

	}

	public static void showClz(Object clz) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		Class<? extends Object> userClz = clz.getClass();

		/*
		 * Field usernameField = userClz.getDeclaredField("username");
		 * usernameField.setAccessible(true); usernameField.set(user, "mt");
		 * 
		 * Field passwordFiled = userClz.getDeclaredField("password");
		 * passwordFiled.setAccessible(true); passwordFiled.set(user, "123456");
		 */

		Field[] fields = userClz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.getName());
		}

		Method[] methods = userClz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
			if (method.getName().equals("init")) {
				method.invoke(clz, null);
			}
		}

		Constructor<?>[] con = userClz.getDeclaredConstructors();
		User user = (User) userClz.getConstructor(String.class, String.class).newInstance("mt123456", "123456");
		System.out.println("user:" + user);

		for (Constructor<?> constructor : con) {
			System.out.println(constructor);
		}

	}

	/**
	 * 传入任意对象，返回该对象的tostring之后的字符串，需要获取该对象的所有字段名和值
	 * 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static String toString(Object obj) throws IllegalArgumentException, IllegalAccessException {

		String str = "";
		Class<? extends Object> clz = obj.getClass();

		Field[] fields = clz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			str += field.getName() + " : " + field.get(obj) + " ";
		}

		return str;
	}
}