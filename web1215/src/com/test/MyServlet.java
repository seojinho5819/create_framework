/*
 * ���� javaEE����� ������������ 
 */
package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//HttpServlet�� ��� �޴� ���� ���������� ����� ���ִ� Ŭ������ , ������ �ȴ�!!
public class MyServlet extends HttpServlet{
	//Ŭ���̾�Ʈ�� get������� ��û�� �ҋ� �� ��û�� ó���ϴ� �޼����̴�!!
	//HttpServlet �� �޼���κ��� ��ӹ޾Ҵ�... ������ �� ������ �츮�� �������̵� �ؼ� ��û�� ó������
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ŭ���̾�Ʈ�� ���ڿ� ����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//��� : ������ �̿��Ͽ� html �����Ϸ��� ���ڿ��� ó�� �ؾ���
		out.print("<table width=\"100%\" border=\"1px\">");
		out.print("<tr>");
		out.print("<td>no</td>");
		out.print("<td>�̹���</td>");
		out.print("<td>����</td>");
		out.print("<td>�ۼ���</td>");
		out.print("<td>�����</td>");
		out.print("<td>��ȸ��</td>");
		out.print("</tr>");
		out.print("</table>");
		
		
	}
}
