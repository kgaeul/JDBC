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
			System.out.println("����");
			//product ���̺��� ������ ����
			insertProduct(ps,16,"���","������ǰ",89.99,10);
			insertProduct(ps,17,"�����","������ǰ",799.99,20);
			insertProduct(ps,18,"���콺","�޴���",79.99,33);
			
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