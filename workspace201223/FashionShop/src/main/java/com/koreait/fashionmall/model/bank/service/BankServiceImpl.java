package com.koreait.fashionmall.model.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionmall.exception.DepositFailException;
import com.koreait.fashionmall.exception.WithdrawFailException;
import com.koreait.fashionmall.model.bank.repository.KbankDAO;
import com.koreait.fashionmall.model.bank.repository.SbankDAO;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	private KbankDAO kbankDAO;
	@Autowired
	private SbankDAO sbankDAO;
	
	@Override
	public void send(int money) throws DepositFailException, WithdrawFailException{
		kbankDAO.withdraw(money);//국민으로부터 출금
		sbankDAO.deposit(money);//신한은행으로 입금
		
	}

}
