package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifecycleServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		//첫 호출시 init 메서드가 수행 : 서블릿 초기화 담당
	
		System.out.println("Lifectcle: init()");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//요청이 들어올때 호추ㄹ, 요청 방식에 따라 doget or dopost
		//요청 메서드 방식에 관계없이 호출 된다
	
		System.out.println("Lifectcle: service()");
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청이 get 메서드 일떄
		

		System.out.println("Lifectcle: doGet()");
		PrintWriter out = resp.getWriter();
		out.println("<h1> dogetcall</h1>");
	}


	@Override
	public void destroy() {
		//서버 중단 , 오랜 시간동안 요청이 없을때 -> 서블릿 의 자원 정리
		
	
		System.out.println("Lifectcle: destroy()");
	}


}