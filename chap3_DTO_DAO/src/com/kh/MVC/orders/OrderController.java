package com.kh.MVC.orders;

import java.util.List;

public class OrderController {

	private OrderDAO dao;
	
	public OrderController(OrderDAO dao) {
		this.dao=dao;
	}
	
	public double calculateprice(List<OrdersDTO> orders) {
		
		double price =0;
		
		for(OrdersDTO od :orders ) {
			 price += od.getTotal_price();
		}
		return price;
	}
	
	public List<OrdersDTO> getAllOrder(){
		return dao.getAllOrder();
	}
}
