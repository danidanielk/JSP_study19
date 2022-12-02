package com.kim.sep281.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	MemberDAO.login(request, response);
	//1. 로그인에 성공하면 로그인 성공했다는 페이지 loginSuccess.jsp로갈거고
	//2. 로그인에 실패하면 index.jsp 로그인페이지로 갈거임
	
	//아까 만들어놓은기능 로그인 성공시 true값 
	if(MemberDAO.loginCheck(request)) {
		request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		
	}else {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	
	}

}
