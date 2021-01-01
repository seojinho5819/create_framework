package com.koreait.fashionmall.model.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.fashionmall.model.domain.Product;
import com.koreait.fashionmall.model.domain.SubCategory;

@Service
public interface ProductService {
	//CRUD
		public List selectAll();
		public List selectAllById(int subcategory_id);//선택한 상위카테고리에 소속된 하위카테고리 가져오기
		public Product select(int product_id);
		public void regist(Product product);
		public void update(Product product);
		public void delete(int product_id);

}
