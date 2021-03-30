<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 다른 페이지 파일을 포함 -->
<!-- 별도로가 아니라 1개로 취급한다 -->
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<!-- hsp:include는 jsp에 포함하여 컴파일하지 않고 별도의 서블릿에 요청하는것 -->
<jsp:include page="/WEB-INF/views/includes/nav.jsp" />
	
	<!--  <h3>Static HTML Page</h3>
	<p> 이건 정적 HTML </p>-->
	<!-- images 태그: 그림 삽입 -->
	<!-- src 이미지 위치  alt 태체 태스트 -->
	<img src="images/수달.jpg" 
	width = 320
	height = 320
	alt="프로필" />
	<h3>요청 처리 연습</h3>
	
	<!-- a태그:페이지 링크 -->
	<p>
	
	<a href ="hello.jsp?name=Servlet">JSP 호출(a태그)</a>
	</p>
	
	<p>
	
	<a href ="test.jsp">test</a>
	</p>
	
	<p>
	<a href ="hs?name=Servlrt">Servlet 호출(get방식)</a>
	</p>
	
	<h3>POST 전송 연습</h3>
	<!-- action: 요청 처리할 url
	method:요청 전송 방식 -->
	<form action="hs"
	method="POST">
	<label for ="last_name">성(Family Name)</label>
	<input type="text" id="last_name" name="last_name">
	<br/>
	<label for="first_name">이름(first_name)</label>
	<input type="text" id="first_name" name="first_name">
	<br/>
	<input type ="submit" value="전송"/>
	</form>
	
	<h3> 테이블연습</h3>
	<p><a href ="table.html">테이블연습</a>
	</p>
	
	
	<h3>라이프싸이클 확인</h3>
	<p>
	<a href="life">라이프싸이클 확인</a>
	</p>
	
	<h3>웹 어플리케이션 모델1 이메일 리스트</h3>
	<p>
	<a href ="emaillist/index.jsp"> 이메일 리스트</a>
	</p>
	
	<h3> 웹 어플리 케이션 모델 2 연습</h3>
	<p>
	<a href="el">이메일 v2</a>
	</p>

<h3>Cookie Test</h3>
<p>
<a href="<%=request.getContextPath() %>/cookies">쿠키 테스트</a>
</p>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>