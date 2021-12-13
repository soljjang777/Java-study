import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) throws SQLException {
	      
	      // DB 관련 작업
	      // 1순위 : DB 연결
	      // 껍데기 시리즈
	      // 뭘하든 CRUD
	      
	      // 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("연결 성공!");
		
		// 실행 도구
		Statement st = con.createStatement();
		
		// 결과 얻기
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
