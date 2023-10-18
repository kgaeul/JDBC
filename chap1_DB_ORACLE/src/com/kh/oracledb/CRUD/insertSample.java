package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertSample {

	public static void main(String[] args) {
	
	}
	static void  머시기() {
		
	}
	
	static void insertBank()  {
		String Driver="oracle.jdbc.driver.oracledriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khbank";
		String password="kh1234";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
					+ "values(?,?,?,?,?,?)";
			PreparedStatement insertstate = con.prepareStatement(insertQuery);
			insertstate.setInt(1, 18);
			insertstate.setString(2,"1231453514");
			insertstate.setString(3, "김여름");
			insertstate.setDouble(4,1000000);
			insertstate.setString(5,"롯데월드");
			insertstate.setDate(6,Date.valueOf("2023-12-25"));
			
			int rowsInsert =insertstate.executeUpdate();
			System.out.println(rowsInsert);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	static void insertkhcafe() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="khcafe";
		String password ="kh1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		
		String insertQuery ="insert into menu(menu_id,cafe_id,menu_name,price,description)"
				+ "values(?,?,?,?,?)";
		String Updatequery = "update menu set price=? where menu_id = ?";
		String Deletequery = "delete menu where menu_id=20";
		String SelectQuery = "select*from menu where menu_id in (?,?,?)";
		
		PreparedStatement insertstate = con.prepareStatement(insertQuery);
		PreparedStatement Updatestate= con.prepareStatement(Updatequery);
		PreparedStatement deleteState = con.prepareStatement(Deletequery);
		PreparedStatement selectstate= con.prepareStatement(SelectQuery);
		
		selectstate.setInt(1,1);
		selectstate.setInt(2,2);
		selectstate.setInt(3,3);
		
		ResultSet result = selectstate.executeQuery();
		
		if(result.next()) {
			String menuname = result.getString("menu_name");
			String price = result.getString("price");
			String description = result.getString("description");
		System.out.println("메뉴 : ["+menuname+"] 가격 : ["+price+"] 설명 : ["+description+"]");
		int dupdate = deleteState.executeUpdate();
		}
		
		insertstate.setInt(1, 22);
		insertstate.setInt(2,38);
		insertstate.setString(3, "개구리초콜렛");
		insertstate.setInt(4, 4700);
		insertstate.setString(5, "해리포터에 나옴");
//		insertstate.setInt(6, 4);
//		insertstate.setInt(7, 4);
		
		
		
		Updatestate.setInt(1, 30000);
		Updatestate.setInt(2, 18);
		
		
		int rowsUpdate = Updatestate.executeUpdate();
//		int rowsInsert = insertstate.executeUpdate();
//		System.out.println(rowsInsert);

		
	}
}
