package com.koreait.fashionmall.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionmall.exception.MailSendException;
import com.koreait.fashionmall.exception.MemberNotFoundException;
import com.koreait.fashionmall.exception.MemberRegistException;
import com.koreait.fashionmall.model.common.MessageData;
import com.koreait.fashionmall.model.domain.Member;
import com.koreait.fashionmall.model.member.service.MemberService;
import com.koreait.fashionmall.model.product.service.TopCategoryService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;
	@Autowired
	private TopCategoryService topCategoryService;
	//회원가입폼 요청
	@RequestMapping(value = "/shop/member/registForm", method = RequestMethod.GET)
	public ModelAndView getRegistForm() {
		List topList = topCategoryService.selectAll();
		ModelAndView mav = new ModelAndView("shop/member/signup");
		mav.addObject("topList",topList);
		return mav;
	}
	@RequestMapping(value = "shop/member/regist",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String regist(Member member) {
		logger.debug("id:"+member.getUser_id());
		logger.debug("name:"+member.getName());
		logger.debug("password:"+member.getPassword());
		logger.debug("email_id:"+member.getEmail_id());
		logger.debug("email_server:"+member.getEmail_server());
		logger.debug("zipcode:"+member.getZipcode());
		logger.debug("addr:"+member.getAddr());
	
		memberService.regist(member);
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"result\":1, ");
		sb.append(" \"msg\":\"회원가입 성공\"");
		sb.append("}");
		return sb.toString();
	}
	//로그인홈 요청
	@RequestMapping(value = "/shop/member/loginForm",method = RequestMethod.GET)
	public ModelAndView getLoginForm() {
		List topList = topCategoryService.selectAll();
		ModelAndView mav = new ModelAndView("shop/member/signin");
		mav.addObject("topList",topList);
		return mav;
	}
	//로그인 요청 처리
		@RequestMapping(value="/shop/member/login", method=RequestMethod.POST)
		public String login(Member member,HttpServletRequest request) {
			
			//db에 존재여부 확인 
			Member obj = memberService.select(member);

			//존재 O : 세션에 회원정보 담아두기
			HttpSession session = request.getSession();
			session.setAttribute("member", obj);//현재 클라이언트 요청과 연계된 세션에 보관해놓는다
		
			return "redirect:/";
			
			
		}
		//로그아웃
		@RequestMapping(value="/shop/member/loginOut", method=RequestMethod.GET)
		public ModelAndView loginout(HttpServletRequest request) {
			request.getSession().invalidate();//세션무효화 이 시점부터 세션에 담겨졌던 데이터가 다 무효화된다
			MessageData messageData = new MessageData();
			messageData.setResultCode(1);
			messageData.setMsg("로그아웃 되었습니다");
			messageData.setUrl("/");
			
			ModelAndView mav = new ModelAndView("shop/error/message");
			mav.addObject("messageData", messageData);
			return mav;
			
		
			
			
		}
	
	
	//예외 핸들러 두가지 처리
	@ExceptionHandler(MemberRegistException.class)
	@ResponseBody
	public String handleException(MemberRegistException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"result\":0, ");
		sb.append(" \"msg\":\""+e.getMessage()+"\"");
		sb.append("}");
		return sb.toString();
	}
	@ExceptionHandler(MailSendException.class)
	public ModelAndView handleException(MailSendException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", e.getMessage()); //사용자가 보게될 에러 메시지
		mav.setViewName("shop/error/result");
		return mav;
	}
	@ExceptionHandler(MemberNotFoundException.class)
	public ModelAndView handleException(MemberNotFoundException e) {
		ModelAndView mav = new ModelAndView();
	
		List topList = topCategoryService.selectAll();
		mav.addObject("topList",topList);
		mav.addObject("msg", e.getMessage()); //사용자가 보게될 에러 메시지
		mav.setViewName("shop/error/result");
		return mav;
	}
}
