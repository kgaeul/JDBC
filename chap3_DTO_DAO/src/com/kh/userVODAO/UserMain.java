package com.kh.userVODAO;


import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
public class UserMain {

	public static void main(String[] args) {

		//1.DB ���� url, username, password
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String DBusername= "khcafe";
		String DBpassword = "kh1234";
		
		try {
			Connection connection = DriverManager.getConnection(url, DBusername, DBpassword);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("UserId : ");
			int userID = sc.nextInt();
			
			System.out.println("���̵� �Է����ּ��� : ");
			String userName = sc.next();
			
			System.out.println("ȸ�������� ���� �� �������ϴ� \n���������� �̸��� �ۼ����ּ��� : ");
			String email = sc.next();
			
			Date regDate = new Date(); //���� ��¥�� �ð��� ����Ѵٴ� �ǹ�
			
			//DB�� ��� ���� �ν��Ͻ� ���� �� �ۼ����� ���������ϱ�
			UserVO newuser = new UserVO();
			newuser.setUserId(userID);
			newuser.setUserName(userName);
			newuser.setEmail(email);
			newuser.setRegDate(regDate);
			
			//�����Ͱ� ���������� ���� �� boolean���� Ȯ��
			if(userDao.createUser(newuser)) {
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
			}else {
				System.out.println("ȸ�����Կ� �����Ͽ����ϴ�.");
			}
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
