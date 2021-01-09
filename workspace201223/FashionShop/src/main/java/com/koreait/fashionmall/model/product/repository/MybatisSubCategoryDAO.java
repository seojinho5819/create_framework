package com.koreait.fashionmall.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionmall.exception.ProductRegistException;
import com.koreait.fashionmall.model.domain.SubCategory;
import com.koreait.fashionmall.model.domain.TopCategory;

@Repository
public class MybatisSubCategoryDAO implements SubCategoryDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemple;

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAllById(int topcategory_id) {
		// TODO Auto-generated method stub
		return sqlSessionTemple.selectList("SubCategory.selectAllById",topcategory_id);
	}

	@Override
	public SubCategory select(int topcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(SubCategory subCategory) throws ProductRegistException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(SubCategory subCategory) throws ProductRegistException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int topcategory_id) throws ProductRegistException {
		// TODO Auto-generated method stub

	}

}
