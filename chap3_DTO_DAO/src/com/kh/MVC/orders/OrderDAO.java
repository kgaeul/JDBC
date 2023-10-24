package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderDAO {

	private Connection connection;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="khcafe";
	String pw ="kh1234";
	
	public OrderDAO() {
		try {
			connection = DriverManager.getConnection(url,user,pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<OrdersDTO> getAllOrder(){
		List<OrdersDTO> order = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select*from orders where cafe_id=?");
			
			Scanner sc = new Scanner(System.in);
			
			boolean ischeck = true;
			
			while(ischeck) {
			System.out.println("찾으실 메뉴번호를 선택해주세요 : ");
			int cafeid = sc.nextInt();
			ps.setInt(1, cafeid);
			
			if(cafeid==0) {
				System.out.println("종료");
				ischeck=false;
			}
		
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
				int order_id = result.getInt("order_id");
				int cafe_id= result.getInt("cafe_id");
				int menu_id= result.getInt("menu_id");
				Date order_date= result.getDate("order_date");
				int quantity= result.getInt("quantity");
				int total_price= result.getInt("total_price");
				String menu_name= result.getString("menu_name");
				
				OrdersDTO DTO = new OrdersDTO(order_id, cafe_id, menu_id, order_date, quantity, total_price, menu_name);
				order.add(DTO);
				
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
		
	}
	
}
