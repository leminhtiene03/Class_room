package web_exam.btl.model;

import java.io.Serializable;

public class Question  implements Serializable {
	private int num;
	private String question;
	private String answer_a;
	private String answer_b;
	private String answer_c;
	private String answer_d;
	private String user_answer;
	private String right_answer;
	
	public Question(String question, String answer_a, String answer_b, String answer_c, String answer_d,
			String right_answer) {
		super();
		this.question = question;
		this.answer_a = answer_a;
		this.answer_b = answer_b;
		this.answer_c = answer_c;
		this.answer_d = answer_d;
		this.right_answer = right_answer;
	}
	
	public String getUser_answer() {
		return user_answer;
	}

	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}

	public Question(int num, String question, String answer_a, String answer_b, String answer_c, String answer_d, String right_answer) {
		super();
		this.num = num;
		this.question = question;
		this.answer_a = answer_a;
		this.answer_b = answer_b;
		this.answer_c = answer_c;
		this.answer_d = answer_d;
		this.right_answer = right_answer;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		question = question;
	}
	public String getAnswer_a() {
		return answer_a;
	}
	public void setAnswer_a(String answer_a) {
		this.answer_a = answer_a;
	}
	public String getAnswer_b() {
		return answer_b;
	}
	public void setAnswer_b(String answer_b) {
		this.answer_b = answer_b;
	}
	public String getAnswer_c() {
		return answer_c;
	}
	public void setAnswer_c(String answer_c) {
		this.answer_c = answer_c;
	}
	public String getAnswer_d() {
		return answer_d;
	}
	public void setAnswer_d(String answer_d) {
		this.answer_d = answer_d;
	}
	public String getRight_answer() {
		return right_answer;
	}
	public void setRight_answer(String right_answer) {
		this.right_answer = right_answer;
	}

	
	
}
