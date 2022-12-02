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
	//1. �α��ο� �����ϸ� �α��� �����ߴٴ� ������ loginSuccess.jsp�ΰ��Ű�
	//2. �α��ο� �����ϸ� index.jsp �α����������� ������
	
	//�Ʊ� ����������� �α��� ������ true�� 
	if(MemberDAO.loginCheck(request)) {
		request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		
	}else {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	
	}

}
