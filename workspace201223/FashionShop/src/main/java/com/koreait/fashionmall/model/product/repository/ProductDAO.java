package com.koreait.fashionmall.model.product.repository;

import java.util.List;

import com.koreait.fashionmall.model.domain.Product;
import com.koreait.fashionmall.model.domain.SubCategory;

public interface ProductDAO {
	//CRUD
			public List selectAll();
			public List selectAllById(int subcategory_id);//선택한 상위카테고리에 소속된 하위카테고리 가져오기
			public Product select(int product_id);
			public void insert(Product product);
			public void update(Product product);
			public void delete(int product_id);
}
