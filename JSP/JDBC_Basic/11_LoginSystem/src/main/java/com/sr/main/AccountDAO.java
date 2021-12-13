package com.sr.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AccountDAO {
	
	public static void loginCheck(HttpServletRequest request) {
		
		//hs
		HttpSession hs = request.getSession();
		Account a  = (Account) hs.getAttribute("accountinfo");
		
		if(a == null) {
			// �α��� ����
			request.setAttribute("loginPage", "login.jsp");
		}else {
			// �α��� ����
			request.setAttribute("loginPage", "loginOK.jsp");
		}
		
	}

	public static void login(HttpServletRequest request) {
		
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");

		// 2. DB�� �� ( ���� ������ �ȵ� ) - �������� ó��
		// crud - r(select)

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from login_test3 where l_id = ?";
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// ���̵� ������ pw�˻�
				String dbPW = rs.getString("l_pw");
				
				if (userPw.equals(dbPW)) {
					
					// ���� �������ϱ� ���ļ�
					Account a = new Account();
					a.setId(rs.getString("l_id"));
					a.setPw(rs.getString("l_pw"));
					a.setName(rs.getString("l_name"));
					
					HttpSession hs = request.getSession();
					hs.setAttribute("accountinfo", a);
					hs.setMaxInactiveInterval(10);
					
					//request.setAttribute("a", a);
					
					request.setAttribute("r", "�α��� ����!");
				} else {
					request.setAttribute("r", "��й�ȣ ����!");
				}
			} else {
				request.setAttribute("r", "�������� �ʴ� ȸ�� �Դϴ�.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void logOut(HttpServletRequest request) {
		
		// �α׾ƿ� �ϴ� ��
		// ������ ������.
		// ���ʿ� ����������� ������, ������ �ð��� ����Ǿ��� ��
		HttpSession hs = request.getSession();
		hs.setAttribute("accountinfo", null);
		
	}

		
	
}
