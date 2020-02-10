package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.OrderDao;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDaoTest {
	static OrderVo vo = new OrderVo();

	public static void main(String[] args) {
		orderInsert("00011", 58000, "서울시 동대문구 장안벚꽃로", 1L);		
		orderSelect();
		orderBookInsert(1L, 1L, 2);
		orderBookInsert(1L, 2L, 1);
		orderBookSelect();
	}
	
	public static void orderInsert(String orderNo, int price, String address, Long customerNo) {		
		vo.setOrderNo(orderNo);
		vo.setPrice(price);
		vo.setAddress(address);
		vo.setCustomerNo(customerNo);
		
		new OrderDao().insert(vo);
	}
	
	private static void orderSelect() {
		List<OrderVo> list = new OrderDao().findAll();

		System.out.println("< 5. 주문 목록 >");
		System.out.println("==================================");
		for(OrderVo vo : list) {
			System.out.println("주문번호 : " + vo.getOrderNo());
			System.out.println("이름 : " + vo.getCustomerName());
			System.out.println("이메일 : " + vo.getEmail());
			System.out.println("결제금액 : " + vo.getPrice());
			System.out.println("배송지 : " + vo.getAddress());
			System.out.println("----------------------------------");
		}
		System.out.println();
		
	}
	
	public static void orderBookInsert(Long no, Long bookNo, int num) {
		vo.setNo(no);
		vo.setBookNo(bookNo);
		vo.setNum(num);
		
		new OrderDao().orderBookInsert(vo);
	}
	
	private static void orderBookSelect() {
		List<OrderVo> list = new OrderDao().orderBookFind();

		System.out.println("< 6. 주문도서 목록 >");
		System.out.println("==================================");
		for(OrderVo vo : list) {
			System.out.println("책번호 : " + vo.getBookNo());
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("수량 : " + vo.getNum());
			System.out.println("----------------------------------");
		}
		System.out.println();
		
	}

}
