package net.seehope.spring.pojo;

import java.io.Serializable;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private Double money;

	public Account() {
	}

	public Account(Integer id, String username, Double money) {
		this.id = id;
		this.username = username;
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", money=" + money + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
