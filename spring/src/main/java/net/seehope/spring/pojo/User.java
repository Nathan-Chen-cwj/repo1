package net.seehope.spring.pojo;

import java.io.Serializable;

/**
 * 用户数据模型 domain 领域对象 entity 实体
 * 
 * pojo -> 简单的java对象的集合 po persist object 和数据库中的记录完全一致得数据模型 vo value object
 * 从后台返回给前端的数据模型 bo business object 从前端接受回来的参数 dto 数据传输对象 data transfer object
 * 商品评论 评论级别和数量
 * 
 * @author Monty
 *
 *         po -> javaBean规范 1、必须要有包 2、实现get/set方法 spel 3、必须要有无参构造器
 *         没有无参构造器就无法实现动态代理 4、实现序列化接口 无法输出到ROM中 无法存储到redis等nosql中
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	public void init() {
		System.out.println("init user");
	}

}
