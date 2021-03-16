package com.DKMK.s1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DKMK.s1.util.ActionFoward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
		MemberDAO memberDAO = new MemberDAO();
		memberService.setMemberDAO(memberDAO);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Member Controller!!!!!!");

		String path = request.getServletPath();
		String uri = request.getRequestURI();
		System.out.println(path);
		System.out.println(uri);

		String result=" ";
		//subString으로 마지막 주소만 꺼내오기
		//1. 자르려고 하는 시작 인덱스 번호 찾기
		int index = uri.lastIndexOf("/");


		//2. 해당 인덱스부터 잘라오기
		result = uri.substring(index);
		System.out.println(result);
		String pathInfo="" ;
		ActionFoward actionFoward = null;
		if(result.equals("/memberLogin.do")) {
			System.out.println("로그인 처리");
			pathInfo="../WEB-INF/member/memberLogin.jsp";
		} else if(result.equals("/memberJoin.do")) {
			//method 구분

			try {
				actionFoward=memberService.memberJoin(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * String method = request.getMethod(); //get, post
			 * 
			 * System.out.println("회원가입 처리"); pathInfo="../WEB-INF/member/memberJoin.jsp";
			 */
		} else {
			System.out.println("그외 다른 처리");
		}

		//forward
		RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
		view.forward(request, response);




		/*
		 * String id = request.getParameter("id"); String pw =
		 * request.getParameter("pw"); System.out.println("id: "+id);
		 * System.out.println("pw: "+pw);
		 * 
		 * MemberDAO memberDAO = new MemberDAO(); MemberDTO memberDTO = new MemberDTO();
		 * memberDTO.setId(id); memberDTO.setPw(pw); String result= " "; try { memberDTO
		 * = memberDAO.login(memberDTO);
		 * 
		 * if(memberDTO != null) { result = "로그인 성공"; }else { result = "로그인 실패"; } }
		 * catch (Exception e) { // TODO Auto-generated catch block e.printStackTrace();
		 * } //attribute request.setAttribute("r", result);
		 * 
		 * //attribute에 로그인한 MemberDTO request.setAttribute("dto", memberDTO);
		 * 
		 * //forward RequestDispatcher view =
		 * request.getRequestDispatcher("./memberResult.jsp"); view.forward(request,
		 * response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
