package com.sr.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class M {

	// �α���
	public static void login(HttpServletRequest request) {
		// �α��� �ϱ� ���ؼ�
		// ����ڰ� �Է��� id, pw
		// �װ� db �� �� �ִ� �� ��
		// �� ������ ok

		// 1. ��
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");

		// 2. DB�� �� ( ���� ������ �ȵ� ) - �������� ó��
		// crud - r(select)

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from login_test2 where l_id = ?";
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// ���̵� ������ pw�˻�
				String dbPW = rs.getString("l_pw");
				
				if (userPw.equals(dbPW)) {
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

}
