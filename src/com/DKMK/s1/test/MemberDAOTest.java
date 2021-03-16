package com.DKMK.s1.test;

import com.DKMK.s1.member.MemberDAO;
import com.DKMK.s1.member.MemberDTO;

public class MemberDAOTest {
	public static void main(String[] args) {
		
		MemberDAO memberDAO = new MemberDAO();
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("jisung");
		memberDTO.setPw("park");
		memberDTO.setName("지성");
		memberDTO.setEmail("dream@naver.com");
		memberDTO.setPhone("01025252525");
		try {
			int result = memberDAO.memberJoin(memberDTO);
			System.out.println(memberDTO != null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		
	}
}
