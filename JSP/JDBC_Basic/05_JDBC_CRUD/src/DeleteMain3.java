import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain3 {
	public static void main(String[] args) throws SQLException {

		// ������ ��� �̸� �Է��ϸ� �� ��� ����

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "select * from db_test";
		String sql2 = "delete db_test where d_no = ?";

		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("���� ����");
		
//-----------��ȸ
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("d_no") + "  |" + rs.getString("d_name") + " |" + rs.getInt("d_age"));
			System.out.println("-------------------------------------");
		}
		
//-----------����
		Scanner k = new Scanner(System.in);
		System.out.println("������ ����� ��ȣ�� �Է����ּ���");
		int no = k.nextInt();
		pstmt = con.prepareStatement(sql2);
		pstmt.setInt(1, no);

		int row = pstmt.executeUpdate();

		if (row == 1) {
			System.out.println(no + "(��)�� ���� �Ǿ����ϴ�!");
		} else {
			System.out.println("� ������� ��Ȯ�� �Է����ּ���");
		}

		pstmt.close();
		con.close();

	}
}
