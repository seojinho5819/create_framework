package com.koreait.fashionmall.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.fashionmall.exception.ProductRegistException;
import com.koreait.fashionmall.model.domain.Image;

@Repository
public class MybatisImageDAO implements ImageDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAllById(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image select(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Image image) throws ProductRegistException {
		int result = sqlSessionTemplate.insert("Image.insert",image);
		if(result==0) {
			throw new ProductRegistException("상품테이블에 연결실패");
		}
		
	}

	@Override
	public void update(Image image) throws ProductRegistException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int image_id) throws ProductRegistException {
		// TODO Auto-generated method stub
		
	}

}