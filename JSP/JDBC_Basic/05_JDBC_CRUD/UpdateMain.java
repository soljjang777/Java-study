import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("연결 성공");
		
		String sql = "select * from db_test";
		String sql2 = "update db_test set d_age = ? where d_name = ? ";
		
		// 나이를 수정 하고싶은 사람 이름
//----------조회
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt("d_no") + "  |" + rs.getString("d_name") + " |" + rs.getInt("d_age"));
			System.out.println("-------------------------------------");
		}
//----------이름 선택
		Scanner k = new Scanner(System.in);
		System.out.println("바꾸고 싶은 사람의 이름을 입력해주세요");
		String name = k.next();
		System.out.println("수정하고싶은 나이를 입력해주세요");
		int age = k.nextInt();
		
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(2, name);
		pstmt.setInt(1, age);
		
		int row = pstmt.executeUpdate();

		if (row == 1) {
			System.out.println(name + "(님)의 나이가 수정 되었습니다!");
		} else {
			System.out.println("어떤 사람인지 정확히 입력해주세요");
		}

		//몇살로 수정할까요?
				
		pstmt.close();
		con.close();
	}
}
