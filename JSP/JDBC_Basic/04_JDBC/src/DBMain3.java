import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBMain3 {
	public static void main(String[] args) throws SQLException {

		//  과자 테이블 과자 하나 넣기
		
		Scanner k = new Scanner(System.in);

		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = DriverManager.getConnection(url, "c##sr", "sr");
		System.out.println("연결성공!");
		
		System.out.println("이름 : ");
		String name = k.next();
		System.out.println("브랜드 : ");
		String maker = k.next();
		System.out.println("중량 : ");
		int weight = k.nextInt();
		System.out.println("가격 : ");
		int price = k.nextInt();
		
		Statement st = con.createStatement();
		String sql = "insert into snack values (snack_seq.nextval, '" + name + "', '" + maker + "', " + weight + " , " + price + ", sysdate)";
		System.out.println(sql);
		if(st.executeUpdate(sql) == 1) {
			System.out.println("등록성공");
		} else {
			System.out.println("등록실패");
		}
		
		st.close();
		con.close();
		
		
	}
}
