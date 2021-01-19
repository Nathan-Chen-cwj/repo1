package net.seehop.spring.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.seehop.spring.pojo.User;

@Repository
public class UserMapper {

	/**
	 * DI 从容器中将mapper取出来的时候，这些成员变量都有初始值
	 */
	/*
	 * private String name; private int age; private List<Integer> ids; private
	 * String[] names; private HashMap<String, String> keysMap; private Properties
	 * properties;
	 */

	public List<User> getAllUser() {

		List<User> users = new ArrayList<User>();

		for (int i = 0; i < 10; i++) {
			User user = new User("mt" + i, "123456");
			users.add(user);
		}

		return users;
	}

	/*
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public int getAge() { return age; }
	 * 
	 * public void setAge(int age) { this.age = age; }
	 * 
	 * public List<Integer> getIds() { return ids; }
	 * 
	 * public void setIds(List<Integer> ids) { this.ids = ids; }
	 * 
	 * public String[] getNames() { return names; }
	 * 
	 * public void setNames(String[] names) { this.names = names; }
	 * 
	 * public HashMap<String, String> getKeysMap() { return keysMap; }
	 * 
	 * public void setKeysMap(HashMap<String, String> keysMap) { this.keysMap =
	 * keysMap; }
	 * 
	 * public Properties getProperties() { return properties; }
	 * 
	 * public void setProperties(Properties properties) { this.properties =
	 * properties; }
	 */

}
