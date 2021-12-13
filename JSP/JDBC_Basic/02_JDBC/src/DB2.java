import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB2 {
   public static void main(String[] args) throws SQLException {
      // ������ con, st, rs
      
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String id = "c##sr";
      String pw = "sr";
      
      Connection con = DriverManager.getConnection(url, id, pw);
      
      Statement st = con.createStatement();
      
      String sql = "select * from db_test";
      
      ResultSet rs = st.executeQuery(sql);
      
      rs.next();
      String name = rs.getString("d_name");
      System.out.print(name + " ");
      
      rs.next();
      String name2 = rs.getString("d_name");
      System.out.print(name2);
      
      rs.close();
      st.close();
      con.close();
   }
}