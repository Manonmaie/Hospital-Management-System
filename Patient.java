import java.lang.*;

public class Patient{
	String name;
	String user_id;
	int age;
	char sex;
	// int id;
	public Patient() { }
	public Patient (String s,String u, int r,char c){ age = r; name = s;sex = c;user_id = u; }
	public String getName() { return name; }
	public void setName(String s){ name = s; }
	public String getUserId() { return user_id; }
	public void setUserId(String s){ user_id = s; }
	public int getAge() { return age; }
	public void setAge(int s){ age = s; }
	public int getSex() { return sex; }
	public void setAge(char s){ sex = s; }
	// public void setUserId_id(int i){user_id = "P00000"+i;}
	public void print(){ System.out.println("Patient Name :" + name); System.out.println("Age:" + age);System.out.println("Sex:" + sex);}
};
