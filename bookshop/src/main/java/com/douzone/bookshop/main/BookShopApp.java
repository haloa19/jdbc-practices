package com.douzone.bookshop.main;

import com.douzone.bookshop.dao.BookDao;
import com.douzone.bookshop.dao.CartDao;
import com.douzone.bookshop.dao.CategoryDao;
import com.douzone.bookshop.dao.MemberDao;
import com.douzone.bookshop.dao.OrderDao;
import com.douzone.bookshop.dao.test.BookDaoTest;
import com.douzone.bookshop.dao.test.CartDaoTest;
import com.douzone.bookshop.dao.test.CategoryDaoTest;
import com.douzone.bookshop.dao.test.MemberDaoTest;
import com.douzone.bookshop.dao.test.OrderDaoTest;

public class BookShopApp {

	public static void main(String[] args) {
		/* 데이터 초기화 */
		System.out.println(">>> 데이터 초기화 시작");
		OrderDao order = new OrderDao();
		order.orderBookDelete();
		order.delete();
		
		CartDao cart = new CartDao();
		cart.delete();
		
		MemberDao member = new MemberDao();
		member.delete();
		
		BookDao book = new BookDao();
		book.delete();
		
		CategoryDao category = new CategoryDao();
		category.delete();
		System.out.println("<<< 데이터 초기화 완료");
		
		/* 데이터 삽입 및 조회 */
		// 1. 카테고리 목록
		System.out.println("<<< 데이터 삽입 및 조회 시작");
		System.out.println();
		
	    new CategoryDaoTest();
		CategoryDaoTest.main(args);
		
		// 2. 도서목록
		new BookDaoTest();
		BookDaoTest.main(args);;
		
		// 3. 회원목록
		new MemberDaoTest();
		MemberDaoTest.main(args);;
		
		// 4. 카트목록
		new CartDaoTest();
		CartDaoTest.main(args);;
		
		// 5. 주문목록
		new OrderDaoTest();
		OrderDaoTest.main(args);
		
		System.out.println(">>> 데이터 삽입 및 조회 완료");

	}

}
