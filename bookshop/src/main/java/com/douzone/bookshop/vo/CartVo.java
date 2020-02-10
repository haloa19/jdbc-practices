package com.douzone.bookshop.vo;

public class CartVo {
	private Long customerNo;
	private Long BookNo;
	private String customerName;
	private String title;
	private int num;
	private int price;
	
	public Long getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(Long customerNo) {
		this.customerNo = customerNo;
	}
	public Long getBookNo() {
		return BookNo;
	}
	public void setBookNo(Long bookNo) {
		BookNo = bookNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "CartVo [customerName=" + customerName + ", title=" + title + ", num=" + num + ", price=" + price + "]";
	}
	
}
