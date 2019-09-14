import java.lang.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class UserDAO_JDBC implements UserDAO {
  Connection dbConnection;
	public UserDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
  public boolean is_correct(String user_id,String password){
    Statement stmt = null;
    String sql;
    try{
      stmt = dbConnection.createStatement();
      sql = "select * from User where user_id = \""+user_id+"\" and password = \""+password+"\";";
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next()){
        return true;
      }
      return false;
    }
    catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      System.out.println("Please enter valid details!");
    }
    return false;
  }
}
