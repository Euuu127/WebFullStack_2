package com.DKMK.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankBookDAO {

	//getList
	//bankbook table의 모든 데이터 조회 후 리턴

	public BankBookDTO getList(BankBookDTO bankBookDTO)throws Exception {

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

		//6. ? 세팅
		st.setInt(1, bankBookDTO.getBooknumber());
		st.setString(2, bankBookDTO.getBookname());
		st.setDouble(3, bankBookDTO.getBookrate());
		st.setString(4, bankBookDTO.getBooksale());


		//7. 최종 전송 후 처리
		ResultSet rs = st.executeQuery();
		BankBookDTO result = null; //이게 왜 .. 필요함? ㅅㅂ
		List<BankBookDTO> ar= new ArrayList<BankBookDTO>();
		while(rs.next()) {
			result = new BankBookDTO();
			result.setBooknumber(rs.getInt("booknumber"));
			result.setBookname(rs.getString("bookname"));
			result.setBookrate(rs.getDouble("bookrate"));
			result.setBooksale(rs.getString("booksale"));
		}

		//8. 해제
		rs.close();
		st.close();
		con.close();

		return result;

	}

}


