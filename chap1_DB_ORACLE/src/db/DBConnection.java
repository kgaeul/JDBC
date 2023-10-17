package db;

import java.sql.*;
public class DBConnection {

	public static void main(String[] args){

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

}