package web_exam.btl.model;

public class Detail_class {
	private int exam_ID;
	private int class_ID;
	private String exam_name;
	private String exam_date;
	private String description;
	private String exam_date_end;
	
	
	
	public Detail_class(int exam_ID, int class_ID, String exam_name, String exam_date, String description,
			String exam_date_end) {
		super();
		this.exam_ID = exam_ID;
		this.class_ID = class_ID;
		this.exam_name = exam_name;
		this.exam_date = exam_date;
		this.description = description;
		this.exam_date_end = exam_date_end;
	}
	public int getExam_ID() {
		return exam_ID;
	}
	public void setExam_ID(int exam_ID) {
		this.exam_ID = exam_ID;
	}
	public int getClass_ID() {
		return class_ID;
	}
	public void setClass_ID(int class_ID) {
		this.class_ID = class_ID;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public String getExam_date() {
		return exam_date;
	}
	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExam_date_end() {
		return exam_date_end;
	}
	public void setExam_date_end(String exam_date_end) {
		this.exam_date_end = exam_date_end;
	}
	
}
