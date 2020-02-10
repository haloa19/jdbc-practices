package com.douzone.bookshop.vo;

public class OrderVo {
	private Long no;
	private String orderNo;
	private int price;
	private String address;
	private Long customerNo;
	private String customerName;
	private String email;
	private Long bookNo;
	private int num;
	private String title;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(Long customerNo) {
		this.customerNo = customerNo;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "OrderVo [orderNo=" + orderNo + ", price=" + price + ", address=" + address + ", customerName="
				+ customerName + ", email=" + email + "]";
	}
	
	public String toString2() {
		return "OrderVo [BookNo=" + bookNo + ", title=" + title + ", num=" + num + "]";
	}
	
	

}
