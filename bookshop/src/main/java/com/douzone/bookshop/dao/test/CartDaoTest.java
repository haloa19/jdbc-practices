package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CartDao;
import com.douzone.bookshop.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		cartInsert(1L, 1L, 2);
		cartInsert(1L, 2L, 1);
		cartInsert(1L, 3L, 1);
		cartSelect();
	}
	
	public static void cartInsert(Long customerNo, Long bookNo, int num) {
		CartVo vo = new CartVo();
		vo.setCustomerNo(customerNo);
		vo.setBookNo(bookNo);
		vo.setNum(num);
		
		new CartDao().insert(vo);
	}
	
	private static void cartSelect() {
		List<CartVo> list = new CartDao().findAll();
		
		System.out.println("< 4. 카트 목록 >");
		System.out.println("==================================");
		for(CartVo vo : list) {
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("수량 : " + vo.getNum());
			System.out.println("가격 : " + vo.getPrice());
			System.out.println("----------------------------------");
		}
		System.out.println();
		
	}

}
