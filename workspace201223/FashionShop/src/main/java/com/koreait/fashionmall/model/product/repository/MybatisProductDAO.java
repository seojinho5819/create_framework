package com.koreait.fashionmall.model.product.repository;

import java.util.List; 

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionmall.model.domain.Product;
import com.koreait.fashionmall.model.domain.SubCategory;
import com.koreait.fashionmall.model.domain.TopCategory;

@Repository
public class MybatisProductDAO implements ProductDAO {
	@Autowired
	private SqlSessionTemplate sessionTemple;

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAllById(int subcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product select(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Product product) {
		sessionTemple.insert("Product.insert",product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		
	}

	
}
