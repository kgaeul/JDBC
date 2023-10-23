package com.kh.dtosample;
// CafeDTO : ������ ���� ��ü 
public class CafeDTO {
	//model sql �� ���Ŀ� ���� �����͸�
	//ĸ��ȭ�ϰ� getter setter �� Ȱ���Ͽ�
	//�����͸� �����ϰ� �������� ����
	
	//�ʵ� ������� �ۼ�
	private int cafeId;
	private String cafeName;
	private String address;
	private String phoneNumber;
	private String operatingHours;
	
	//������
	//1. �⺻ ������
	public CafeDTO() {
		
	}
	//2. �Ķ���� ���� ���� ������
	public CafeDTO(int cafeId, String cafeName, String address, String phoneNumber, String operatingHours) {
		this.cafeId = cafeId;
		this.cafeName = cafeName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.operatingHours = operatingHours;
	}
	
	//Getter Setter �޼���
	public int getCafeId() {
		return cafeId;
	}
	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOperatingHours() {
		return operatingHours;
	}
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	// @Override�� Ȱ���� toString �޼��� �߰�
	@Override
	public String toString() {
		return "CafeDTO"+cafeId+address;
	}
	
	

}