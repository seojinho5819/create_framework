package com.koreait.fashionmall.model.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.fashionmall.model.domain.TopCategory;


public interface TopCategoryService {
	public List selectAll();
	public TopCategory select(int topcategory_id);
	public void insert(TopCategory topCategory);
	public void update(TopCategory topCategory);
	public void delete(int topcategory_id);
}
