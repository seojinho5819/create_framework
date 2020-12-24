package com.springmvc.test.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*이 클래스는 요청을 실제적으로 처리하는 컨트롤러임을 명시
 * 추구하는 목표:plain old java object(pojo)기반으로가려는 경향이 강함*/

public class TestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//3단계; 알맞는 로직객체에 일시킴
		String msg="hi";
		
		//저장할 것이 있다면 request객체에 저장!!
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		
		//형님컨트롤러에게 어떤 페이지를 보여줘야 할지에 대한 정보는 여전히
		mav.setViewName("test/result");
		return mav;
	}
}
