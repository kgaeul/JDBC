package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class updateSample {

	public static void main(String[] args) {
//		selectcafe();
//		insertcafe();
		change8();
	}
	static void sele() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="khbank";
		String password="kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
//			String updateQuery = "delete from bank where account_id=?";
//			PreparedStatement updatestate = con.prepareStatement(updateQuery);
//			
//			int num =3;
//			updatestate.setDouble(1,num);

			String selectQuery = "select*from bank ";
			PreparedStatement selectstate = con.prepareStatement(selectQuery);
			ResultSet result= selectstate.executeQuery();
			while(result.next()) {
			String acname = result.getString("account_name");
//			updatestate.executeUpdate();
			System.out.println(acname+"�� �����ܾ� �����Ϸ�");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void selectcafe() {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("���ӿϷ�");
			
/*1*/		String selectQuery="select name from cafes ";
			PreparedStatement selectstate = con.prepareStatement(selectQuery);
			ResultSet result = selectstate.executeQuery();
/*2*/		String selectQuery2="select menu_name from menu where cafe_id= 12";
			PreparedStatement selectstate2 = con.prepareStatement(selectQuery2);
			ResultSet result2 = selectstate2.executeQuery();
			
			while(result2.next()) {
//				String cafe_id = result.getString("cafe_id");
				String mname = result2.getString("menu_name");
//				String address = result.getString("address");
//				String phone_number = result.getString("phone_number");
//				String OPERATINGHOURS = result.getString("OPERATING_HOURS");
		
				System.out.println("�޴� �̸� : "+mname);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	static void insertcafe() {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery ="insert into cafes(cafe_id,name,address,phone_number,OPERATING_HOURS) "
					+ "values(?,?,?,?,?)";
			PreparedStatement insertstate = con.prepareStatement(insertQuery);
			insertstate(insertstate,40,"����ī��","���ѹα� ���","000-0000-0000","�Ϸ�����");
			insertstate(insertstate,42,"�ƹ�ī��","���ѹα� ���","000-0000-0000","�Ϸ�����");					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void insertstate(PreparedStatement insertstate,int cafe_id,String name,String address,String phone_number,String OPERATING_HOURS) throws SQLException {
		insertstate.setInt(1, cafe_id);
		insertstate.setString(2, name);
		insertstate.setString(3, address);
		insertstate.setString(4, phone_number);
		insertstate.setString(5, OPERATING_HOURS);
		insertstate.executeUpdate();
	}
	static void change() {//4�޴������ϱ�
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String updateQuery ="update menu set menu_name=? where menu_id=?";
			
			PreparedStatement updatestate = con.prepareStatement(updateQuery);
			updatestate.setString(1, "����޺�");
			updatestate.setInt(2, 18);
			updatestate.executeUpdate();
			System.out.println("�����Ϸ�");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void change2() {//5���� �����ϱ�
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String updateQuery = "update menu set DESCRIPTION=? where menu_id=?";
			
			PreparedStatement updatestate=con.prepareStatement(updateQuery);
			updatestate.setString(1,"�ظ����Ϳ� �������� ��ȭ ���� ������ �ξ� ���");
			updatestate.setInt(2,22);
			updatestate.executeUpdate();
			System.out.println("�����Ϸ�");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void change3() {//6���� �����ϱ�
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String deleteQuery = "delete cafes where cafe_id=?";
			PreparedStatement deletestate =con.prepareStatement(deleteQuery);
			deletestate.setInt(1,52);
			deletestate.executeUpdate();
		System.out.println("�����Ϸ�");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void change4() {//7�޴��� ��������
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String selectQuery = "select Count(menu_name) from menu where cafe_id=?";
			PreparedStatement selectstate = con.prepareStatement(selectQuery);
			
			selectstate.setInt(1, 26);
			
			ResultSet result = selectstate.executeQuery();
			
			while(result.next()) {
				int num = result.getInt("count(menu_name)");
				System.out.println("�޴� �� : "+num);
			}
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Ư������ �������� ��� �޴�
	}
	static void change5() {//Ư������ �������� ��� �޴�
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, password);
			String selectQuery = "select menu_name,price from menu where price between ? and ?";
			PreparedStatement selectstate = con.prepareStatement(selectQuery);
			selectstate.setInt(1,4000);
			selectstate.setInt(2,5000);
			
			ResultSet result = selectstate.executeQuery();
				while(result.next()) {
				String name = result.getString("menu_name");	
				String name2 = result.getString("price");	
				System.out.println("�˻� ��� : "+name +" "+name2);
				}
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	static void change6() {//Ư������ �������� ��� �޴�
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, password);
			String selectQuery = "select * from cafes ";
			PreparedStatement selectstate = con.prepareStatement(selectQuery);
			
			ResultSet result = selectstate.executeQuery();
				while(result.next()) {
				String name = result.getString("name");	
				String name2 = result.getString("address");	
				System.out.println("�˻� ��� : ["+name +"] "+name2);
				}
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	static void change7() {//Ư������ �������� ��� �޴�
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, password);
			String updateQuery = "update cafes set OPERATING_HOURS=? where cafe_id =? ";
			PreparedStatement updatestate = con.prepareStatement(updateQuery);
			
			
			updatestate.setString(1, "����");
			updatestate.setInt(2, 2);
			updatestate.executeUpdate();
			System.out.println("����Ϸ�");
				
			String selectQuery = "select*from cafes";
			PreparedStatement selectstate = con.prepareStatement(selectQuery);
			
			
			ResultSet result = selectstate.executeQuery();
			while(result.next()) {
			String name=result.getString("name");
			String d = result.getString("OPERATING_HOURS");
			System.out.println(name+" "+d);
	
			System.out.println();
			}
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	static void change8() {//Ư������ �������� ��� �޴�

		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, password);
			String updateQuery = "update cafes set phone_number=? where cafe_id =? ";
			PreparedStatement updatestate = con.prepareStatement(updateQuery);
			
			
			updatestate.setString(1, "000-0000-0000");
			updatestate.setInt(2, 2);
			updatestate.executeUpdate();
			System.out.println("����Ϸ�");
				
			String selectQuery = "select*from cafes";
			PreparedStatement selectstate = con.prepareStatement(selectQuery);
			
			
			ResultSet result = selectstate.executeQuery();
			while(result.next()) {
			String name=result.getString("name");
			String d = result.getString("phone_number");
			System.out.println(name+" "+d);
	
			System.out.println();
			}
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
