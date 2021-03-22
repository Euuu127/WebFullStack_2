package com.DKMK.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.DKMK.s1.util.ActionFoward;

public class BankBookService {
	//이거 지금 null이니까 나중에 객체 집어넣어줘야
	private BankBookDAO bankBookDAO; //다른 메서드에서도 dao 가야되니까 객체는 하나만 있음 되고...
	
	
	
	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		this.bankBookDAO = bankBookDAO;
	}

	
	public ActionFoward setWrite(HttpServletRequest request) throws Exception{
		ActionFoward actionFoward = new ActionFoward();
		System.out.println("setWrite"); //메서드 되나 알아보려구
		//GET
		actionFoward.setPath("../WEB-INF/bankbook/bankbookWrite.jsp");
		actionFoward.setCheck(true); //포워드 하려구
		
		if(request.getMethod().toUpperCase().equals("POST")) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName(request.getParameter("bookName"));
			bankBookDTO.setBookRate(Double.parseDouble(request.getParameter("bookRate")));
			bankBookDTO.setBookSale(request.getParameter("bookSale"));
			//DAO 작업
			int result = bankBookDAO.setWrite(bankBookDTO);
			actionFoward.setPath("./bankbookList.do");
			actionFoward.setCheck(false);
		}
		
		
		return actionFoward;
	}
	

	public ActionFoward getSelect(HttpServletRequest request)throws Exception{
		ActionFoward actionFoward = new ActionFoward();
		
		long bookNumber = Long.parseLong(request.getParameter("bookNumber"));
		
		BankBookDTO bankBookDTO = bankBookDAO.getSelect(bookNumber);
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/bankbook/bankbookSelect.jsp");
		request.setAttribute("dto", bankBookDTO);
		
		return actionFoward;
	}
	

	//getList dao의 getList 호출 
	public ActionFoward getList(HttpServletRequest request)throws Exception{
		ActionFoward actionFoward = new ActionFoward();
		List<BankBookDTO> ar = bankBookDAO.getList();
		
		request.setAttribute("list", ar);
		actionFoward.setPath("../WEB-INF/bankbook/bankbookList.jsp");
		actionFoward.setCheck(true);
		
		
		return actionFoward;
	}
	

}
