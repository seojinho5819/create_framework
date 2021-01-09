package com.koreait.fashionmall.model.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionmall.exception.MailSendException;
import com.koreait.fashionmall.exception.MemberNotFoundException;
import com.koreait.fashionmall.exception.MemberRegistException;
import com.koreait.fashionmall.model.common.MailSender;
import com.koreait.fashionmall.model.common.SecureManager;
import com.koreait.fashionmall.model.domain.Member;
import com.koreait.fashionmall.model.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	
	//메일발송객체
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SecureManager secureManager;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member select(Member member) throws MemberNotFoundException {
		//유저가 전송한 파라미터 비번을 해시값으로 변환하여 아래 메서드 호출
		String hash = secureManager.getSecureData(member.getPassword());
		member.setPassword(hash);//VO에 해시값 대입
		Member obj = memberDAO.select(member);
		return obj;
		
	}

	@Override
	public void regist(Member member) throws MemberRegistException,MailSendException{
		//db에 넣기 이메일 보내기 문자발송..
		
		//암호화처리
		String secureData = secureManager.getSecureData(member.getPassword());
		member.setPassword(secureData);//변환시켜 다시VO대입
		
		memberDAO.insert(member);
		
		String name = member.getName();
		String addr = member.getAddr();
		String email = member.getEmail_id()+"@"+member.getEmail_server();
		mailSender.send(email , "안녕하세요"+name+"님 쇼핑몰입니다", addr+" 에 거주하시죠? 가입을 환영합니다!");
		
		
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Member member) {
		// TODO Auto-generated method stub
		
	}

}
