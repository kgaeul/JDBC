package com.kh.MVC.shopping;
import java.util.List;
public class ProductView {

	public void showProductList(List <ProductDTO> products) {
		for(ProductDTO p : products ) {
			System.out.println("=========��ٱ���========");
			System.out.println("��ǰ�� : "+p.getPRODUCT_NAME());
			System.out.println("���� : "+p.getPRICE());
			
		}
	}
	
	//��ǰ ���� ���� �޼���
	public void showTotalPrice(double totalPrice) {
		System.out.println("��ٱ��� �Ѱ��� : "+totalPrice);
	}
	
	public void showTotalbal(double bal) {
		System.out.println(" �����ܾ� : "+bal);
	}

}
