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
	
	/*송금할 돈*/
	System.out.println("송금할 돈을 입력해주세요 : ");
	money=sc.nextInt();
	
	/*보내는 사람 계좌*/
	System.out.println("본인의 번호를 입력해주세요 : ");
	account_id=sc.nextInt();
	
	/*받는 사람 계좌*/
	System.out.println("받는 사람의 번호를 입력해주세요 : ");
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
	
	System.out.println(account_id+"번 님의 계좌에서 "+money+"원이 "+account_id2+"번 님의 계좌로 입금되었습니다.");
	
		while(rs.next()){
			double bal = rs.getDouble("balance");
			System.out.println("계좌의 잔액 : "+bal);
			}
		}else {
			System.out.println("잔액이 부족하여 출금에 실패하였습니다.");
		}
	
	}	
	
}
