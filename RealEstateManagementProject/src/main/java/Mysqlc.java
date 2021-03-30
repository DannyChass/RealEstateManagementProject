package mysqlc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author mysqltest
 */
public class Mysqlc {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  Connection conn = null;
try {
    // db parameters - ptest is the name of the database
    String url       = "jdbc:mysql://localhost:3306/ptest";
    String user      = "root";
    String password  = "mysql";
   
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password);
    // more processing here
    // ...   
    Statement stmt=conn.createStatement(); 
ResultSet rs=stmt.executeQuery("select * from cust"); 
while(rs.next()) 
System.out.println(rs.getInt(1)+"  "+rs.getString(2)); 
conn.close(); 
} catch(SQLException e) {
   System.out.println(e.getMessage());
} finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }
}
}  