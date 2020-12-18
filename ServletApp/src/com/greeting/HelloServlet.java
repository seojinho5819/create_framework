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
//�����̶� ? ���� �ڹ� Ŭ������ ������������ ���� �� ����ɼ��ִ� Ŭ����
public class HelloServlet extends HttpServlet{
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String msg = config.getInitParameter("msg");
		System.out.println("init() ȣ��� �Ѱܹ��� �Ķ���� ����:"+msg);
		
		ServletContext context = config.getServletContext();
				System.out.println(context.getRealPath(getServletInfo()));
	}
	//�ϴ� ������ �������� �ʱ�ȭ���� ��ġ�� Ŭ���̾�Ʈ�� ��û�� ó���� �غ� �Ȱ��̸�
	//Ŭ���̾�Ʈ�� ��û�� ó���ϴ� �޼��尡 �ٷ� service�޼����̴�
	//���� �޼��尡 ��û�� ó���Ϸ��� Ŭ���̾�Ʈ�� ��û������ Ŭ���̾�Ʈ�� ���� ���������� �ʿ�� �ϱ� ������
	//service() �޼����� �Ű������� request,response��ü�� ���� �Ǿ�� �Ѵ�(����̰� ��)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ŭ���̾�Ʈ�� ������ ��û�O �Ķ���͸� ������ ���� Ǯ���غ���
		String id = request.getParameter("id");
		
		//Ŭ���̾�Ʈ�� ����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("����� ������ �Ķ�����ʹ� "+id+"�̴�");
	}
	//������ �Ҹ��Ҷ� ȣ��Ǵ� �޼���
	//������ ������ �ڿ��� �ݳ��Ҷ�(��Ʈ�� ����,db����)
	public void destroy() {
		System.out.println("die");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("hello");
	}

}
