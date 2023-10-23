package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	private Connection connection;
	
	public UserDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean createUser(/*�Ķ���Ͱ� �߰�*/UserVO user) {
		String sql = "insert into user_info(user_id,user_name,email,reg_Date)"
					+"values(?,?,?,?)";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getUserId());
			st.setString(2,user.getUserName());
			st.setString(3,user.getEmail());
			st.setDate(4,new Date(user.getRegDate().getTime()));
			
			int rows = st.executeUpdate();//�־��� �� Ȯ��
			return rows > 0;//���� ������ 0���� Ŀ���ϱ� true�� ��!!!!!!!!!!!!!
			 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false; //���� ����� ������ ������ �۵��ϴ� �����̱� ������ false ��ȯ
		}
	}
	
	
	
}
