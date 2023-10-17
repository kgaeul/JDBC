package db;

import java.sql.*;
public class DBConnection {

	public static void main(String[] args){

		//1. 드라이버 연결 : Oracle jdbc 드라이버 클래스 이름
		String driver ="oracle.jdbc.driver.oraleDriver";
		
		//2. 오라클 내 컴퓨터 연결 : 데이터 베이스 연결 정보
										//나의 ip주소 : port번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		
		try {
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			//select 쿼리 예제
			String selectQuery ="select*from bank";
			PreparedStatement selectState =con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next() : result 객체에서 다음 행(row)으로 이동
			//다음 행이 있으면 true 반환, 그렇지 않으면 false 반환 
			while(result.next()) {
										//khbank에 있는 bank 테이블 결과집합에서 account_id를 가져옴
					int accountID = result.getInt("account_id");
					String accountName = result.getString("account_Name");
					double balance = result.getDouble("balance");
					
					//branch 이름
					String branchName = result.getString("branch_Name");
					
					//lastTransctionDate 가져오기
					Date date = result.getDate("last_Transaction_Date");
					System.out.println("lastTransctionDate : "+date);
					System.out.println("아이디 : "+accountID+" "+accountName+"의 계좌 잔액 : "+balance+"원");
					System.out.println("branchName: "+branchName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
