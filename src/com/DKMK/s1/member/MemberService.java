package com.DKMK.s1.member;

import javax.servlet.http.HttpServletRequest;

import com.DKMK.s1.util.ActionFoward;

public class MemberService {
	
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	//memberLogin
	public ActionFoward memberJoin(HttpServletRequest request)throws Exception{
		//DAO 메서드 호출
		System.out.println("memberService");
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		actionFoward.setPath("../WEB-INF/member/memberJoin.jsp");
		if(method.toUpperCase().equals("POST")) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setName(request.getParameter("name"));
			memberDTO.setEmail(request.getParameter("email"));
			memberDTO.setPhone(request.getParameter("phone"));
			int result = memberDAO.memberJoin(memberDTO);
			actionFoward.setPath("../index.jsp");
			}
		
		return actionFoward;
		
		
	
	}

}
