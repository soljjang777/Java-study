import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {
	public static void main(String[] args) throws SQLException {
		
		
		// ������ db���� �ּ� (DB����Ŀ���� �ٸ���)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// ����õ� -> �ּ� -> ������ db����Ŀ �Ǵ�
		// �ڵ����� ����Ŀ �´�  driver ã����
		
		//����
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("���� ����");
		
		con.close();
	}
}
