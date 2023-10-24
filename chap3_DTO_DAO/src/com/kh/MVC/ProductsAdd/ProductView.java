package com.kh.MVC.ProductsAdd;
import java.util.List;
public class ProductView {

	public void showProductList(List <ProductDTO> products) {
		for(ProductDTO p : products ) {
			System.out.println("=========장바구니========");
			System.out.println("제품명 : "+p.getPRODUCT_NAME());
			System.out.println("가격 : "+p.getPRICE());
			
		}
	}
	
	//제품 최종 가격 메서드
	public void showTotalPrice(double totalPrice) {
		System.out.println("장바구니 총가격 : "+totalPrice);
	}
}
