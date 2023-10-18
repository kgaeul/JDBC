package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertExam {

public static void main(String[] args) throws SQLException {
		pratice3();
	}
	static void kbank() {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khbank";
	String password="kh1234";
			
		Connection con = null;

		try {
			con= DriverManager.getConnection(url, user, password);
			String insertbank ="INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
					+ "values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertbank);
			
			insertb(ps,25,"522214524","바부",12312321,"히힛","2020-12-12");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		static void insertb(PreparedStatement ps, int account_id, String account_number, String account_name,double balance, String branch_name,String last_transaction_date) throws SQLException {
			
			ps.setInt(1, account_id);
			ps.setString(2, account_number);
			ps.setString(3, account_name);
			ps.setDouble(4, balance);
			ps.setString(5, branch_name);
			ps.setString(6, last_transaction_date);
			ps.executeUpdate();
		}

	static void kbook() {
		
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("연결완료");
			String insertbank = "INSERT INTO book (book_id, title, author, publication_year, isbn, genre, description, price)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			
			PreparedStatement bankps = con.prepareStatement(insertbank);
			
//			insertbk(bankps,24, "다빈치코드", "댄 브라운", 2003, "0-385-50420-9", "미스터리 추리물", "기호학자 로버트 랭던이 파리의 루브르 박물관에서 벌어진 살인 사건을 조사하면서 벌어지는 이야기", 12000);
//			bankps.close();
			
			String selectQuery ="select * from book where book_id in(?,?) ";
			PreparedStatement selectbook = con.prepareStatement(selectQuery);
			
			selectbook.setInt(1, 24);
			selectbook.setInt(2, 10);
			
			ResultSet result = selectbook.executeQuery();
			
			while(result.next()) {
				String bookname = result.getString("title");
				String bookauthor = result.getString("author");
				String bookdct = result.getString("description");
				System.out.println("제목 : ["+bookname+"] 작가 : ["+bookauthor+"]\n 설명 : "+bookdct+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void insertbk(PreparedStatement bankps,int book_id,String title, String author, int publication_year, String isbn, String genre, String description, int price) throws SQLException {
		bankps.setInt(1,book_id);
		bankps.setString(2,title);
		bankps.setString(3,author);
		bankps.setInt(4,publication_year);
		bankps.setString(5,isbn);
		bankps.setString(6,genre);
		bankps.setString(7,description);
		bankps.setInt(8,price);
		
		int updt = bankps.executeUpdate();
				System.out.println("업데이트완료");
	}
	static void pratice() throws SQLException {
		
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "user";
		String password = "password";
		
		Connection con = DriverManager.getConnection(url,user,password);
		
		String pQuery ="select*from tablename";
		PreparedStatement selectstate = con.prepareStatement(pQuery);
		
		ResultSet result = selectstate.executeQuery();
		
		while(result.next()) {
			String str = result.getString("str");
			int itgr = result.getInt("itgr");
			
			System.out.println(str+itgr);
		}
	}
	static void practice2() throws SQLException {
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user="user2";
			String password = "user1234";
			
			Connection con = null;
			con = DriverManager.getConnection(url,user,password);
			
			String pQuery2 = "insert into tablename (name) "
					+ "values ?";
			PreparedStatement insertstate = con.prepareStatement(pQuery2);
			insertstate.setString(1,"김가을");
			
			insertstate.executeUpdate();
			
			
		}
	static void pratice3() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="khstore";
		String password="KHSTORE";
		
			try {
				Connection con = DriverManager.getConnection(url,user,password);
				System.out.println("연결완료");
				String insertQuery = "insert into memberinfo(mno,mname,memail,mbirth)values(?,?,?,?)";
				PreparedStatement insertstate = con.prepareStatement(insertQuery);
				
				String selectQuery ="select*from memberinfo";
				PreparedStatement selectstate = con.prepareStatement(selectQuery);
				
				ResultSet result = selectstate.executeQuery();
				
				while(result.next()) {
					String mname= result.getString("mname");
					String memail = result.getString("memail");
					Date mbirth = result.getDate("mbirth");
					System.out.println("이름: "+mname+" 이메일 : "+memail+" 생일 : "+mbirth);
				}
				
				inserts(insertstate,22,"돌의 정령","stone@example",Date.valueOf("2023-12-25"));
				
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	static void inserts(PreparedStatement ps,int mno,String mname,String memail,Date mbirth) throws SQLException {
		ps.setInt(1, mno);
		ps.setString(2, mname);
		ps.setString(3, memail);
		ps.setDate(4, mbirth);
//			ps.executeUpdate();
		System.out.println("업데이트 완료");
		
	}
}
