package com.springmvc.test.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*�� Ŭ������ ��û�� ���������� ó���ϴ� ��Ʈ�ѷ����� ���
 * �߱��ϴ� ��ǥ:plain old java object(pojo)������ΰ����� ������ ����*/

public class TestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//3�ܰ�; �˸´� ������ü�� �Ͻ�Ŵ
		String msg="hi";
		
		//������ ���� �ִٸ� request��ü�� ����!!
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		
		//������Ʈ�ѷ����� � �������� ������� ������ ���� ������ ������
		mav.setViewName("test/result");
		return mav;
	}
}
