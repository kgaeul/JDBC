package com.kh.MVC;

import java.util.Scanner;

public class cafeView {
		//��������� ī����� �߰�
	public cafeModel model ;

	//model �Ű������� ���� �� �ִ� �����ڸ� ��������
	public cafeView(cafeModel model) {
		this.model=model;
	}
	public void addcafeName() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�������� �Է��ϼ���");
		System.out.println("ī�� �̸� : ");
		String name = sc.next();
		System.out.println("ī�� �ּ� : ");
		String address = sc.next();
		System.out.println("ī�� ��ȣ : ");
		String phone_number = sc.next();
		System.out.println("ī�� �����ð� : ");
		String operating_hours = sc.next();
		
		//ī��𵨿��� insertcafe ��� �޼��带 ������ �;���
	model.insertcafe(name, address, phone_number, operating_hours);
	System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
	}
	
	public void updatedescription() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ʈ ������ �Է��ϼ���");
		System.out.println("���� ���� : ");
		String description = sc.next();
		System.out.println("�޴� ���̵� : ");
		int menuid = sc.nextInt();
		System.out.println("ī�� ���̵� : ");
		int cafeid = sc.nextInt();
		
		model.updatemenu(description,menuid, cafeid);
		System.out.println("�޴��� ���������� ������Ʈ �Ǿ����ϴ�.");
	}
	
	public void updateOperatinghours() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 ������Ʈ�մϴ�.");
		System.out.println("������ ī���ð��� �Է����ּ��� : ");
		String updateOh = sc.next();
		System.out.println("������ ī����̵� �Է��ϼ��� : ");
		int updatecid = sc.nextInt();
		
		model.updatecafe(updateOh,updatecid);
		System.out.println("���������� ī�� ������Ʈ!!");
	}

	public void deletecafe() {	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����մϴ�.");
		System.out.println("������ ī�� ���̵� : ");
		String cafeid = sc.next();
		
		model.deletecafe(cafeid);
		System.out.println("�����Ϸ�!");
	}

	public void deletemenuid() {
		Scanner sc = new Scanner (System.in);
		System.out.println("�޴��� �����մϴ�.");
		System.out.print("������ �޴� ���̵� : ");
		
		int menuid = sc.nextInt();
		
		model.deleteMenu(menuid);
		System.out.println("�����Ϸ�");
				
	}
}
