package com.sr.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

public class M {

	public static void call(HttpServletRequest request) {
		String name = request.getParameter("n");
		String age = request.getParameter("a");
		
		System.out.println(name);
		System.out.println(age);
		
	}
	
	public static void reg(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String name = request.getParameter("n");
			String age = request.getParameter("a");
			
			String sql = "insert into nameage values(?, ?)";

			//con = DriverManager.getConnection(url, "c##sr", "sr");
			// �����Ÿ� �Լ��� ���� �Ʒ��� ���� ��
			con = DBManager.connect();
			
			System.out.println("���� ����");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, age);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "success!");
			}else {
				request.setAttribute("r", "error..");
			}
			
		} catch (Exception e) {
			request.setAttribute("r", "DB Server Error..");
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);			
		}
	

	}

	public static void result(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();

			System.out.println("���� ����");
			
			String sql = "select * from nameage";
			pstmt = con.prepareStatement(sql);
			
			//select�� �ʿ�
			rs = pstmt.executeQuery();
			
			
			//rs.next() : ���� ���ڵ�� ���� ���(ȭ��ǥ �Ʒ��� ������)
			//				���� �����Ͱ� ������ true, ������ false

			ArrayList<NameAge> nameAges  = new ArrayList<NameAge>();
			
			while (rs.next()) {
				//rs.getXX("�÷�") : ���� ȭ��ǥ  ��ġ�� �÷� �� ��������
				System.out.println(rs.getString("n_name"));				
				System.out.println(rs.getInt("n_age"));
				System.out.println("------------------");

				nameAges.add(new NameAge(rs.getString("n_name"), rs.getInt("n_age")));
			}
			request.setAttribute("nameage", nameAges);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
			}
		
	}
	
	
	
}
