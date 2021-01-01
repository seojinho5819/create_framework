package com.koreait.fashionmall.model.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {


	private int product_id;
	private int subcategory_id;
	private String product_name;
	private int price;
	private String brand;
	private String detail;
	private String filename;//currentTimeMills로 받을 예정
	//이미지 하나를 자동으로 처리하는 객체 선언
	//단 이름을 html의 업로드 컴포넌트 파라미터명과 일치시켜야한다
	private MultipartFile repImg;
	private MultipartFile[] addImg;//추가 이미지는 선택사항이며 배열이다.
	
	//색상값들
	String[] colors;
	String[] fit;
	
	
	
}
