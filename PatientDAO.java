import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public interface PatientDAO {
	public ArrayList<MedicalRecords> ViewPastRecords(String user_id);
	public void BookAppointment(String user_id,String date,String doc_name,String doc_spl,String reason);
	public void AddPatient(String name,char sex,int age,String password);
}
