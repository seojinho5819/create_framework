package com.koreait.fashionmall.model.bank.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.koreait.fashionmall.exception.WithdrawFailException;
import com.koreait.fashionmall.model.common.Bell;

@Repository
public class JdbcKbankDAO implements KbankDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//출금
	@Override
	public void withdraw(int money) throws WithdrawFailException{
		
		int result = jdbcTemplate.update("update kbank set total=total-?",money);
		if(result==0) {
			throw new WithdrawFailException("sorry Withdraw fail");
		}
	}

}
