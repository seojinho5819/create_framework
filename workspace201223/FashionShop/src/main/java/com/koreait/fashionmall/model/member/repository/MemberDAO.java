package com.koreait.fashionmall.model.member.repository;

import java.util.List;

import com.koreait.fashionmall.model.domain.Member;

public interface MemberDAO {
	//CRUD
	public List selectAll();//모든 회원가져오기
	public Member select(Member member);
	public void insert(Member member);
	public void update(Member member);
	public void delete(Member member);

}
