import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
      
   // 1. Driver load (DB ����̹� �ҷ���)
//      Class.forName("oracle.jdbc.driver.OracleDriver");
      
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String id = "c##sr";
      String pw = "sr";
      
   // 2. Connect (DB�� ����)
      Connection con = DriverManager.getConnection(url, id, pw);
      System.out.println("���� ����");
      
   // 3. Statement (���൵�� ����)
      Statement st = con.createStatement();
      
   // 4. ResultSet (��� ���)
      String sql = "select * from db_test";
      ResultSet rs = st.executeQuery(sql); // select �� DB ���̺��� ��°�� rs�� �� �ִ�.
      
      if (rs.next()) { // 1���� ����Ű�� �ȴ�.
      String name = rs.getString("d_name");
      System.out.print(name + " ");
      
      int age = rs.getInt("d_age");
      System.out.println(age);
      }
      
      // ���� ���� �ݴ������ �ݾ��ش�.
      
      rs.close(); // DB�� ����Ǿ� �ִ� �󲮵��� �ø������ �ݾ��ش�.
      st.close(); // �ݾ��ִ� ������ DB�� ����Ǵ� ���� ������ �ֳ� ������
      con.close(); // �ݾ����� ������ ������ ������� ���Ѵ�.
      
      
   }
}