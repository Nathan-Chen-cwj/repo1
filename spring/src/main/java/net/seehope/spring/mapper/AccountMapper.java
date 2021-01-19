package net.seehope.spring.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.seehope.spring.pojo.Account;

@Repository
public class AccountMapper {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 给对应的账号加钱
	 * 
	 * @param account
	 */
	public void addMoney(Account account) {
		jdbcTemplate.update("update account set money = money + ? where id = ?", account.getMoney(), account.getId());
	}

	/**
	 * 给对应的账号扣钱
	 * 
	 * @param account
	 */
	public void deMoney(Account account) {
		jdbcTemplate.update("update account set money = money - ? where id = ?", account.getMoney(), account.getId());
	}
}
