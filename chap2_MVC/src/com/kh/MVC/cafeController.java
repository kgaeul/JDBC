package com.kh.MVC;

import java.awt.image.ColorModel;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//�𵨰� �並 ������ �� ������
	public cafeController(cafeModel model, cafeView view) {
		this.model=model;
		this.view=view;
	}

}
