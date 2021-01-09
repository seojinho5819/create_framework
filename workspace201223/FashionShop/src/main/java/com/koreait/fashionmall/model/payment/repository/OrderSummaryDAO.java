package com.koreait.fashionmall.model.payment.repository;

import com.koreait.fashionmall.model.domain.OrderSummary;

public interface OrderSummaryDAO {
	public void insert(OrderSummary orderSummary);
}