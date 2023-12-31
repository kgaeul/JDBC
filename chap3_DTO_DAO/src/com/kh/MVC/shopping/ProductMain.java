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
		System.out.println("[1]모든 제품 리스트 가져오기\n[2]최종 가격 계산\n[3]제품 추가\n[4]제거\n[5]최종 결제");
		//쇼핑카트 인스턴스 생성 자리
		ShoppingCart cart = new ShoppingCart();
		int choice = sc.nextInt();
		switch(choice) {
		
			case 1 : /*모든 제품 리스트 가져오기*/
				view.showProductList(products);
			
			case 2 : /*최종 가격 계산*/
				double totalprice = controller.calculateTotalPrice(products);
				view.showTotalPrice(totalprice);
			
			case 3 : /*제품 추가*/
				System.out.println("장바구니에 추가할 제품의 id를 입력하세요 : ");
				//제품 아이디 입력받기
				int productId =sc.nextInt();
				//향상된 for문과 if문을 활용해서 제품 담기
				for(ProductDTO p : products) {
					if(p.getPRODUCT_ID()==productId) {
						//카트에 추가
						cart.addCart(p);
						System.out.println("장바구니에 담았습니다.");
						break;
					}
				}
			case 4 : /*제거*/
				System.out.println("장바구니에서 제거할 아이디를 입력하세요 : ");
				int removeProductId = sc.nextInt();
				for(ProductDTO r : cart.getCartList()/*장바구니 목록*/) {
					if(r.getPRODUCT_ID()==removeProductId) {
						cart.removeGoods(r);
						break;
					}
				}
			case 5 : /*결제*/
				UserPay pay = new UserPay(cart);
				boolean payresult = pay.payment();
				if(payresult) {
					
				}
				break;
			default:
				System.out.println("잘못된 선택입니다.");
		}
	}
}
