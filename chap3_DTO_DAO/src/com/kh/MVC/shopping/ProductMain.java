package com.kh.MVC.shopping;

import java.util.List;
import java.util.Scanner;

import com.kh.MVC.shopping.ShoppingCart;

public class ProductMain {

	public static void main(String[] args) throws Exception {

		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		List<ProductDTO> products= controller.getAllProducts();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("[1]��� ��ǰ ����Ʈ ��������\n[2]���� ���� ���\n[3]��ǰ �߰�\n[4]����\n[5]���� ����");
		//����īƮ �ν��Ͻ� ���� �ڸ�
		ShoppingCart cart = new ShoppingCart();
		int choice = sc.nextInt();
		switch(choice) {
		
			case 1 : /*��� ��ǰ ����Ʈ ��������*/
				view.showProductList(products);
			
			case 2 : /*���� ���� ���*/
				double totalprice = controller.calculateTotalPrice(products);
				view.showTotalPrice(totalprice);
			
			case 3 : /*��ǰ �߰�*/
				System.out.println("��ٱ��Ͽ� �߰��� ��ǰ�� id�� �Է��ϼ��� : ");
				//��ǰ ���̵� �Է¹ޱ�
				int productId =sc.nextInt();
				//���� for���� if���� Ȱ���ؼ� ��ǰ ���
				for(ProductDTO p : products) {
					if(p.getPRODUCT_ID()==productId) {
						//īƮ�� �߰�
						cart.addCart(p);
						System.out.println("��ٱ��Ͽ� ��ҽ��ϴ�.");
						break;
					}
				}
			case 4 : /*����*/
				System.out.println("��ٱ��Ͽ��� ������ ���̵� �Է��ϼ��� : ");
				int removeProductId = sc.nextInt();
				for(ProductDTO r : cart.getCartList()/*��ٱ��� ���*/) {
					if(r.getPRODUCT_ID()==removeProductId) {
						cart.removeGoods(r);
						break;
					}
				}
			case 5 : /*����*/
				UserPay pay = new UserPay(cart);
				boolean payresult = pay.payment();
				if(payresult) {
					
				}
				break;
			default:
				System.out.println("�߸��� �����Դϴ�.");
		}
	}
}
