package com.koreait.fashionmall.model.product.repository;

import java.util.List;

import com.koreait.fashionmall.model.domain.Image;
import com.koreait.fashionmall.model.domain.Product;

public interface ImageDAO {
	//CRUD
	public List selectAll();//그냥 모든 이미지
	public List selectAllById(int product_id);//fk에 소속된 모든 이미지
	public Image select(int product_id);
	public void insert(Image image);
	public void update(Image image);
	public void delete(int image_id);
}
