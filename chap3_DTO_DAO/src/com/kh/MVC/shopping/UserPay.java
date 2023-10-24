package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPay {
	
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khbank";
	String pw = "kh1234";
	
	ShoppingCart cart;
	
	public UserPay(ShoppingCart cart) {
		this.cart=cart;
	}

	public boolean payment() {
		
		Connection connection = null;
		double cartTotalPrice = cart.cartTotalPrice();
		
		try {
			connection = DriverManager.getConnection(url, user, pw);
			
			//계좌 잔액 가져오기
			PreparedStatement ps = connection.prepareStatement("select*from bank where account_id=25");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Double balance = rs.getDouble("balance");
			
				if(balance<=cartTotalPrice) {
					return false;
				}
				//내가 가지고 있는 잔액에서 장바구니 총액을 빼줘야함
				double newBalance = balance - cartTotalPrice;
				
				//잔액 업데이트 하기
				PreparedStatement ps2 = connection.prepareStatement("update bank set balance = ? where account_id =25");
				ps2.setDouble(1, newBalance);
				ps2.executeUpdate();
				
				System.out.println("결제완료 \n남은 잔액 : "+newBalance);
				return true;
			}else {
				System.out.println("계좌를 찾을 수 없습니다.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
