package com.koreait.fashionmall.model.member.service;

import java.util.List;

import com.koreait.fashionmall.model.domain.Member;

public interface MemberService {

	public List selectAll();//모든 회원가져오기
	public Member select(Member member);
	public void regist(Member member);//회원등록및 기타 필요사항 처리...
	public void update(Member member);
	public void delete(Member member);
}
