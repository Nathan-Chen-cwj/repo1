package net.seehope.spring.service;

import net.seehope.spring.pojo.Account;

public interface AccountService {

	public void transferTx(Account in, Account out);

}
