import java.lang.*;
import java.util.Date;

public class MedicalRecords{
	Date date;
	String patient_name;
	String doctor_name;
	String disease;
	String treatment;
	public MedicalRecords() { }
	public MedicalRecords (Date d,String pn,String dn,String di,String t){date = d; patient_name = pn;doctor_name = dn;disease=di;treatment = t; }
	public Date getDate(){return date;}
	public void setDate(Date d){date = d;}
	public String getPatientName() { return patient_name; }
	public void setPatientName(String s){ patient_name = s; }
	public String getDoctorName() { return doctor_name; }
	public void setDoctorName(String s){ doctor_name = s; }
	public String getDisease() { return disease; }
	public void setDisease(String s){ disease = s; }
	public String getTreatment() { return treatment; }
	public void setTreatmment(String s){ treatment = s; }
	public void print(){
		System.out.println("Date :" + date);
		System.out.println("Patient Name :" + patient_name);
		System.out.println("Doctor Name :" + doctor_name);
		System.out.println("Disease:" + disease);
		System.out.println("Treatment:" + treatment);
	}
	public void printforpatient(){
		System.out.println("Date :" + date +",Doctor Name :" + doctor_name
		+",Disease:" + disease+",Treatment:" + treatment);
	}
	public void printfordoctor(){
		System.out.println("Date :" + date +",Patient Name :" + patient_name
		+",Disease:" + disease+",Treatment:" + treatment);
	}
};
