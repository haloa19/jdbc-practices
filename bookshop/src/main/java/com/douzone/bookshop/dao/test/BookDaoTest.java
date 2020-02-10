package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.BookDao;
import com.douzone.bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		bookInsert("트와일라잇", 12000, 1L);
		bookInsert("아프니까청춘이다", 10000, 2L);
		bookInsert("이것이자바다", 25000, 3L);
		bookSelect();
	}

	public static void bookInsert(String title, int price, Long categoryNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPricce(price);
		vo.setCategoryNo(categoryNo);
		
		new BookDao().insert(vo);
	}
	
	public static void bookSelect() {
		List<BookVo> list = new BookDao().findAll();
		
		System.out.println("< 2. 도서 목록 >");
		System.out.println("==================================");
		for(BookVo vo : list) {
			System.out.println("카테고리 명 : " + vo.getCategoryName());
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("가격 : " + vo.getPricce());
			System.out.println("----------------------------------");
		}
		System.out.println();
		
	}

}
