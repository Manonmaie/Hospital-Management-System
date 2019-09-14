import java.lang.*;

public class User{
  String user_id;
  String password;
  public User(){}
  public User(String s,String p){user_id = s;password = p;}
  public String getUserId(){return user_id;}
  public String getPassword(){return password;}
  public void setUserId(String s){user_id = s;}
  public void setPassword(String s){password = s;}
  public void print(){
    System.out.println("User ID-"+user_id);
    System.out.println("Password-"+password);
  }
};
