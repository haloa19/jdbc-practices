package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.OrderVo;

public class OrderDao {
	
	/* 주문 조회 */
	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();

			String sql = "select a.order_no, b.name, b.email, a.price, a.address \r\n" + 
						"from orders a \r\n" + 
						"	join customer b on a.customer_no = b.no";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String orderNo = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int price = rs.getInt(4);
				String address = rs.getString(5);
				
				OrderVo vo = new OrderVo();
				vo.setOrderNo(orderNo);;
				vo.setCustomerName(name);
				vo.setEmail(email);
				vo.setPrice(price);
				vo.setAddress(address);
				
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
	
	/* 주문 도서 조회 */
	public List<OrderVo> orderBookFind() {
		List<OrderVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();

			String sql = "select a.book_no, b.title, a.num \r\n" + 
						"from order_book a \r\n" + 
						"	join book b on a.book_no = b.no";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long bookNo = rs.getLong(1);
				String title = rs.getString(2);
				int num = rs.getInt(3);
				
				OrderVo vo = new OrderVo();
				vo.setBookNo(bookNo);
				vo.setTitle(title);
				vo.setNum(num);
				
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
	
	/* 주문 삽입 */
	public Boolean insert(OrderVo orderVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into orders values(null, concat(date_format(now(), '%Y%m%d'), '-', ?), ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, orderVo.getOrderNo());
			pstmt.setInt(2, orderVo.getPrice());
			pstmt.setString(3, orderVo.getAddress());
			pstmt.setLong(4, orderVo.getCustomerNo());

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
	
	/* 주문도서 삽입 */
	public Boolean orderBookInsert(OrderVo orderVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into order_book values(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, orderVo.getNo());
			pstmt.setLong(2, orderVo.getBookNo());
			pstmt.setInt(3, orderVo.getNum());
			
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
	
	public boolean delete() {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "delete from orders";
			String sql2 = "alter table orders auto_increment = 1";

			pstmt = conn.prepareStatement(sql);
			
			int count = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql2);
			
			int count2 = pstmt.executeUpdate();		
			
			result = count == 1 && count2 == 1;
			
			
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
	
	public boolean orderBookDelete() {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "delete from order_book";

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
