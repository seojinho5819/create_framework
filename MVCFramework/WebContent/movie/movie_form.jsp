<%@page import="blood.model.BloodAdvisor"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
function send(){
	 var form = document.querySelector("form");
	 form.action="/movie.do";
	 form.method="post";
	 form.submit(); //전송
}
</script>
</head>
<body>
	<form>
		<select name="movie">
			<option>영화를 선택하세요</option>
			<option value="블랙펜서2">블랙펜서2</option>
			<option value="스파이더맨3">스파이더맨3</option>
			<option value="존윅">존윅</option>
			<option value="분노의질주">분노의 질주</option>
		</select>
		<button type="button" onClick="send()">분석보기</button>
	</form>
	
</body>
</html>