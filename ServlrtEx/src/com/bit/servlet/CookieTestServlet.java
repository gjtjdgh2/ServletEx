package com.bit.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/cookies")
public class CookieTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라메타 a로 분기
				String action = req.getParameter("a");
				if("delete".equals(action)) {
					//a=delete
					Cookie[] cookies = req.getCookies();
					if(cookies != null) {
						for(Cookie cookie:cookies){
							if(cookie.getName().equals("example"));
							//쿠키삭제-> 유효시간을 0으로 맞춘다
							cookie.setMaxAge(0);
							resp.addCookie(cookie);
							break;
						}
					}
				}else {
					//쿠키 읽기 req.getCookies
					Cookie[] cookies=req.getCookies();
					if(cookies !=null) {//쿠키가 있다
						for(Cookie cookie:cookies) {//셋팅했던 example cooke 찾아보기
							if(cookie.getName().equals("example")) {
								//쿠키값 받아오기
								String cookieVal = URLDecoder.decode(cookie.getValue());
								//속성추가
								req.setAttribute("example", cookieVal);
								break;
							}
							
						}
						
					}
				}
		
		RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/views/cookies/cookie_form.jsp");
		
		rd.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//쿠키로 설정할 파라메타값 읽어오기
		String value = req.getParameter("example");
		value=URLEncoder.encode(value,"UTF-8");
		Cookie cookie = new Cookie("example",value);//example키에 value 값 저장
		cookie.setMaxAge(3600); //지속 시간 3600초
		//사용자 브라우저에 쿠키 저장을 위해 응답해더에 적제
		resp.addCookie(cookie);
		resp.sendRedirect(req.getContextPath()+"/cookies");
		
	}
	

	
}
