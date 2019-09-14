import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class DoctorDAO_JDBC implements DoctorDAO {

	Connection dbConnection;
	public DoctorDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public ArrayList<MedicalRecords> ViewPastRecords(String user_id) {
		ArrayList<MedicalRecords> records = new ArrayList<MedicalRecords>();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select record_date,name,disease,treatment from Patient LEFT JOIN  MedicalRecords on Patient.patient_id = MedicalRecords.patient_id where doctor_id = (select doctor_id from Doctor where user_id = \""+user_id+"\");";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				Date date = rs.getDate("record_date");
				String pat_name = rs.getString("name");
				String disease  = rs.getString("disease");
				String treatment = rs.getString("treatment");
				MedicalRecords med = new MedicalRecords();
				med.setDate(date);
				med.setPatientName(pat_name);
				med.setDisease(disease);
				med.setTreatmment(treatment);
				records.add(med);
			}
		} catch (SQLException ex) {
		    System.out.println("You haven't registed yet please signup");
		}
		return records;
	}
}
