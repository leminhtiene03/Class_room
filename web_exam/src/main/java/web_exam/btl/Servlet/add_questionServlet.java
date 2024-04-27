package web_exam.btl.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_exam.btl.DAO.ADD_QuestionDao;
import web_exam.btl.DAO.EXAM_DAO;
import web_exam.btl.model.BT_model;
import web_exam.btl.model.Question;



/**
 * Servlet implementation class add_questionServlet
 */
@WebServlet("/add_bt")
public class add_questionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_questionServlet() {
        super();
        ADD_QuestionDao add_que = new ADD_QuestionDao();
        EXAM_DAO exam_dao = new EXAM_DAO();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		get_question(request,response);
		
		
		 response.sendRedirect("list_exam.jsp");
    //	 response.sendRedirect("exam_go");
     
	}
	public static void get_question(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		 PrintWriter pw=response.getWriter();
		 response.setContentType("text/html");
		
		 List < Question > question_list = new ArrayList < > ();
		 
		 
		 HttpSession session = request.getSession();
		
		 int class_keep=(int)session.getAttribute("class_keep");
		 
		 String name_bt = request.getParameter("quiz-name");
		 String des_bt = request.getParameter("quiz-description");
		 String quiz_type = request.getParameter("quiz-type");
		 int quiz_time = Integer.parseInt(request.getParameter("quiz-time"));
		 String start_date = request.getParameter("specific-date");
		 String end_date = request.getParameter("end-date");
		 BT_model new_bt = new BT_model(name_bt,des_bt,quiz_type,start_date,end_date,quiz_time);
		 int keep = ADD_QuestionDao.INSERT_EXAM(new_bt,class_keep);
		 System.out.print("insert vao lop " +class_keep);
		 
		 
		 
		 String[] question=request.getParameterValues("question");
		 String[] answer1=request.getParameterValues("answer-a");
		 String[] answer2=request.getParameterValues("answer-b");
		 String[] answer3=request.getParameterValues("answer-c");
		 String[] answer4=request.getParameterValues("answer-d");
		 String[] right_answer = request.getParameterValues("correct-answer");
		 
		 for (int i=0;i<question.length;i++)
		 {
			 Question new_question = new Question(question[i],answer1[i],answer2[i],answer3[i],answer4[i],right_answer[i]);
			 question_list.add(new_question);
		 }
		 ADD_QuestionDao.INSERT_QUESTION(question_list,keep);
		
		
		
		
	}
}
