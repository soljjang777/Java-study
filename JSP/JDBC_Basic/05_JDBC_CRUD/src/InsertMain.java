import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		//����
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("���� ����");
		
		String sql = "insert into db_test values(db_test_seq.nextval, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		Scanner k = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���");
		String name = k.next();
		System.out.println("���̸� �Է��ϼ���");
		int age = k.nextInt();
		
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
		
		int row = pstmt.executeUpdate(); //�ϳ��� ���� �߰��ϴ� ��(int�� �Žñ��ϴµ� 1�� 1��)
										 // CUD     R(select) executeQuery()											
		if(row == 1) {
			System.out.println("��� ����");
		}
		
		
		
		
		
		pstmt.close();
		con.close();
		
		
	}
}
