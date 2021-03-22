package com.DKMK.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankBookDAO {
	
	
	public int setWrite(BankBookDTO bankBookDTO)throws Exception{
		//1. 로그인 정보 
		String user="mark02";
		String password="mark127";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. 클래스 로딩
		Class.forName(driver);
		
		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);
		
		//4. SQL
		String sql ="insert into bankbook values(bank_seq.nextval,?,?,?)";
		
		//5. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//6. ? 세팅
		st.setString(1, bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setString(3, bankBookDTO.getBookSale());

		//7. 최종 전송 후 처리
		int result = st.executeUpdate();
		
		//8. 해제
		st.close();
		con.close();
		
		return result;
		
	}
	
	
	public BankBookDTO getSelect(long bookNumber)throws Exception{
		//1. 로그인 정보 
		String user="mark02";
		String password="mark127";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		//2. 클래스 로딩
		Class.forName(driver);

		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql =" select * from bankbook where booknumber = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bookNumber);
		
		ResultSet rs = st.executeQuery();
		
		BankBookDTO bankBookDTO= null;
		
		if(rs.next()) {
			bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNumber(rs.getLong("bookNumber"));
			bankBookDTO.setBookName(rs.getString("bookName"));
			bankBookDTO.setBookRate(rs.getDouble("bookRate"));
			bankBookDTO.setBookSale(rs.getString("bookSale"));
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return bankBookDTO;

	}	

	//getList
	//bankbook table의 모든 데이터 조회 후 리턴

	public List<BankBookDTO> getList()throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<>();

		//1. 로그인 정보 
		String user="mark02";
		String password="mark127";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		//2. 클래스 로딩
		Class.forName(driver);

		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);

		//4. SQL
		String sql ="SELECT * FROM BANKBOOK";

		//5. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
	

		//7. 최종 전송 후 처리
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			BankBookDTO bankbookDTO = new BankBookDTO();
			bankbookDTO.setBookNumber(rs.getLong("bookNumber"));
			bankbookDTO.setBookName(rs.getString("bookName"));
			bankbookDTO.setBookRate(rs.getDouble("bookRate"));
			bankbookDTO.setBookSale(rs.getString("bookSale"));
			ar.add(bankbookDTO);
		}
	
		//8. 해제
		rs.close();
		st.close();
		con.close();

		return ar;
	}

}


