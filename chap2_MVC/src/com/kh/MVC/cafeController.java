package com.kh.MVC;

import java.awt.image.ColorModel;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//모델과 뷰를 가지고 올 생성자
	public cafeController(cafeModel model, cafeView view) {
		this.model=model;
		this.view=view;
	}

}
