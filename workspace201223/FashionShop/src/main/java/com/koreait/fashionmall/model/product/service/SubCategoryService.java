package com.koreait.fashionmall.model.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.fashionmall.model.domain.SubCategory;


public interface SubCategoryService {
	//CRUD
	public List selectAll();
	public List selectAllById(int topcategory_id);//선택한 상위카테고리에 소속된 하위카테고리 가져오기
	public SubCategory select(int topcategory_id);
	public void insert(SubCategory subCategory);
	public void update(SubCategory subCategory);
	public void delete(int topcategory_id);
}
