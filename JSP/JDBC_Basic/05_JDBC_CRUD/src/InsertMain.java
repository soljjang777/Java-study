import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		//연결
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("연결 성공");
		
		String sql = "insert into db_test values(db_test_seq.nextval, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		Scanner k = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = k.next();
		System.out.println("나이를 입력하세요");
		int age = k.nextInt();
		
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
		
		int row = pstmt.executeUpdate(); //하나의 행을 추가하는 것(int로 거시기하는데 1이 1열)
										 // CUD     R(select) executeQuery()											
		if(row == 1) {
			System.out.println("등록 성공");
		}
		
		
		
		
		
		pstmt.close();
		con.close();
		
		
	}
}
