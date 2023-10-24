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
			
			//���� �ܾ� ��������
			PreparedStatement ps = connection.prepareStatement("select*from bank where account_id=25");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Double balance = rs.getDouble("balance");
			
				if(balance<=cartTotalPrice) {
					return false;
				}
				//���� ������ �ִ� �ܾ׿��� ��ٱ��� �Ѿ��� �������
				double newBalance = balance - cartTotalPrice;
				
				//�ܾ� ������Ʈ �ϱ�
				PreparedStatement ps2 = connection.prepareStatement("update bank set balance = ? where account_id =25");
				ps2.setDouble(1, newBalance);
				ps2.executeUpdate();
				
				System.out.println("�����Ϸ� \n���� �ܾ� : "+newBalance);
				return true;
			}else {
				System.out.println("���¸� ã�� �� �����ϴ�.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
