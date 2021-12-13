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
		System.out.println("���� ����!");
		
		PreparedStatement pstmt = con.prepareStatement(sql1);
		
		Scanner k = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���");
		String name = k.next();
		System.out.println("ü�߸� �Է��ϼ���");
		double weight = k.nextDouble();
		System.out.println("Ű�� �Է��ϼ���");
		double height = k.nextDouble();

		pstmt.setString(1, name);
		pstmt.setDouble(2, weight);	
		pstmt.setDouble(3, height);					
		
	      // BMI ����
	      if(height > 3) {
	         height /= 100;
	      }
	      
	      String result = "��";
	      double bmi = weight / (height * height);
	      
	      if(bmi < 20) {
	         result = "��ü��";
	      }else if(bmi < 25)   {
	         result = "����";
	      }else if(bmi < 30)  {
	         result = "��ü��";
	      }

	      bmi = Double.parseDouble(String.format("%.2f",bmi));
		
		pstmt.setDouble(4, bmi);
		pstmt.setString(5, result);
	
		int row = pstmt.executeUpdate();						
		if(row == 1) {
		System.out.println("���� ���� ����!");
		}else {
			System.out.println("���� ���� ����!");
		}
		
		System.out.printf("����� BMI�� %2f �Դϴ�",bmi);
		String bmi2 = String.format("%.2f", bmi) 
		System.out.printf("%s��, ����� %s�Դϴ�\n", name, result);
	
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
// �̷��� �ҷ��� Ʈ���� ���� �ۿ��� connection con = null; , preparedstatement pstmt - null; �������ְ� �ؾߵ�