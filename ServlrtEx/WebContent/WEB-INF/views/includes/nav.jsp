<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
<li><a href="<%= request.getContextPath() %>/users?a=loginform">로그인</a>
		<li><a href="<%=request.getContextPath() %>/users?a=joinform">회원가입</a>
	</ul>