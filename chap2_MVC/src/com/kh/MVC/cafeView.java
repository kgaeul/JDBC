package com.kh.MVC;

import java.util.Scanner;

public class cafeView {
		//멤버변수로 카페모델을 추가
	public cafeModel model ;

	//model 매개변수를 받을 수 있는 생성자를 만들어야함
	public cafeView(cafeModel model) {
		this.model=model;
	}
	public void addcafeName() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("카페정보를 입력하세요");
		System.out.println("카페 이름 : ");
		String name = sc.next();
		System.out.println("카페 주소 : ");
		String address = sc.next();
		System.out.println("카페 번호 : ");
		String phone_number = sc.next();
		System.out.println("카페 영업시간 : ");
		String operating_hours = sc.next();
		
		//카페모델에서 insertcafe 라는 메서드를 가지고 와야함
	model.insertcafe(name, address, phone_number, operating_hours);
	System.out.println("카페가 성공적으로 추가되었습니다.");
	}
	
	public void updatedescription() {
		Scanner sc = new Scanner(System.in);
		System.out.println("업데이트 정보를 입력하세요");
		System.out.println("변경 정보 : ");
		String description = sc.next();
		System.out.println("메뉴 아이디 : ");
		int menuid = sc.nextInt();
		System.out.println("카페 아이디 : ");
		int cafeid = sc.nextInt();
		
		model.updatemenu(description,menuid, cafeid);
		System.out.println("메뉴가 성공적으로 업데이트 되었습니다.");
	}
	
	public void updateOperatinghours() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 업데이트합니다.");
		System.out.println("변경할 카페운영시간을 입력해주세요 : ");
		String updateOh = sc.next();
		System.out.println("변경할 카페아이디를 입력하세요 : ");
		int updatecid = sc.nextInt();
		
		model.updatecafe(updateOh,updatecid);
		System.out.println("성공적으로 카페 업데이트!!");
	}

	public void deletecafe() {	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제합니다.");
		System.out.println("삭제할 카페 아이디 : ");
		String cafeid = sc.next();
		
		model.deletecafe(cafeid);
		System.out.println("삭제완료!");
	}

	public void deletemenuid() {
		Scanner sc = new Scanner (System.in);
		System.out.println("메뉴를 삭제합니다.");
		System.out.print("삭제할 메뉴 아이디 : ");
		
		int menuid = sc.nextInt();
		
		model.deleteMenu(menuid);
		System.out.println("삭제완료");
				
	}
}
