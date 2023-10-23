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
	
	public boolean createUser(/*파라미터값 추가*/UserVO user) {
		String sql = "insert into user_info(user_id,user_name,email,reg_Date)"
					+"values(?,?,?,?)";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getUserId());
			st.setString(2,user.getUserName());
			st.setString(3,user.getEmail());
			st.setDate(4,new Date(user.getRegDate().getTime()));
			
			int rows = st.executeUpdate();//넣었는 지 확인
			return rows > 0;//값이 들어오면 0보다 커지니까 true가 됨!!!!!!!!!!!!!
			 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false; //값이 제대로 들어오지 않으면 작동하는 공간이기 때문에 false 반환
		}
	}
	
	
	
}
