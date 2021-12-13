import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
	public static void main(String[] args) throws SQLException {
		
		// 삭제할 사람 이름 입력하면 그 사람 삭제
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "delete db_test where d_name = ?";
		
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("연결 성공");
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		Scanner k = new Scanner(System.in);
		System.out.println("이름을 입력해주세요");
		String name = k.next();
		pstmt.setString(1, name);
		
		int row = pstmt.executeUpdate();
		
		if(row == 1) {
			System.out.println(name + "(이)가 삭제 되었습니다!");
		}else {
			System.out.println("어떤 사람인지 정확히 입력해주세요");
		}
		
		
		
		
		
		
		
		pstmt.close();
		con.close();
		
	}
}
