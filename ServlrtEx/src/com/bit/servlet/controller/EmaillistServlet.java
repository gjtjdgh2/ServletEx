package com.bit.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.servlet.dao.EmailDao;
import com.bit.servlet.dao.EmailDaoOraclmpl;
import com.bit.servlet.dao.EmailVo;

//@WebServlet("/el") //현재 클래스를  /el url 패턴에 반응하는 서블릿 등록
// Web.xml에 <servler>과 <servler-mapping> 과 동
@WebServlet(name="Emaillist", urlPatterns="/el")
public class EmaillistServlet extends HttpServlet {

	

	//doget
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//view 처리를 위한 requestDisapatcher를 확인
//		자신이 처리하고 있던 요청 객체와 응답 객체를
			//	다른 서블릿(JSP)로 전달하여 추가 작업진행
		String action = req.getParameter("a");
		
		if ("form".equals(action)) {	//	a=form이면 
			//	등록 폼: 파라미터에서 a를 확인 form이면 분기
			RequestDispatcher rd = 
					getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/form.jsp");
			rd.forward(req, resp);
		}else if("delete".equals(action)) {
			Long no = Long.valueOf(req.getParameter("no"));
			
			EmailDao dao= new EmailDaoOraclmpl();
			dao.delete(no);
			
			resp.sendRedirect(req.getContextPath()+"/el");
		}else if ("form2".equals(action)) {	//	a=form이면 
				//	등록 폼: 파라미터에서 a를 확인 form이면 분기
				RequestDispatcher rd = 
						getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/form2.jsp");
				rd.forward(req, resp);
		}else {
			//리스트를 불러와 req애 attribute추가
			EmailDao dao = new EmailDaoOraclmpl();
			List<EmailVo> list = dao.getList();
			
			req.setAttribute("list", list);
			
			//Dispatcher 확보
			RequestDispatcher rd= getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/index.jsp");
			rd.forward(req, resp);
		}
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String action = req.getParameter("action");	//	히든 필드
		if("update".equals(action)){
			String email = req.getParameter("email");
			String firstName = req.getParameter("first_name");
			String lastName = req.getParameter("last_name");
			String newemail = req.getParameter("new_email");
			
			
			EmailVo vo = new EmailVo();
			vo.setEmail(email);
			vo.setLastName(lastName);
			vo.setFirstName(firstName);
			vo.setNewemail(newemail);
			
			
EmailDao dao = new EmailDaoOraclmpl();
			
			dao.update(vo);
			
			//	리스트 페이지로 리다이렉트
			resp.sendRedirect(req.getContextPath() + "/el");
			
	}else if ("insert".equals(action)) {	//	action이 insert -> 삽입
			String firstName = req.getParameter("first_name");
			String lastName = req.getParameter("last_name");
			String email = req.getParameter("email");
			
			EmailVo vo = new EmailVo();
			vo.setLastName(lastName);
			vo.setFirstName(firstName);
			vo.setEmail(email);
			
			//EmailVo vo = new EmailVo(lastName,firstName,email); 같음
			
			EmailDao dao = new EmailDaoOraclmpl();
			
			dao.insert(vo);
			
			//	리스트 페이지로 리다이렉트
			resp.sendRedirect(req.getContextPath() + "/el");
		} else {
			doGet(req, resp);
		}
		
	}
	
}