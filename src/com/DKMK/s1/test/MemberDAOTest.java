package com.DKMK.s1.test;

import com.DKMK.s1.member.MemberDAO;
import com.DKMK.s1.member.MemberDTO;

public class MemberDAOTest {
	public static void main(String[] args) {
		
		MemberDAO memberDAO = new MemberDAO();
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("mark");
		memberDTO.setPw("pw1");
		
		try {
			memberDTO = memberDAO.login(memberDTO);
			System.out.println(memberDTO != null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		
	}
}
