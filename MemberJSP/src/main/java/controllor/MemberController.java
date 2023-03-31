package controllor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

@WebServlet("/member/join")
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/joinForm [GET]");
		
		// JSP파일을 view컴포턴트로 지정하고, View를 이용하여 응답하기
		// 	- RequestDispatcher 이용하여 .forward()호출
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/joinForm [POST]");
			
		int userNo = 0;
		String userName = req.getParameter("userName");
		String userNickName = req.getParameter("userNickName");
		String userEmail = req.getParameter("userEmail");
		
		Member member = new Member(userNo, userName, userNickName, userEmail);
		
		System.out.println("입력폼에서 넘겨받은 member" + member);

		Member signUp_Res = memberService.signUp(member);
		
		System.out.println("insert후 select한 member" + signUp_Res);
		
		req.setAttribute("signUp_Res", signUp_Res);
		
		req.getRequestDispatcher("/WEB-INF/views/member/result.jsp").forward(req, resp);
		
	}
}
