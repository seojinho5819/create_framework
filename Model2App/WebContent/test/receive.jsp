<%@ page contentType="text/html;charset=utf-8"%>
<%
	//메세지를 받아보자!!
request.setCharacterEncoding("utf-8");
String msg = request.getParameter("msg");


//session.setAttribute("result", msg);

//지금 요청과 관련된 요청객체에 무언가를 담아보자!
request.setAttribute("result", msg);

//서버상의 또다른 jsp(서블릿)에 요청을 전달해보자!!!
RequestDispatcher dis = request.getRequestDispatcher("/test/result.jsp");
dis.forward(request, response);//포워딩(응답,요청객체 result에 넘겨주기)

//클라이언트로 하여금 지정한 url로 다시 접속하라는 명령

//response.sendRedirect("/test/result.jsp");
%>