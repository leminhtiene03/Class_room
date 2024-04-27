package web_exam.btl.model;


import java.io.Serializable;


public class EXAM_list implements Serializable {
	private int id;
	private String name;
	private int minute_exam;
	private String Description;
	private String date_creat;
	private String date_end;
	
	
	public EXAM_list(int id, String name, String description, String date_creat) {
		super();
		this.id = id;
		this.name = name;
		this.Description = description;
		this.date_creat = date_creat;
		this.date_end = date_end;
	}
	
	public EXAM_list(int id, String name, int minute_exam, String description, String date_creat, String date_end) {
		super();
		this.id = id;
		this.name = name;
		this.minute_exam = minute_exam;
		Description = description;
		this.date_creat = date_creat;
		this.date_end = date_end;
	}

	public int getMinute_exam() {
		return minute_exam;
	}

	public void setMinute_exam(int minute_exam) {
		this.minute_exam = minute_exam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDate_creat() {
		return date_creat;
	}
	public void setDate_creat(String date_creat) {
		this.date_creat = date_creat;
	}
	public String getDate_end() {
		return date_end;
	}
	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
	
	
}
