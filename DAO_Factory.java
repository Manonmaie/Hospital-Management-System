import java.lang.*;
import java.sql.*;
/*
	Methods to be called in the following order:

	1. activateConnection
	2. 	Any number getDAO calls with any number of database transactions
	3. deactivateConnection
*/
public class DAO_Factory{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	// Modify the DB_URL string, userid and password depending upon the database you want to connect to
	// In the following string, you are connecting a adatabase named "daoproject"
//	static final String DB_URL = "jdbc:mysql://localhost/hospitaldb";
		static final String DB_URL = "jdbc:mysql://localhost:3306/hospitaldb?verifyServerCertificate=false&useSSL=true";

	static final String USER = "manonmaie";
	static final String PASS = "Mano1Than2*";

	Connection dbconnection = null;

	// You can add additional DAOs here as needed. Generally one DAO per class
	PatientDAO patientDAO = null;
	DoctorDAO doctorDAO = null;
	UserDAO userDAO = null;

	boolean activeConnection = false;

	public DAO_Factory()
	{
		dbconnection = null;
		activeConnection = false;
	}

	public void activateConnection() throws Exception
	{
		if( activeConnection == true )
			throw new Exception("Connection already active");

		System.out.println("Connecting to database...");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			dbconnection = DriverManager.getConnection(DB_URL,USER,PASS);
			activeConnection = true;
		} catch(ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	public PatientDAO getPatientDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( patientDAO == null )
			patientDAO = new PatientDAO_JDBC( dbconnection );

		return patientDAO;
	}
	public DoctorDAO getDoctorDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( doctorDAO == null )
			doctorDAO = new DoctorDAO_JDBC( dbconnection );

		return doctorDAO;
	}
	public UserDAO getUserDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( userDAO == null )
			userDAO = new UserDAO_JDBC( dbconnection );

		return userDAO;
	}
	public void deactivateConnection()
	{
		// Okay to keep deactivating an already deactivated connection
		activeConnection = false;
		if( dbconnection != null ){
			try{
				dbconnection.close();
				dbconnection = null;
				patientDAO = null;
				doctorDAO = null;
				userDAO = null;
			}
			catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
	}
};
