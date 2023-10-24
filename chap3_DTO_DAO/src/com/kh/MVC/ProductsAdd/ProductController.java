package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductController {

	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao=dao;
	}
	
	//총 가격 메소드
	public double calculateTotalPrice(List<ProductDTO> products) {
		double totalprice = 0;
		//향상된 for문을 활용하여 가격을 더해줄 것이기 때문이다
		for(ProductDTO totalp : products) {
			totalprice +=totalp.getPRICE();
		}
		return totalprice;
	}
	
	//모든 제품 리스트 메소드
	public List<ProductDTO> getAllProducts() throws Exception{
		return dao.getAllProducts();
	}
}
