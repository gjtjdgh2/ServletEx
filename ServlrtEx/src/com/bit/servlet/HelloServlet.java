package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet은 httpServlt을 상속 받아 필요한 메소드를 overriide 한다
public class HelloServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post 방식 요청을 처리하기 위한 메서드
		//폼으로 전송된 파라메터 받아오기
		//입력 데이터 인코딩
		req.setCharacterEncoding("UTF-8");
		//	폼내의 input 태그 name 속성
		String firstName = req.getParameter("last_name");
		String lastName = req.getParameter("first_name");
		
		//응답 객체에서 Writer 얻어 온다
		//응답되는 데이터가 text/html임을 브라우저에게 알려줌
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1> From Data</h1>");
		out.println("<p>성: "+firstName+"</p>");
		out.println("<p>이름: "+lastName+"</p>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get 요청을 처리하는 메서드 오버레이드
		//클라이언트에서 name 파라메터를 받아서 환영 메서드 출력
		//jsp에서는 사용자 요청을 자동적으로 reqest라는 이름 저장
		String name = req.getParameter("name");
		if(name == null){
			name="Anoymous";
		}
		//출력
		//응답 객체에서 Writer를 얻는다
		PrintWriter out = resp.getWriter();
		out.println("<h1> Hello, servrlt</h1>");
		out.println("<p> Hello," +name+ "</p>");
		
	}

}
