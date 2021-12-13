import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectMain {
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		//����
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("���� ����");
		
		String sql = "select * from db_test";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		//select�� �ʿ�
		ResultSet rs = pstmt.executeQuery();
		
		
		//rs.next() : ���� ���ڵ�� ���� ���(ȭ��ǥ �Ʒ��� ������)
		//				���� �����Ͱ� ������ true, ������ false
		while (rs.next()) {
			//rs.getXX("�÷�") : ���� ȭ��ǥ  ��ġ�� �÷� �� ��������
			System.out.println(rs.getString("d_name"));
			System.out.println(rs.getInt("d_age"));
			System.out.println("------------------");
		}
		
		
		
		
		rs.close();
		pstmt.close();
		con.close();
	}
}
