package com.sr.m4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.sr.m3.Movie;
import com.sr.main.DBManager;

public class ReviewDao {

	public static void getAllReview(HttpServletRequest request) {
	 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from review_test order by r_no desc";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Review>reviews = new ArrayList<Review>();
			Review r = null;
			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getInt("r_no"));
				r.setTitle(rs.getString("r_title"));
				r.setTxt(rs.getString("r_txt"));
				r.setDate(rs.getDate("r_date"));
				
				reviews.add(r);
			}
			request.setAttribute("reviews", reviews);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void setReview(HttpServletRequest request) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into review_test values (review_test_seq.nextval,?,?, sysdate)";
		
		try {
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "��� ����!");
			} else {
				request.setAttribute("r", "��� ����!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ���� ����..");
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void getReviw(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from review_test where r_no=?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(request.getParameter("num")));

			// ����ǥ�� ä��� �����ؾߵȴ�.
			rs = pstmt.executeQuery();

			Review r = null;
			
			if (rs.next()) {
				r = new Review ();
				r.setNo(rs.getInt("r_no"));
				r.setTitle(rs.getString("r_title"));
				r.setTxt(rs.getString("r_txt"));;
				r.setDate(rs.getDate("r_date"));
				request.setAttribute("review", r);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void updateReview(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
			//��¥ ������ date�� �����ϳ�, ���Ŀ� ���� �ٸ��� //r_date = sysdate
		String sql = "update review_test set r_title = ?, r_txt = ? where r_no = ?";
		try {
			request.setCharacterEncoding("utf-8");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, request.getParameter("title"));
			pstmt.setString(2, request.getParameter("txt"));
			pstmt.setString(3, request.getParameter("num"));
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "��ϿϷ�!");
			}else {
				request.setAttribute("r", "��Ͻ���..");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void delReview(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete review_test where r_no=?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, request.getParameter("num"));
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "��� ����!");
			}else {
				request.setAttribute("r", "��� ����..");	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ��������..");	
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void searchReview(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from review_test where r_title like '%'||?||'%'";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, request.getParameter("search"));
			rs = pstmt.executeQuery();
			
			ArrayList<Review>reviews = new ArrayList<Review>();
			Review r = null;
			
			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getInt("r_no"));
				r.setTitle(rs.getString("r_title"));
				r.setTxt(rs.getString("r_txt"));
				r.setDate(rs.getDate("r_date"));
				reviews.add(r);
			}		
			request.setAttribute("reviews", reviews);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ��������..");	
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}



}
