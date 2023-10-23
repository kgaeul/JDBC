package com.kh.oracledb.CRUD;

import java.sql.*;
public class selectSample {

	public static void main(String[] args) throws Exception{
//		selectALl();
//		selectKHCAFE();
//		selectIF();

	}
	
	public static void selectAll() {

		//1. ����̹� ���� : Oracle jdbc ����̹� Ŭ���� �̸�
				String driver ="oracle.jdbc.driver.oraleDriver";
				
				//2. ����Ŭ �� ��ǻ�� ���� : ������ ���̽� ���� ����
												//���� ip�ּ� : port��ȣ
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "khbank";
				String password = "kh1234";
				Connection con = null;
				
				try {
					//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
					con = DriverManager.getConnection(url, user, password);
					System.out.println("�����ͺ��̽� ���� ����!");
					
					//select ���� ����
					String selectQuery ="select*from bank";
					PreparedStatement selectState =con.prepareStatement(selectQuery);
					ResultSet result = selectState.executeQuery();
					//result.next() : result ��ü���� ���� ��(row)���� �̵�
					//���� ���� ������ true ��ȯ, �׷��� ������ false ��ȯ 
					while(result.next()) {
						
												//khbank�� �ִ� bank ���̺� ������տ��� account_id�� ������
							int accountID = result.getInt("account_id");
							String accountName = result.getString("account_Name");
							double balance = result.getDouble("balance");
							
							//branch �̸�
							String branchName = result.getString("branch_Name");
							
							//lastTransctionDate ��������
							Date date = result.getDate("last_Transaction_Date");
							System.out.println("lastTransctionDate : "+date);
							System.out.println("���̵� : "+accountID+" "+accountName+"�� ���� �ܾ� : "+balance+"��");
							System.out.println("branchName: "+branchName);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	static void selectONE() {
		String driver = "oracle.jdbc.driver.oraleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password ="kh1234";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			String selectQuery = "select menu_name,price from menu where price>=4000";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
//			int menuid = result.getInt("menu_id");
			String menuname = result.getString("menu_name");
			int price = result.getInt("price");
//			String description = result.getString("description");

			System.out.println("�޴� : "+menuname+"\n���� : "+price);
			System.out.println();
//			System.out.println("("+menuid+")�� �޴� ["+menuname+"]�� ������ ["+price+"]���̰�, �� �޴��� ���� ������ ["+description+"] �Դϴ�. ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	static void selectIF() {
		String driver = "oracle.jdbc.driver.oraleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password ="kh1234";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String selectQuery = 
					"select * from bank "
					+ "where account_id=? ";
			
			//where�� ����Ͽ� ���� �߰�
			PreparedStatement selectState = con.prepareStatement(selectQuery);
				
			//���⿡ ���ϴ� ������ account_id ����
			int targetAID=1;
			selectState.setInt(1, 2);
			//���� ����
		
			ResultSet result = selectState.executeQuery();
		
			if(result.next()){
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				
				System.out.println("account_id : "+a);
				System.out.println("account_number : "+b);
				System.out.println("account_name : "+c);
				System.out.println("balance : "+d);
				System.out.println("branch_name : "+e);
				System.out.println("last_transaction_date : "+f);
				System.out.println();
			
			}else {
				System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void selectwhile() {
			String driver = "oracle.jdbc.driver.oraleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "khbank";
			String password ="kh1234";
			
			Connection con;
			try {
				con = DriverManager.getConnection(url, user, password);
				
				String selectQuery = 
						"select * from bank "
						+ "where account_id in(?,?) or account_number in(?,?) or account_name=? ";
				
				//where�� ����Ͽ� ���� �߰�
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				ResultSet result = selectState.executeQuery();
				
				String[] targetAN={"10","2","2222333344","1111222233","�輭��"};
				selectState.setString(1, targetAN[0]);
				selectState.setString(2, targetAN[1]);
				selectState.setString(3, targetAN[2]);
				selectState.setString(4, targetAN[3]);
				selectState.setString(5, targetAN[4]);
			
				
			
				while(result.next()){
					int a = result.getInt("account_id");
					String b = result.getString("account_number");
					String c = result.getString("account_name");
					double d = result.getDouble("balance");
					String e = result.getString("branch_name");
					Date f = result.getDate("last_transaction_date");
					
					System.out.println("["+a+"] ���¹�ȣ : "+b+c+d+e+f);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	static void practice() {
		String Driver="oracle.jdbc.driver.oracledriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="kh1234";
		
		Connection con = null;
		
		try {
			con=DriverManager.getConnection(url, user, password);
			String selectQuery="select * from book where book_id in(?,?)";
			
			String insertQuery="insert into book (?,?)values";
			PreparedStatement SelectState = con.prepareStatement(selectQuery);
			PreparedStatement InsertState = con.prepareStatement(insertQuery);

			
			InsertState.setString(1, "�ٺ�");
			
			SelectState.setInt(1, 2);
			SelectState.setInt(2, 5);
			
			
			ResultSet result = SelectState.executeQuery();
			
			while(result.next()){
			String title = result.getString("title");
			String author = result.getString("author");
			System.out.println("����: ["+title+"]   �۰�: ["+author+"]");
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
		
}
