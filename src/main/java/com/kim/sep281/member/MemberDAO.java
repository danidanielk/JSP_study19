package com.kim.sep281.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {

			//페이지를 여기저기 다닐텐데 로그인이 되어있는지 확인이 되게끔.
	public static boolean loginCheck(HttpServletRequest req) {
		//로그인이 되었으면 아래 m 이 생성될텐ㄴ데 그게 되있는지 확인하는거
		//어트리뷰트는 자료형이 오브젝트라서 형변환 해줘야함 아래 타이핑후 오류처리 첫번째꺼로해주면됨.
		Member m = (Member) req.getSession().getAttribute("m");
		//로그인 유지중이거나 로그인에 성공했으면 10번줄이 있을것(m이 있을것) 로그인안되어있으면 null 로 되겠죠
		//로그인되었을때 생긴 m 이 null 값이 아닐 경우 true 를 리턴하게
		return (m !=null);
				
	}
	
	
	
	
	
	
			//로그인기능
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("EUC-KR");
			String id=req.getParameter("id");
			String pw = req.getParameter("qw");
			
			
			//로그인에 성공한 유저정보를 가지고 사이트 어디서든지 사용 할 수 있게
			//로그인 상태에서 사이트 접속해놓고 일정 시간 지나면 로그인 상태 풀리게
			//	= session 소속의 attribute or cookie
			//  = cookie 는 위험해요 어튜리뷰트로 해봅시다.
			if (id.equals("헬프") && pw.equals("me")) {
				Member m = new Member(id,pw);
				req.getSession().setAttribute("m", m);
			//세션의 유지시간
				req.getSession().setMaxInactiveInterval(10);
			}
			//한번 로그인에 성공했으면, 다음에 이 사이트에 다시 들어왔을 때 아이디 입려갈 수 있는 input에 ID가 남아있게 
			// = cookie!
			
			Cookie c = new Cookie("lastLoginId",id); //쿠키 이름,값 아이디값을 lastLoginID로넣고 그걸 c로 넣기
			c.setMaxAge(20);	//쿠키 유지시간
			res.addCookie(c); 	//쿠키는 응답 객체에서만 이용하게.
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
