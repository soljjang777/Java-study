import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectMain {
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		//연결
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("연결 성공");
		
		String sql = "select * from db_test";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		//select때 필요
		ResultSet rs = pstmt.executeQuery();
		
		
		//rs.next() : 다음 레코드로 가는 기능(화살표 아래로 내려감)
		//				다음 데이터가 있으면 true, 없으면 false
		while (rs.next()) {
			//rs.getXX("컬럼") : 현재 화살표  위치의 컬럼 값 가져오기
			System.out.println(rs.getString("d_name"));
			System.out.println(rs.getInt("d_age"));
			System.out.println("------------------");
		}
		
		
		
		
		rs.close();
		pstmt.close();
		con.close();
	}
}
