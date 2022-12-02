package com.kim.sep281.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {

			//�������� �������� �ٴ��ٵ� �α����� �Ǿ��ִ��� Ȯ���� �ǰԲ�.
	public static boolean loginCheck(HttpServletRequest req) {
		//�α����� �Ǿ����� �Ʒ� m �� �������٤��� �װ� ���ִ��� Ȯ���ϴ°�
		//��Ʈ����Ʈ�� �ڷ����� ������Ʈ�� ����ȯ ������� �Ʒ� Ÿ������ ����ó�� ù��°�������ָ��.
		Member m = (Member) req.getSession().getAttribute("m");
		//�α��� �������̰ų� �α��ο� ���������� 10������ ������(m�� ������) �α��ξȵǾ������� null �� �ǰ���
		//�α��εǾ����� ���� m �� null ���� �ƴ� ��� true �� �����ϰ�
		return (m !=null);
				
	}
	
	
	
	
	
	
			//�α��α��
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("EUC-KR");
			String id=req.getParameter("id");
			String pw = req.getParameter("qw");
			
			
			//�α��ο� ������ ���������� ������ ����Ʈ ��𼭵��� ��� �� �� �ְ�
			//�α��� ���¿��� ����Ʈ �����س��� ���� �ð� ������ �α��� ���� Ǯ����
			//	= session �Ҽ��� attribute or cookie
			//  = cookie �� �����ؿ� ��Ʃ����Ʈ�� �غ��ô�.
			if (id.equals("����") && pw.equals("me")) {
				Member m = new Member(id,pw);
				req.getSession().setAttribute("m", m);
			//������ �����ð�
				req.getSession().setMaxInactiveInterval(10);
			}
			//�ѹ� �α��ο� ����������, ������ �� ����Ʈ�� �ٽ� ������ �� ���̵� �Է��� �� �ִ� input�� ID�� �����ְ� 
			// = cookie!
			
			Cookie c = new Cookie("lastLoginId",id); //��Ű �̸�,�� ���̵��� lastLoginID�γְ� �װ� c�� �ֱ�
			c.setMaxAge(20);	//��Ű �����ð�
			res.addCookie(c); 	//��Ű�� ���� ��ü������ �̿��ϰ�.
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
