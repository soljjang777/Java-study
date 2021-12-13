import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain3 {
	public static void main(String[] args) throws SQLException {

		// 삭제할 사람 이름 입력하면 그 사람 삭제

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "select * from db_test";
		String sql2 = "delete db_test where d_no = ?";

		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("연결 성공");
		
//-----------조회
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("d_no") + "  |" + rs.getString("d_name") + " |" + rs.getInt("d_age"));
			System.out.println("-------------------------------------");
		}
		
//-----------삭제
		Scanner k = new Scanner(System.in);
		System.out.println("삭제할 사람의 번호를 입력해주세요");
		int no = k.nextInt();
		pstmt = con.prepareStatement(sql2);
		pstmt.setInt(1, no);

		int row = pstmt.executeUpdate();

		if (row == 1) {
			System.out.println(no + "(이)가 삭제 되었습니다!");
		} else {
			System.out.println("어떤 사람인지 정확히 입력해주세요");
		}

		pstmt.close();
		con.close();

	}
}
