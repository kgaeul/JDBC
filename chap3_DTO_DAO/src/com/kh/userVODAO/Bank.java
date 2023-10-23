package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bank {
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String bankuser ="khbank";
	String bankpassword = "kh1234";
	public static void main(String[] args) throws Exception {
		Bank b = new Bank();
		b.select(500,2,1);
 	}
	
	public void select(double money,int account_id,int account_id2) throws SQLException{
	Connection con = DriverManager.getConnection(url,bankuser,bankpassword);
		
	String updatesql = "update bank set balance= balance -? where account_id=?";
	String updatesql2 = "update bank set balance= balance +? where account_id=?";
	PreparedStatement updateps = con.prepareStatement(updatesql);
	PreparedStatement updateps2 = con.prepareStatement(updatesql2);
		
	updateps.setDouble(1,money);
	updateps.setInt(2,account_id);
	updateps.executeUpdate();
	
	updateps2.setDouble(1,money);
	updateps2.setInt(2,account_id2);
	updateps2.executeUpdate();
	
	System.out.println(account_id+"¹ø ´ÔÀÇ °èÁÂ¿¡¼­ "+money+"¿øÀÌ "+account_id2+"¹ø ´ÔÀÇ °èÁÂ·Î ÀÔ±ÝµÇ¾ú½À´Ï´Ù.");
	
	String selectsql = "select * from bank where account_id=1";
	PreparedStatement selectps = con.prepareStatement(selectsql);
	ResultSet rs = selectps.executeQuery();
	
		while(rs.next()){
			double bal = rs.getDouble("balance");
			System.out.println("°èÁÂÀÇ ÀÜ¾× : "+bal);
		}
	}
		
		
	public void asdsa() throws SQLException {
		Connection con = DriverManager.getConnection(url,bankuser,bankpassword);
		String sql = "select*from bank";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		rs.getDouble("balance");
		rs.getInt("account_id");	
	}
	
	
	
	
}
