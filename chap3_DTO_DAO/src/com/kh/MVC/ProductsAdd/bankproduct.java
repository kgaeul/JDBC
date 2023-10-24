package com.kh.MVC.ProductsAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bankproduct {
	private String pname;
	int account_id;
	int PRICE;
	double bal;
	private Connection connection;
	private Connection bankconnection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "kh1234";
	String bankuser = "khbank";
	String bankpw ="kh1234";
	
	public static void main(String[] args) throws Exception  {
		bankproduct bp = new bankproduct();
		bp.getAllProducts();
		bp.paymoney();
	}
	
	public bankproduct() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			bankconnection = DriverManager.getConnection(url,bankuser,bankpw);
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void getAllProducts() throws Exception {
		List<ProductDTO> products = new ArrayList<>();
		PreparedStatement ps = connection.prepareStatement("select*from products where PRODUCT_NAME=?");
		PreparedStatement bankps = connection.prepareStatement("select*from bank where account_id=?");
		Scanner sc = new Scanner(System.in);
		bankps.setInt(1, account_id);
		boolean ischeck=true;
		while(ischeck) {
		System.out.println("장바구니에 담을 제품이름을 입력해주세요 : \n종료[e]");
		pname = sc.next();
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
	}
	
	public void paymoney() {
	try {
		Scanner sc = new Scanner(System.in);
		System.out.println("결제할 계좌 번호를 입력해주세요 : ");
		account_id=sc.nextInt();
		//계좌 불러오기 쿼리
		PreparedStatement selectps = bankconnection.prepareStatement("select * from bank where account_id =?");
		selectps.setInt(1, account_id);
		ResultSet rs = selectps.executeQuery();
		
		while(rs.next()){
			bal = rs.getDouble("balance");
			}
		
		//계좌 업데이트 쿼리
		PreparedStatement updateps = bankconnection.prepareStatement("update bank set balance= balance -? where account_id=?");
		if(bal>=PRICE) {
			updateps.setDouble(1,PRICE);
			updateps.setInt(2,account_id);
			updateps.executeUpdate();		
			System.out.println(account_id+"번 님의 계좌에서 "+PRICE+"원이 출금되었습니다.");
		
			while(rs.next()){
			bal = rs.getDouble("balance");
			System.out.println("계좌의 잔액 : "+bal);
				}
		}else {
			System.out.println("잔액이 부족하여 출금에 실패하였습니다.");
		}
	} catch (SQLException e) {
		e.printStackTrace();
		}
	}
}