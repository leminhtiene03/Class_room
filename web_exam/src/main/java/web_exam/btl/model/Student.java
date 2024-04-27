package web_exam.btl.model;

import java.io.Serializable;

public class Student implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String fullname;
    private int ID;
	private String email;
    private String password;
    private int class_ID;
    
    
    public Student() {
		super();
	}
    
	public Student(String fullname, int iD, String email) {
		super();
		this.fullname = fullname;
		ID = iD;
		this.email = email;
		
	}
	public Student(String fullname, String email) {
		super();
		this.fullname = fullname;
		
		this.email = email;
		
	}
	public Student(String fullname, int iD, String email, int class_ID) {
		super();
		this.fullname = fullname;
		ID = iD;
		this.email = email;
		this.class_ID = class_ID;
	}
	public int getID() {
 		return ID;
 	}
 	public void setID(int iD) {
 		ID = iD;
 	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getClass_ID() {
		return class_ID;
	}
	public void setClass_ID(int class_ID) {
		this.class_ID = class_ID;
	}
    
    
	
}
