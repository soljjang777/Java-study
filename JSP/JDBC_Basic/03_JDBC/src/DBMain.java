import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) throws SQLException {
	      
	      // DB ���� �۾�
	      // 1���� : DB ����
	      // ������ �ø���
	      // ���ϵ� CRUD
	      
	      // ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("���� ����!");
		
		// ���� ����
		Statement st = con.createStatement();
		
		// ��� ���
		String sql = "select * from db_test";
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println(rs.getString("d_name"));
			System.out.println(rs.getInt("d_age"));
			System.out.println("------------");
		}
		rs.close();
		st.close();
		con.close();


	}
}
