package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank {
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String bankuser ="khbank";
	String bankpassword = "kh1234";
	int money;
	int account_id;
	int account_id2;
	double bal;
	public static void main(String[] args) throws Exception {
		Bank b = new Bank();
		b.select();
 	}

	public void select() throws SQLException{
	Connection con = DriverManager.getConnection(url,bankuser,bankpassword);
	
	Scanner sc = new Scanner(System.in);
	
	/*�۱��� ��*/
	System.out.println("�۱��� ���� �Է����ּ��� : ");
	money=sc.nextInt();
	
	/*������ ��� ����*/
	System.out.println("������ ��ȣ�� �Է����ּ��� : ");
	account_id=sc.nextInt();
	
	/*�޴� ��� ����*/
	System.out.println("�޴� ����� ��ȣ�� �Է����ּ��� : ");
	account_id2=sc.nextInt();
	
	String selectsql = "select * from bank where account_id in(?,?)";
	PreparedStatement selectps = con.prepareStatement(selectsql);
	selectps.setInt(1, account_id);
	selectps.setInt(2, account_id2);
	ResultSet rs = selectps.executeQuery();
	
	while(rs.next()){
		bal = rs.getDouble("balance");
		}
	
	String updatesql = "update bank set balance= balance -? where account_id=?";
	String updatesql2 = "update bank set balance= balance +? where account_id=?";
	PreparedStatement updateps = con.prepareStatement(updatesql);
	PreparedStatement updateps2 = con.prepareStatement(updatesql2);
	
	if(bal>=money) {
	updateps.setDouble(1,money);
	updateps.setInt(2,account_id);
	updateps.executeUpdate();
	
	updateps2.setDouble(1,money);
	updateps2.setInt(2,account_id2);
	updateps2.executeUpdate();
	
	System.out.println(account_id+"�� ���� ���¿��� "+money+"���� "+account_id2+"�� ���� ���·� �ԱݵǾ����ϴ�.");
	
		while(rs.next()){
			double bal = rs.getDouble("balance");
			System.out.println("������ �ܾ� : "+bal);
			}
		}else {
			System.out.println("�ܾ��� �����Ͽ� ��ݿ� �����Ͽ����ϴ�.");
		}
	
	}	
	
}
