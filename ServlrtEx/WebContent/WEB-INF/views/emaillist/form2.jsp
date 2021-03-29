<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>에일 리스트 가입 v2</h1>
<p> 메일 리스트에 가입 하려면 아래 항목을 기입하시고<br/>
등록 버튼을 눌러 주세요</p>

<form action="<%= request.getContextPath() %>/el"
		method="POST">
		<input type="hidden" name="action" value="update" /><!-- 숨은 데이터 -->
		<label for="email">수정 이메일</label>
		<input type="text" name="ppemail" id="email" />
		<br/>
		<label for="last_name">성</label>
		<input type="text" name="last_name" id="last_name" />
		<br/>
		<label for="first_name">이름</label>
		<input type="text" name="first_name" id="first_name" />
		<br/>
		<label for="email">이메일</label>
		<input type="text" name="email" id="email" />
		
		
		
		<input type="submit" value="등록" />
	</form>
	
	<p>
		<a href="el">목록</a>
	</p>


</body>
</html>