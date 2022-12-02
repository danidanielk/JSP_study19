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
//ó���� �ٹ������?..
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
// �ٽ� index���� �׼ǿ� Logincontroller ���ְ� ������ cookie �������ְ�
// HomeController.java
// loginSuccess ������ a �±� href��  HomeController �Է�