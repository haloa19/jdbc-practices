package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.MemberDao;
import com.douzone.bookshop.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		memberInsert("라이언", "01023456767", "ryon@kakao.com", "54321");
		memberInsert("어피치", "01032114567", "apeach@kakao.com", "98745");
		memberSelect();
	}
	
	public static void memberInsert(String name, String phone, String email, String password) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setPassword(password);
		
		new MemberDao().insert(vo);
	}
	
	private static void memberSelect() {
		List<MemberVo> list = new MemberDao().findAll();
		
		System.out.println("< 3. 회원 목록 >");
		System.out.println("==================================");
		for(MemberVo vo : list) {
			System.out.println("이름 : " + vo.getName());
			System.out.println("전화번호 : " + vo.getPhone());
			System.out.println("이메일 : " + vo.getEmail());
			System.out.println("비밀번호 : " + vo.getPassword());
			System.out.println("----------------------------------");
		}
		System.out.println();
		
	}

}
