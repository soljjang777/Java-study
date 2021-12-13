import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {
	public static void main(String[] args) throws SQLException {
		
		
		// 연결할 db서버 주소 (DB메이커마다 다른거)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// 연결시도 -> 주소 -> 연결할 db메이커 판단
		// 자동으로 메이커 맞는  driver 찾아줌
		
		//연결
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("연결 성공");
		
		con.close();
	}
}
