package com.kh.MVC.orders;

import java.util.List;
import java.util.Scanner;

public class OrderView {

	public void showOrderList(List<OrdersDTO> orders) {
		
		for(OrdersDTO o : orders) {
			System.out.println("메뉴 : "+o.getMenu_name());
			System.out.println("가격 : "+o.getTotal_price());
			
			System.out.println("---------------------");
		}
	}
	public void showtotalprice(double total_price) {
		System.out.println("총 가격 : "+total_price);
	}
}
