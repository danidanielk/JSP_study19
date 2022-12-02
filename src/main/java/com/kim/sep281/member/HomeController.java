package com.kim.sep281.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//처음에 겟방식으로?..
		if(MemberDAO.loginCheck(request)) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

// index.jsp 
// loginSuccess
// Member.java
// MemberDAO.java
// LoginController.java
// 다시 index가서 액션에 Logincontroller 써주고 벨류에 cookie 설정해주고
// HomeController.java
// loginSuccess 에들어가서 a 태그 href에  HomeController 입력