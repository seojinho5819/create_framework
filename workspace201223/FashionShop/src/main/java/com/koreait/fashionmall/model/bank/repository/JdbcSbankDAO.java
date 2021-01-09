package com.koreait.fashionmall.model.bank.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.koreait.fashionmall.exception.DepositFailException;
import com.koreait.fashionmall.model.common.Bell;

@Repository
public class JdbcSbankDAO implements SbankDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void deposit(int money) throws DepositFailException{
		
		int result =jdbcTemplate.update("insert into sbank(sbank_id,total) values(seq_sbank.nextval,?)",money);
		result=0;//일부로 실패처리
		if(result==0) {
			throw new DepositFailException("sorry Deposit fail");
		}
	}

}
