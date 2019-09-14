import java.lang.*;
import java.util.List;
import java.util.ArrayList;

public interface DoctorDAO {
	public ArrayList<MedicalRecords> ViewPastRecords(String user_id);

}
