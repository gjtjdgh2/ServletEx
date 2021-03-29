<%@page import="com.bit.servlet.dao.EmailVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 리스트 확인v2</title>
</head>
<body>
<p>
<a href="index.jsp"> 뒤로가기</a>
</p>

	<h1>메일 리스트v2</h1>
	<%
	//다운 캐스팅
	List<EmailVo> list = (List<EmailVo>)request.getAttribute("list");
	
	//	루프
	for (EmailVo vo: list) {
	%>

		<!-- 정보 테이블 -->
	<table border=1>
		<tr>
			<th>성</th>
			<td><%= vo.getLastName() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%= vo.getFirstName() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%= vo.getEmail() %></td>
		</tr>
		<!-- 삭제 버튼 -->
		<tr>
			<td >
				<form action="<%= request.getContextPath() %>/el">
					<input type="hidden" name="a" value="delete" />
					<!-- 게시물의 no(PK) -->
					<input type="hidden" name="no" value="<%= vo.getNo() %>"/>
					<!-- 전송 버튼 -->
					<input type="submit" value="삭제" />
				</form>
				<td>
				<form action="<%= request.getContextPath() %>/el?a=form2" method="POST">
				<input type="hidden" name="a" value="update" />
				<input type="submit" value="수정" />
	
	</form>
	</td>
				</td>
				<!-- TODO: 수정 기능을 구현해보기 -->
				
		</tr>
	</table>		
	
	<%
	}
	%>
	
	<p>
		<a href="<%= request.getContextPath() %>/el?a=form">메일링 리스트 가입(MVC)</a>
	</p>
	
</body>
</html>