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
		System.out.println("��ٱ��Ͽ� ���� ��ǰ�̸��� �Է����ּ��� : \n����[e]");
		pname = sc.next();
		ps.setString(1, pname);
			if("e".equalsIgnoreCase(pname)) {
				System.out.println("����");
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
		System.out.println("������ ���� ��ȣ�� �Է����ּ��� : ");
		account_id=sc.nextInt();
		//���� �ҷ����� ����
		PreparedStatement selectps = bankconnection.prepareStatement("select * from bank where account_id =?");
		selectps.setInt(1, account_id);
		ResultSet rs = selectps.executeQuery();
		
		while(rs.next()){
			bal = rs.getDouble("balance");
			}
		
		//���� ������Ʈ ����
		PreparedStatement updateps = bankconnection.prepareStatement("update bank set balance= balance -? where account_id=?");
		if(bal>=PRICE) {
			updateps.setDouble(1,PRICE);
			updateps.setInt(2,account_id);
			updateps.executeUpdate();		
			System.out.println(account_id+"�� ���� ���¿��� "+PRICE+"���� ��ݵǾ����ϴ�.");
		
			while(rs.next()){
			bal = rs.getDouble("balance");
			System.out.println("������ �ܾ� : "+bal);
				}
		}else {
			System.out.println("�ܾ��� �����Ͽ� ��ݿ� �����Ͽ����ϴ�.");
		}
	} catch (SQLException e) {
		e.printStackTrace();
		}
	}
}