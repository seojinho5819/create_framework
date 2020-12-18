<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	//데이터 베이스와 연결이 된다면 모든 설정이 완료된것임
	InitialContext context = new InitialContext();//jndi검색객체
	
	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/mysql"); // 톰캣 서버에 설정한 기소스 찾자!!

	//찾아낸 커넥션 풀을 이용하여 커넥션 한개를 끄집어 내고 주소값이 나오면 성공!
	Connection con = ds.getConnection();
	out.print(con);//주소값 나오는지 확인

%>