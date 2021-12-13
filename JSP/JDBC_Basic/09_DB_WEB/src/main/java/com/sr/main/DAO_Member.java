package com.sr.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// DAO(Data Access Object)
// db ���� �۾��� ����� ����
public class DAO_Member {

	public static ArrayList<Member> showAll() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();
			System.out.println("���� ����!");

			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<Member> members = new ArrayList<Member>();
			Member m = null;

			while (rs.next()) {
				m = new Member();
				m.setNo(rs.getInt("m_no"));
				m.setName(rs.getString("m_name"));
				m.setAge(rs.getInt("m_age"));
				members.add(m);
			}
			return members;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static String regMember(Member m) {

		// �� - �𵨿��� �̹� �۾� �س���
		// ��

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into member values(member_seq.nextval,?,?)";
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setInt(2, m.getAge());
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("��� ����");
				return "��ϼ���";
			}
			return "��Ͻ���";
		} catch (Exception e) {
			e.printStackTrace();
			return "DB���� ����..";
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

}
