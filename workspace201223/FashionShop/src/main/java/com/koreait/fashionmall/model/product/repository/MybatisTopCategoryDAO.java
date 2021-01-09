package com.koreait.fashionmall.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionmall.model.domain.TopCategory;
@Repository
public class MybatisTopCategoryDAO implements TopCategoryDAO{

	@Autowired
private SqlSessionTemplate sessionTemple;
	
@Override
	public List selectAll() {
		return sessionTemple.selectList("TopCategory.selectAll");
		
	}

	@Override
	public TopCategory select(int topcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TopCategory topCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TopCategory topCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int topcategory_id) {
		// TODO Auto-generated method stub
		
	}

}
