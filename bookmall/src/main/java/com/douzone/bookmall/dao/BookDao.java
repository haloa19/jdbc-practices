package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.BookVo;

public class BookDao {
	AuthorDao authorDao = new AuthorDao();
	Long tmp;
	
	public List<BookVo> findAll() {
		List<BookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = authorDao.getConnection();

			String sql = "select a.no, a.title, a.state, a.author_no, b.name from book a, author b where a.author_no = b.no";
			
			pstmt = conn.prepareStatement(sql);
		
			rs = pstmt.executeQuery();
	
			while(rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String state = rs.getString(3);
				Long authorNo = rs.getLong(4);
				String authorName = rs.getString(5);
			
				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setState(state);
				vo.setAuthorNo(authorNo);
				vo.setAuthorName(authorName);				
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {	
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		}	
		
		return result;
		
	}
	
	public Boolean insert(BookVo bookVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = authorDao.getConnection();

			String sql = "insert into book values(null, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getState());
			pstmt.setLong(3, bookVo.getAuthorNo());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {	
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}

	public void update(Long no, String string) {
		//Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = authorDao.getConnection();

			String sql = "update book set state = '?' where no = ?";
			System.out.println(no + " " + string);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, string);
			pstmt.setLong(2, no);
			
			int count = pstmt.executeUpdate();
			
			//result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {	
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
