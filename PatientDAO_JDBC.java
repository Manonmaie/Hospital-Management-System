import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Date;

public class PatientDAO_JDBC implements PatientDAO {

	Connection dbConnection;
	public PatientDAO_JDBC(Connection dbconn){
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
			sql = "select record_date,name,disease,treatment from Doctor LEFT JOIN  MedicalRecords on Doctor.doctor_id = MedicalRecords.doctor_id where patient_id = (select Patient.patient_id from Patient where Patient.user_id = \""+user_id+"\");";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Date date = rs.getDate("record_date");
				String doc_name = rs.getString("name");
				String disease  = rs.getString("disease");
				String treatment = rs.getString("treatment");
				MedicalRecords med = new MedicalRecords();
				med.setDate(date);
				med.setDoctorName(doc_name);
				med.setDisease(disease);
				med.setTreatmment(treatment);
				records.add(med);
			}
		} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("You haven't registed yet please signup");
		}
		return records;
	}

	@Override
	public void BookAppointment(String user_id, String date,String doc_name,String doc_spl,String reason) {
		ArrayList<MedicalRecords> records = new ArrayList<MedicalRecords>();
		String sql1,sql2,sql3,sql4;
		Statement stmt = null;
		try{
			stmt = dbConnection.createStatement();
			//inserting into visit
			sql1 = "Insert into Visit values(0,NULL,(select patient_id from Patient where user_id = \""+user_id+"\"),NULL,\""+date+"\",0);";
			//inserting into doctor visit
			sql2 = "Insert into DoctorVisit values(0,NULL,(select doctor_id from Doctor where name = \""+doc_name+"\" and specialization = \""+doc_spl+"\" ),(select visit_id from Visit  where visit_id in (select max(visit_id) from Visit)),\""+reason+"\" );";
			//giving value of doctorvisit id to visit
			sql3 = "update Visit set docvisit_id = ( select docvisit_id from DoctorVisit where visit_id in (select * from (select max(visit_id) from Visit) as c)) where visit_id in (select * from (select max(visit_id) from Visit) as c);";
			//updating cost in visit as consultation cost
			sql4 = "update Visit set cost = (select consultation_fee from Doctor where Doctor.doctor_id = (select DoctorVisit.doctor_id from 	DoctorVisit where DoctorVisit.docvisit_id = 	Visit.docvisit_id)) where visit_id in (select * from (select 	max(visit_id) from Visit) as c);";
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			System.out.println("Application saved successfully!!");
		}
		catch (SQLException ex) {
				System.out.println("Please add valid details!!");
		}
	}

	@Override
	public void AddPatient(String name,char sex,int age,String password){
		String sql1,sql2,sql_getid;
		Statement stmt = null;
		try{
			stmt = dbConnection.createStatement();
			sql_getid = "select max(patient_id) as patient_id from Patient;";
			ResultSet rs = stmt.executeQuery(sql_getid);
			int max_id = 0;
			while(rs.next()){
				max_id = rs.getInt("patient_id");
				max_id = max_id+1;
				System.out.println(max_id);
			}
			String user_id = "P00000"+(max_id-100000);
			System.out.println(user_id);
			sql1 = "Insert into Patient values(0,\""+user_id+"\",\""+name+"\",\""+age+"\",\""+sex+"\");";
			sql2 = "Insert into User values(\""+user_id+"\",\""+password+"\");";
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql1);
			System.out.println("You have successfully created an account :)");
			System.out.println("Your user_id is "+user_id);
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
				System.out.println("Please enter valid details!");
		}
	}
}
