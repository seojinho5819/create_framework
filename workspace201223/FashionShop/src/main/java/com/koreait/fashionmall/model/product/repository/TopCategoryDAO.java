package com.koreait.fashionmall.model.product.repository;

import java.util.List;

import com.koreait.fashionmall.model.domain.TopCategory;

public interface TopCategoryDAO {
	//CRUD
	public List selectAll();
	public TopCategory select(int topcategory_id);
	public void insert(TopCategory topCategory);
	public void update(TopCategory topCategory);
	public void delete(int topcategory_id);
}
