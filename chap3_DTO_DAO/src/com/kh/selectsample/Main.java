package com.kh.selectsample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[]args) throws Exception  {
		Main m = new Main();
//		m.selectAll();
		m.selectcanner();
		
	}
	
	public void selectcanner(){
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		
		try {
			Connection cc = DriverManager.getConnection(url, user, password);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				selectVO svo = new selectVO();
				System.out.println("아이디 : ");
				System.out.println("종료 : [e]");
				String input = sc.next();
				if("e".equalsIgnoreCase(input)) {
					System.out.println("종료");
					break;
				}
				int userid = Integer.parseInt(input);
				
				System.out.println("이메일 : ");
				String email = sc.next();
				
				
				String sql ="select*from user_info where user_id = ? and email=?";
				
				PreparedStatement st = cc.prepareStatement(sql);
				st.setInt(1, userid);
				st.setString(2, email);
				ResultSet rs = st.executeQuery();
				if(rs.next()) {
					System.out.println("아이디 : "+rs.getInt("user_id"));
					System.out.println("이름 : "+rs.getString("user_name"));
					System.out.println("이메일 : "+rs.getString("email"));
					System.out.println("날짜 : "+rs.getDate("reg_date"));
					System.out.println();
				}else {
					
//					boolean itrue = rs.getInt("user_id")==userid;
//					if(!itrue) {
//						if(rs.getString("email")==email) {
//						System.out.println();
//						}
//						
//					}
					
					boolean idtrue=checkid(userid);
					boolean emailtrue = checkemail(email);
					
					if(!idtrue&&emailtrue) {
							System.out.println("일치하지 않는 아이디입니다.");
					}else if(idtrue&&!emailtrue){
						System.out.println("일치하지 않는 이메일입니다.");
					}else {
						System.out.println("둘 다 일치하지 않습니다.");
						
					}
				}
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkid(/*아이디받는 파라미터*/int userid) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select*from user_info where user_id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			int id = rs.getInt(1);
			return id >0;
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return false;
		
	}
	
	public boolean checkemail(/*아이디받는 파라미터*/String email) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select count(*) from user_info where email = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			int count = rs.getInt(1);
			return count >0;
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return false;
		
		
	}

	public void selectAll() throws Exception {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		
		try {
			Connection selectcon = DriverManager.getConnection(url, user, password);
			
			selectDAO sDAO = new selectDAO(selectcon);
			
			List<selectVO> selectlist = sDAO.selectuser();
			
			for(selectVO u : selectlist) {
			System.out.println("아이디 : "+u.getUserid());
			System.out.println("이름 : "+u.getUsername());
			System.out.println("이메일 : "+u.getEmail());
			System.out.println("날짜 : "+u.getRegDate());
			System.out.println();
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
			
}
