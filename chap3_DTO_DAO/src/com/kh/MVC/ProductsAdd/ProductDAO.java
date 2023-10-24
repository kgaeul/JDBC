package com.kh.MVC.ProductsAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAO {
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "kh1234";
	
	public ProductDAO() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public List<ProductDTO> getAllProducts() throws Exception {
		List<ProductDTO> products = new ArrayList<>();
		PreparedStatement ps = connection.prepareStatement("select*from products where PRODUCT_NAME=?");
		Scanner sc = new Scanner(System.in);
		
		boolean ischeck=true;
		while(ischeck) {
		System.out.println("장바구니에 담을 제품이름을 입력해주세요 : \n종료[e]");
		String pname = sc.next();
		ps.setString(1, pname);
			if("e".equalsIgnoreCase(pname)) {
				System.out.println("종료");
				break;
			}
		}
	
		ResultSet result = ps.executeQuery();
			while(result.next()) {
				int PRODUCT_ID = result.getInt("PRODUCT_ID");
				String PRODUCT_NAME = result.getString("PRODUCT_NAME");
				String CATEGORY = result.getString("CATEGORY");
				int PRICE = result.getInt("PRICE"); 
				int STOCK_QUANTITY = result.getInt("STOCK_QUANTITY");
				
				ProductDTO product = new ProductDTO(PRODUCT_ID,PRODUCT_NAME,CATEGORY,PRICE,STOCK_QUANTITY);
				products.add(product);
				}
		return products;
	}
}
