package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CategoryDao;
import com.douzone.bookshop.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		categoryInsert("소설");
		categoryInsert("수필");
		categoryInsert("컴퓨터/IT");
		categorySelect();
	}

	public static void categoryInsert(String name) {
		CategoryVo vo = new CategoryVo();
		vo.setName(name);	
		new CategoryDao().insert(vo);
	}
	
	public static void categorySelect() {
		List<CategoryVo> list = new CategoryDao().findAll();
		System.out.println("< 1. 카테고리 목록 >");
		System.out.println("==================================");
		for(CategoryVo vo : list) {
			System.out.println("번호 : " + vo.getNo());
			System.out.println("카테고리 명 : " + vo.getName());
			System.out.println("----------------------------------");
		}
		System.out.println();
		
	}

}
