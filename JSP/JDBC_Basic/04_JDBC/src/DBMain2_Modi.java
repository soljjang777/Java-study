import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBMain2_Modi {
	public static void main(String[] args) throws SQLException {

		//  ����� �̸�, ���� �Է��ؼ� db�� ����
		
		Scanner k = new Scanner(System.in);

		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "insert into db_test values (db_test_seq.nextval, ?, ?)";
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("���Ἲ��!");
		
		System.out.println("�̸� : ");
		String name = k.next();
		System.out.println("���� : ");
		int age = k.nextInt();
		
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
		
		System.out.println(sql);
		if(pstmt.executeUpdate() == 1) {
			System.out.println("��ϼ���");
		} else {
			System.out.println("��Ͻ���");
		}
		
		pstmt.close();
		con.close();
		
		
	}
}
