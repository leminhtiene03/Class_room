package web_exam.btl.model;

import java.io.Serializable;

public class BT_model implements Serializable {
	private String name;
	private String des;
	private String type;
	private String date_start;
	private String date_end;
	
	private int minute_exam;
	
	
	public BT_model() {
		super();
	}
	public BT_model(String name, String des, String type, String date_start, String date_end) {
		super();
		this.name = name;
		this.des = des;
		this.type = type;
		this.date_start = date_start;
		this.date_end = date_end;
	}
	
	public BT_model(String name, String des, String type, String date_start, String date_end, int minute_exam) {
		super();
		this.name = name;
		this.des = des;
		this.type = type;
		this.date_start = date_start;
		this.date_end = date_end;
		this.minute_exam = minute_exam;
	}
	
	public int getMinute_exam() {
		return minute_exam;
	}
	public void setMinute_exam(int minute_exam) {
		this.minute_exam = minute_exam;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate_start() {
		return date_start;
	}
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}
	public String getDate_end() {
		return date_end;
	}
	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
	
	
}
