import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain2 {
	public static void main(String[] args) throws SQLException {
		
		// ������ ��� �̸� �Է��ϸ� �� ��� ����
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "delete db_test where d_no = ?";
		
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("���� ����");
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		Scanner k = new Scanner(System.in);
		System.out.println("������ ����� ��ȣ�� �Է����ּ���");
		int no = k.nextInt();
		pstmt.setString(1, no);
		
		int row = pstmt.executeUpdate();
		
		if(row == 1) {
			System.out.println(no + "(��)�� ���� �Ǿ����ϴ�!");
		}else {
			System.out.println("� ������� ��Ȯ�� �Է����ּ���");
		}
		
		
		pstmt.close();
		con.close();
		
	}
}
