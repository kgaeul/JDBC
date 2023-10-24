package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<ProductDTO> cartList;
	
	//쇼핑카트 생성자
	public ShoppingCart() {
		cartList = new ArrayList<>();
	}
	
	//장바구니 목록 전달해 줄 get 메서드 생성
	public List<ProductDTO> getCartList(){
		return cartList;
	}
	
	//장바구니 최종결제 금액 메서드
	public double cartTotalPrice() {
		double totalprice =0;
		//향상된 for문 이용하여 가격 추가
		for(ProductDTO c : cartList) {
			totalprice+=c.getPRICE();
		}
		return totalprice;
	}
	
	//장바구니에 추가할 메서드 생성
	public void addCart(ProductDTO product) {
		cartList.add(product);
		System.out.println(product.getPRODUCT_NAME()+"장바구니에 추가했습니다.");
	}
	
	//장바구니에서 제거할 메서드 생성
	public void removeGoods(ProductDTO product) {
		if(cartList.remove(product)) {
			System.out.println("장바구니에서 삭제했습니다.");
		}else {
			System.out.println("장바구니에 해당제품이 없습니다.");
		}
	}
}
