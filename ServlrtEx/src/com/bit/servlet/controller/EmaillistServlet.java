package com.bit.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/el") //현재 클래스를  /el url 패턴에 반응하는 서블릿 등록
// Web.xml에 <servler>과 <servler-mapping> 과 동
@WebServlet(name ="Emaillist", urlPatterns="/el")
public class EmaillistServlet extends HttpServlet {

	

	//doget
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doGet(req, resp);
}
}