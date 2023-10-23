package com.kh.userVODAO;


import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
public class UserMain {

	public static void main(String[] args) {

		//1.DB 연결 url, username, password
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String DBusername= "khcafe";
		String DBpassword = "kh1234";
		
		try {
			Connection connection = DriverManager.getConnection(url, DBusername, DBpassword);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("UserId : ");
			int userID = sc.nextInt();
			
			System.out.println("아이디를 입력해주세요 : ");
			String userName = sc.next();
			
			System.out.println("회원가입이 거의 다 끝났습니다 \n마지막으로 이메일 작성해주세요 : ");
			String email = sc.next();
			
			Date regDate = new Date(); //현재 날짜와 시간을 사용한다는 의미
			
			//DB에 담기 위해 인스턴스 생성 후 작성받은 정보저장하기
			UserVO newuser = new UserVO();
			newuser.setUserId(userID);
			newuser.setUserName(userName);
			newuser.setEmail(email);
			newuser.setRegDate(regDate);
			
			//데이터가 정상적으로 들어갔는 지 boolean으로 확인
			if(userDao.createUser(newuser)) {
				System.out.println("회원가입이 완료되었습니다.");
			}else {
				System.out.println("회원가입에 실패하였습니다.");
			}
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
