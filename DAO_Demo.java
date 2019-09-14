//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO_Demo{
	public static void main(String[] args) {
		try{
			DAO_Factory daoFactory = new DAO_Factory();
			daoFactory.activateConnection();
			Scanner sc = new Scanner(System.in);
			while(true){
				System.out.println("Press 1 for login, 2 for signup and 3 for exit");
				int loginORsignup = sc.nextInt();
				sc.nextLine();
				if(loginORsignup == 1){
					System.out.println("Please enter your user_id:");
					String user_id = sc.nextLine();
					System.out.println("Please enter your password:");
					String password = sc.nextLine();
					UserDAO udao = daoFactory.getUserDAO();
					if(udao.is_correct(user_id,password)){
						if(user_id.charAt(0) == 'P'){
							while(true){
								System.out.println("Press 1 to view your past medical record, 2 to book appointment and 3 to exit");
								int option = sc.nextInt();
								sc.nextLine();
								if(option == 1){
									PatientDAO pdao = daoFactory.getPatientDAO();
									ArrayList<MedicalRecords> med_list;
									med_list = pdao.ViewPastRecords(user_id);
									for (MedicalRecords m:med_list){m.printforpatient();}
								}
								else if(option == 2){
									System.out.println("Please enter the doctor you want to consult:");
									String doc_name = sc.nextLine();
									System.out.println("Please enter the specialisation of doctor you want to consult:");
									String doc_spl = sc.nextLine();
									System.out.println("Please enter reason for your consultation:");
									String reason = sc.nextLine();
									PatientDAO pdaobook = daoFactory.getPatientDAO();
									java.util.Date date = new java.util.Date();
									java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String dt = sdf.format(date);
									pdaobook.BookAppointment(user_id,dt,doc_name,doc_spl,reason);
								}
								else if(option == 3){
									break;
								}
								else{
									System.out.println("Please enter a valid option");
								}
							}
						}
						else if(user_id.charAt(0) == 'D'){
							while(true){
								System.out.println("Press 1 to view your patient's medical record and 2 to exit");
								int option = sc.nextInt();
								sc.nextLine();
								if(option == 1){
									DoctorDAO ddao = daoFactory.getDoctorDAO();
									ArrayList<MedicalRecords> med_list_doc;
									med_list_doc = ddao.ViewPastRecords(user_id);
									for (MedicalRecords m:med_list_doc){m.printfordoctor();}
								}
								else if(option == 2){
									break;
								}
								else{
								System.out.println("Please enter a valid option");
								}
							}
						}
					}
					else{
						System.out.println("Please enter valid credentials");
					}
				}
				else if(loginORsignup == 2){
					PatientDAO pdao = daoFactory.getPatientDAO();
					System.out.println("Enter your name:");
					String name = sc.nextLine();
					System.out.println("Enter your sex:");
					char sex = sc.next().charAt(0);
					System.out.println("Enter your age:");
					int age = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter your password:");
					String password = sc.nextLine();
					pdao.AddPatient(name,sex,age,password);
					System.out.println("Please login before proceed!!");
				}
				else if(loginORsignup == 3){
					break;
				}
				else{
					System.out.println("Enter a valid input :( ");
				}
			}
			daoFactory.deactivateConnection();
		}
		catch(Exception e){
				e.printStackTrace();
		}
	}
}
