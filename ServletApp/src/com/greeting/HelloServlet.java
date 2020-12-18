package com.greeting;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//서블릿이란 ? 오직 자바 클래스중 웹서버에서만 생성 및 실행될수있는 클래스
public class HelloServlet extends HttpServlet{
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String msg = config.getInitParameter("msg");
		System.out.println("init() 호출시 넘겨받은 파라미터 정보:"+msg);
		
		ServletContext context = config.getServletContext();
				System.out.println(context.getRealPath(getServletInfo()));
	}
	//일단 서블릿이 생성된후 초기화까지 마치면 클라이언트에 요청을 처리할 준비가 된것이며
	//클라이언트의 요청을 처리하는 메서드가 바로 service메서드이다
	//서비스 메서드가 요청을 처리하려면 클라이언트의 요청정보와 클라이언트에 보낼 응답정보를 필요로 하기 떄문에
	//service() 메서드의 매개변수로 request,response객체가 전달 되어야 한다(고양이가 함)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트가 전송한 요청즁 파라미터를 끄집어 내서 풀력해본다
		String id = request.getParameter("id");
		
		//클라이언트에 전송
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("당신이 전송한 파라미턴터는 "+id+"이다");
	}
	//서블릿이 소멸할때 호출되는 메서드
	//서블릿이 보유한 자원을 반납할때(스트림 닫음,db닫음)
	public void destroy() {
		System.out.println("die");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("hello");
	}

}
