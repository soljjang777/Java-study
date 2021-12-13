import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws SQLException {
		
	// 스낵 테이블에 있는거 전체 출력
	
	//연결
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con = DriverManager.getConnection(url, "c##sr", "sr");
	System.out.println("연결 성공!");

	//실행도구
	Statement st = con.createStatement();
	
	//결과 얻기
	String sql = "select * from snack";
	ResultSet rs = st.executeQuery(sql);
	
	while (rs.next()) {
		System.out.println(rs.getString("s_name"));
		System.out.println(rs.getString("s_price"));
		System.out.println(rs.getString("s_maker"));
		System.out.println("-----------------------");
	}
	
	rs.close();
	st.close();
	con.close();
	
	
	}
}
