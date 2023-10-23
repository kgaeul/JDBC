package com.kh.selectsample;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class selectDAO {

	private Connection connection;
	
	public selectDAO (Connection connection) {
		this.connection= connection;
	}
	public List<selectVO> selectuser() throws Exception {
		
		List <selectVO> selectlist = new ArrayList<>();
		String sql = "select*from user_info";
		
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet result=ps.executeQuery();
			
			while(result.next()) {
				selectVO user = new selectVO();
				user.setUserid(result.getInt("user_id"));
				user.setUsername(result.getString("user_name"));
				user.setEmail(result.getString("email"));
				user.setRegDate(result.getDate("reg_Date"));
				selectlist.add(user);
		}
		return selectlist;
		
	}
	

}
