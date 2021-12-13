package com.sr.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB���� �۾��� �Ҷ� �Ź� �����ڵ� �� ���� �۾� �ؿ�

// �װ� AOP ���ڴ°�

public class DBManager {
	
	// db�۾��ÿ� ��¶�� ���� �ؾߵ�
	public static Connection connect() throws SQLException {
				
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		return DriverManager.getConnection(url, "c##sr", "sr");
		
	}
	
	// ������ ������ �ѹ��� �ݱ� 
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			if(rs != null) {
				rs.close();				
			}
		} catch (SQLException e) {
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}
}
