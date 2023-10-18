package com.kh.oracledb.CRUD;

import java.sql.*;
public class selectSample {

	public static void main(String[] args) throws Exception{
//		selectALl();
//		selectKHCAFE();
//		selectIF();

	}
	
	public static void selectAll() {

		//1. 드라이버 연결 : Oracle jdbc 드라이버 클래스 이름
				String driver ="oracle.jdbc.driver.oraleDriver";
				
				//2. 오라클 내 컴퓨터 연결 : 데이터 베이스 연결 정보
												//나의 ip주소 : port번호
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "khbank";
				String password = "kh1234";
				Connection con = null;
				
				try {
					//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
					con = DriverManager.getConnection(url, user, password);
					System.out.println("데이터베이스 연결 성공!");
					
					//select 쿼리 예제
					String selectQuery ="select*from bank";
					PreparedStatement selectState =con.prepareStatement(selectQuery);
					ResultSet result = selectState.executeQuery();
					//result.next() : result 객체에서 다음 행(row)으로 이동
					//다음 행이 있으면 true 반환, 그렇지 않으면 false 반환 
					while(result.next()) {
												//khbank에 있는 bank 테이블 결과집합에서 account_id를 가져옴
							int accountID = result.getInt("account_id");
							String accountName = result.getString("account_Name");
							double balance = result.getDouble("balance");
							
							//branch 이름
							String branchName = result.getString("branch_Name");
							
							//lastTransctionDate 가져오기
							Date date = result.getDate("last_Transaction_Date");
							System.out.println("lastTransctionDate : "+date);
							System.out.println("아이디 : "+accountID+" "+accountName+"의 계좌 잔액 : "+balance+"원");
							System.out.println("branchName: "+branchName);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	static void selectONE() {
		String driver = "oracle.jdbc.driver.oraleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password ="kh1234";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			String selectQuery = "select menu_name,price from menu where price>=4000";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
//			int menuid = result.getInt("menu_id");
			String menuname = result.getString("menu_name");
			int price = result.getInt("price");
//			String description = result.getString("description");

			System.out.println("메뉴 : "+menuname+"\n가격 : "+price);
			System.out.println();
//			System.out.println("("+menuid+")번 메뉴 ["+menuname+"]의 가격은 ["+price+"]원이고, 이 메뉴에 대한 설명은 ["+description+"] 입니다. ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	static void selectIF() {
		String driver = "oracle.jdbc.driver.oraleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password ="kh1234";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String selectQuery = 
					"select * from bank "
					+ "where account_id=? ";
			
			//where절 사용하여 조건 추가
			PreparedStatement selectState = con.prepareStatement(selectQuery);
				
			//여기에 원하는 조건의 account_id 설정
			int targetAID=1;
			selectState.setInt(1, 2);
			//조건 설정
		
			ResultSet result = selectState.executeQuery();
		
			if(result.next()){
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				
				System.out.println("account_id : "+a);
				System.out.println("account_number : "+b);
				System.out.println("account_name : "+c);
				System.out.println("balance : "+d);
				System.out.println("branch_name : "+e);
				System.out.println("last_transaction_date : "+f);
				System.out.println();
			
			}else {
				System.out.println("조건에 해당하는 데이터가 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void selectwhile() {
			String driver = "oracle.jdbc.driver.oraleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "khbank";
			String password ="kh1234";
			
			Connection con;
			try {
				con = DriverManager.getConnection(url, user, password);
				
				String selectQuery = 
						"select * from bank "
						+ "where account_id in(?,?) or account_number in(?,?) or account_name=? ";
				
				//where절 사용하여 조건 추가
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				ResultSet result = selectState.executeQuery();
				
				String[] targetAN={"10","2","2222333344","1111222233","김서영"};
				selectState.setString(1, targetAN[0]);
				selectState.setString(2, targetAN[1]);
				selectState.setString(3, targetAN[2]);
				selectState.setString(4, targetAN[3]);
				selectState.setString(5, targetAN[4]);
			
				
			
				while(result.next()){
					int a = result.getInt("account_id");
					String b = result.getString("account_number");
					String c = result.getString("account_name");
					double d = result.getDouble("balance");
					String e = result.getString("branch_name");
					Date f = result.getDate("last_transaction_date");
					
					System.out.println("["+a+"] 계좌번호 : "+b+c+d+e+f);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	static void practice() {
		String Driver="oracle.jdbc.driver.oracledriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		
		Connection con = null;
		
		try {
			con=DriverManager.getConnection(url, user, password);
			String selectQuery="select * from book where book_id in(?,?)";
			
			String insertQuery="insert into book (?,?)values";
			PreparedStatement SelectState = con.prepareStatement(selectQuery);
			PreparedStatement InsertState = con.prepareStatement(insertQuery);

			
			InsertState.setString(1, "바보");
			
			SelectState.setInt(1, 2);
			SelectState.setInt(2, 5);
			
			
			ResultSet result = SelectState.executeQuery();
			
			while(result.next()){
			String title = result.getString("title");
			String author = result.getString("author");
			System.out.println("제목: ["+title+"]   작가: ["+author+"]");
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
		
}
