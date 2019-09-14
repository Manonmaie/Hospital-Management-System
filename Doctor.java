import java.lang.*;

public class Doctor{
	String name;
	String user_id;
	int consult_fee;
	int experiance;
	String specialisation;
	public Doctor() { }
	public Doctor (String n,String u, int cf,int e,String s){
		name = n;
		user_id = u;
		consult_fee = cf;
		experiance = e;
		specialisation = s;
	}
	public String getName() { return name; }
	public void setName(String s){ name = s; }
	public String getUserId() { return user_id; }
	public void setUserId(String s){ user_id = s; }
	public int getExperiance() { return experiance; }
	public void setExperiance(int s){ experiance = s; }
	public int getConsultFee() { return consult_fee; }
	public void setConsultFee(int s){ consult_fee = s; }
	public String getSpecialisation(){return specialisation;}
	public void setSpecialisation(String s){specialisation = s;}
	public void print(){
		System.out.println("Doctor Name :" + name);
		System.out.println("Specialisation:" + specialisation);
		System.out.println("Experiance:" + experiance);
		System.out.println("Consultation Fee:" + consult_fee);
	}
};
