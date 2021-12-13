import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBMain3_Modi {
	public static void main(String[] args) throws SQLException {

		//  ���� ���̺� ���� �ϳ� �ֱ�
		
		Scanner k = new Scanner(System.in);

		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("���Ἲ��!");
		
		System.out.println("�̸� : ");
		String name = k.next();
		System.out.println("�귣�� : "); 
		String maker = k.next();
		System.out.println("�߷� : ");
		int weight = k.nextInt();
		System.out.println("���� : ");
		int price = k.nextInt();
		
		String sql = "insert into snack values (snack_seq.nextval, ?, ?, ?, ?, sysdate)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setNString(1, name);
		pstmt.setNString(2, maker);
		pstmt.setDouble(3, weight);
		pstmt.setInt(4, price);

		if(pstmt.executeUpdate() == 1) {
			System.out.println("��ϼ���");
		} else {
			System.out.println("��Ͻ���");
		}
		
		pstmt.close();
		
		con.close();
		
		
	}
}
