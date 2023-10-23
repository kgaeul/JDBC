package com.kh.MVC;

import java.lang.ModuleLayer.Controller;
import java.sql.*;

public class cafeModel {
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String username ="khcafe";
	String password="kh1234";
	
	public void insertcafe(String name,String address,String phone_number,String operating_hours) {
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			String sql = "insert into cafes (name,address,phone_number,operating_hours)"
					+ "values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,name);
				ps.setString(2, address);
				ps.setString(3, phone_number);
				ps.setString(4, operating_hours);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatemenu(String description,int menu_id,int cafe_id){
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql ="update menu set description = ? where menu_id =? and cafe_id =?";
			PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,description);
				st.setInt(2,menu_id);
				st.setInt(3, cafe_id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatecafe(String operating_hours, int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
		
			String sql = "update cafes set operating_hours=? where cafe_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, operating_hours);
			ps.setInt(2, cafe_id);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deletecafe(String cafe_id) {
		try {
		Connection con = DriverManager.getConnection(url, username, password);
		String deletesql ="delete cafes where cafe_id=?";
		PreparedStatement ps = con.prepareStatement(deletesql);
		ps.setString(1, cafe_id);
		ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteMenu(int menu_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String delsql = " delete menu where menu_id=?";
			PreparedStatement delps = con.prepareStatement(delsql);
			
			delps.setInt(1,menu_id);
			delps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
