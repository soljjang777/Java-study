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
		System.out.println("���� ����");
		
		String sql = "select * from db_test";
		String sql2 = "update db_test set d_age = ? where d_name = ? ";
		
		// ���̸� ���� �ϰ���� ��� �̸�
//----------��ȸ
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt("d_no") + "  |" + rs.getString("d_name") + " |" + rs.getInt("d_age"));
			System.out.println("-------------------------------------");
		}
//----------�̸� ����
		Scanner k = new Scanner(System.in);
		System.out.println("�ٲٰ� ���� ����� �̸��� �Է����ּ���");
		String name = k.next();
		System.out.println("�����ϰ���� ���̸� �Է����ּ���");
		int age = k.nextInt();
		
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(2, name);
		pstmt.setInt(1, age);
		
		int row = pstmt.executeUpdate();

		if (row == 1) {
			System.out.println(name + "(��)�� ���̰� ���� �Ǿ����ϴ�!");
		} else {
			System.out.println("� ������� ��Ȯ�� �Է����ּ���");
		}

		//���� �����ұ��?
				
		pstmt.close();
		con.close();
	}
}
