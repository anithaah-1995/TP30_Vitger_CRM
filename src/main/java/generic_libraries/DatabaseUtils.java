package generic_libraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {
	
	Connection conn = null;
	ResultSet result = null;
	/**
	 * This method is used to connect to database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		
	
		// TODO Auto-generated method stub
Driver driver = new Driver();
 DriverManager.registerDriver(driver);
 
 //getconnection foe database
  conn = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername, IPathConstants.dbpassword);

}
	/**
	 * This method is used to exceut the query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	
  public ResultSet exceuteQuery(String query) throws SQLException
 {
	//create statement
	  Statement state = conn.createStatement();
	  
	  //exceute query
	  ResultSet result = state.executeQuery("query");
	  
                                                               //	  //close database conncetion
                                                                   //	  conn.close();
	  return result;
 }
 /**
  * This method is ued to select queries and return data
  * @param query
  * @return
  * @throws SQLException
  */
  public int updateQuery(String query) throws SQLException
  {
	  //create the statement
	  Statement state = conn.createStatement();
	  int res = state.executeUpdate(query);
			  return res;
  }
  
  
  /**
   * This method is used to close the database connection
   * @throws SQLException
   */
 public void disconnectDB() throws SQLException
 {
	 //close the connection
	 conn.close();
 }
 
	}


