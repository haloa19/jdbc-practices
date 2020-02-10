package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CartVo;

public class CartDao {
	
	/* 카트리스트 조회 */
	public List<CartVo> findAll() {
		List<CartVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();

			String sql = "select c.no, b.no, c.name, b.title, a.num, b.price * a.num\r\n" + 
					"from cart a \r\n" + 
					"	join book b on a.book_no = b.no \r\n" + 
					"    join customer c on a.customer_no = c.no";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long customerNo = rs.getLong(1);
				Long bookNo = rs.getLong(2);
				String customerName = rs.getString(3);
				String title = rs.getString(4);
				int num = rs.getInt(5);
				int price = rs.getInt(6);
				
				CartVo vo = new CartVo();
				vo.setCustomerNo(customerNo);
				vo.setBookNo(bookNo);
				vo.setCustomerName(customerName);
				vo.setTitle(title);
				vo.setNum(num);
				vo.setPrice(price);
				
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
	
	/* 카트 삽입  */
	public Boolean insert(CartVo cartVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into cart values(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, cartVo.getCustomerNo());
			pstmt.setLong(2, cartVo.getBookNo());
			pstmt.setInt(3, cartVo.getNum());
			
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
	
	/* 카트리스트 삭제 */
	public boolean delete() {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql;
			
			sql = "delete from cart";

			pstmt = conn.prepareStatement(sql);
			
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
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			conn = DriverManager.getConnection(url, "bookshop", "bookshop");
		}  catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		}
		
		return conn;
	}
	

}
