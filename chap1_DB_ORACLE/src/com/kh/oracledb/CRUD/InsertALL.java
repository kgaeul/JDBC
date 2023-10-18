package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertALL {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName="khcafe";
		String userPassword="kh1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl,userName,userPassword);
			String insertSQL = "INSERT INTO products(product_id, product_name, category, price, stock_quantity)"
			+"values(?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(insertSQL);
			System.out.println("연결");
			//product 테이블에 데이터 삽입
			insertProduct(ps,16,"노북","전자제품",89.99,10);
			insertProduct(ps,17,"냉장고","가전제품",799.99,20);
			insertProduct(ps,18,"마우스","휴대기기",79.99,33);
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void insertProduct(PreparedStatement psA, int product_id, String product_name, String category, double price, int stock_quantity) throws SQLException{
		
		psA.setInt(1, product_id);
		psA.setString(2, product_name);
		psA.setString(3, category);
		psA.setDouble(4, price);
		psA.setInt(5, stock_quantity);
		psA.executeUpdate();

	}
}
