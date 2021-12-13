import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class BMIMain {
	public static void main(String[] args) throws SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql1 = "insert into bmi values(bmi_seq.nextval, ?, ?, ?, ?, ?)";
		
		Connection con = DriverManager.getConnection(url,"c##sr","sr");
		System.out.println("연결 성공!");
		
		PreparedStatement pstmt = con.prepareStatement(sql1);
		
		Scanner k = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = k.next();
		System.out.println("체중를 입력하세요");
		double weight = k.nextDouble();
		System.out.println("키를 입력하세요");
		double height = k.nextDouble();

		pstmt.setString(1, name);
		pstmt.setDouble(2, weight);	
		pstmt.setDouble(3, height);					
		
	      // BMI 계산식
	      if(height > 3) {
	         height /= 100;
	      }
	      
	      String result = "비만";
	      double bmi = weight / (height * height);
	      
	      if(bmi < 20) {
	         result = "저체중";
	      }else if(bmi < 25)   {
	         result = "정상";
	      }else if(bmi < 30)  {
	         result = "과체중";
	      }

	      bmi = Double.parseDouble(String.format("%.2f",bmi));
		
		pstmt.setDouble(4, bmi);
		pstmt.setString(5, result);
	
		int row = pstmt.executeUpdate();						
		if(row == 1) {
		System.out.println("정보 저장 성공!");
		}else {
			System.out.println("정보 저장 실패!");
		}
		
		System.out.printf("당신의 BMI는 %2f 입니다",bmi);
		String bmi2 = String.format("%.2f", bmi) 
		System.out.printf("%s님, 당신은 %s입니다\n", name, result);
	
		pstmt.close();
		con.close();
	}
}

//				catch (Exception e) {
// e.printStackTrace();
// } finally {
//			pstmt.close();
//			com.close();
//}
// 이렇게 할려면 트라이 구분 밖에서 connection con = null; , preparedstatement pstmt - null; 선언해주고 해야됨