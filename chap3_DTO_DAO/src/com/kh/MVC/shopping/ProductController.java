package com.kh.MVC.shopping;

import java.util.List;

public class ProductController {

	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao=dao;
	}
	
	//�� ���� �޼ҵ�
	public double calculateTotalPrice(List<ProductDTO> products) {
		double totalprice = 0;
		//���� for���� Ȱ���Ͽ� ������ ������ ���̱� �����̴�
		for(ProductDTO totalp : products) {
			totalprice +=totalp.getPRICE();
		}
		return totalprice;
	}
	
	//��� ��ǰ ����Ʈ �޼ҵ�
	public List<ProductDTO> getAllProducts() throws Exception{
		return dao.getAllProducts();
	}
}
