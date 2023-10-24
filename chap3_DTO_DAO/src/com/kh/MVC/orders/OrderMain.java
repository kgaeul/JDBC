package com.kh.MVC.orders;

import java.util.List;

public class OrderMain {

	public static void main(String[] args) {
		
		OrderDAO dap = new OrderDAO();
		OrderController oc = new OrderController(dap);
		OrderView view = new OrderView();
		
		List<OrdersDTO> orders = oc.getAllOrder();
		view.showOrderList(orders);
		
		view.showtotalprice(oc.calculateprice(orders));
		
	}

}
