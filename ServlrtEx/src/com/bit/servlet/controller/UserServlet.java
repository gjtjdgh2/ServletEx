package com.bit.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.servlet.dao.UserDao;
import com.bit.servlet.dao.UserDaoOrcalmpl;
import com.bit.servlet.dao.UserVo;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자 요청 파라메타 처리: a
		String action =req.getParameter("a");
		
		if("joinform".equals(action)) {
			//a=joinform -> 가입 폼으로
			RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/views/users/joinform.jsp");
			rd.forward(req,resp);
			
		}else if("joinsuccess".equals(action)) {
			RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/views/users/joinsuccess.jsp");
			rd.forward(req,resp);
		}
		
		else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//액션 파라미터 받아오기
		String action =req.getParameter("a");
		if("join".equals(action)) {
			//a hidden 필드가 join일때
			//파라메터 받아오기
			String name=req.getParameter("name");
			String password = req.getParameter("password");
			String email=req.getParameter("email");
			String gender=req.getParameter("gender");
			
			//사용자 객체생성
			UserVo vo= new UserVo(name,password,email,gender);
			UserDao dao= new UserDaoOrcalmpl();
			
			int insertedCount = dao.insert(vo);
			if(insertedCount ==1) { //성공
				resp.sendRedirect(req.getContextPath()+"/users?a=joinsuccess");
				
			}else {//실패
				//다시 가입폼 출력
				RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/views/users/joinform.jsp");
				rd.forward(req,resp);
			}
		}else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
				
			}
			
		}
	}

	

