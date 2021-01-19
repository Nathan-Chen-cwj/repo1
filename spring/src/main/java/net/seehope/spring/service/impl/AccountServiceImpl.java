package net.seehope.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.seehope.spring.mapper.AccountMapper;
import net.seehope.spring.pojo.Account;
import net.seehope.spring.service.AccountService;

/**
 * 一般业务层方法，需要开启事务管理功能 要么一起成功，要么一起失败
 * 
 * @author Monty
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	/**
	 * 一个业务层方法调用了多个dao层方法
	 */
	@Override
	public void transferTx(Account in, Account out) {
		accountMapper.addMoney(in);

		int i = 1 / 0;

		accountMapper.deMoney(out);
	}

}
