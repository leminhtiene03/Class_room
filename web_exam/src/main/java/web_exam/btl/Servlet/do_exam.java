package web_exam.btl.Servlet;

import java.io.IOException;import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_exam.btl.DAO.do_ExamDAO;
import web_exam.btl.model.BT_model;
import web_exam.btl.model.Question;

/**
 * Servlet implementation class do_exam
 */
@WebServlet("/do_exam")
public class do_exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public do_exam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  HttpSession session = request.getSession();
		  int exam_keep=(int)session.getAttribute("exam_keep");
		  int student_id=(int)session.getAttribute("student_id");
		  if ( !check_student_do(exam_keep,student_id,request,response))
		  {
			  show_i4_show_question(exam_keep,request,response);
		  }
		  else 
		  {
			  RequestDispatcher dispatcher = request.getRequestDispatcher("/display");
		        dispatcher.forward(request, response);
		  }
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private static void show_i4_show_question(int exam_id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BT_model a = do_ExamDAO.showI4_exam(exam_id);
		List <Question> b = do_ExamDAO.selectAllQuestion(exam_id);
		request.setAttribute("in4_exam", a);
		request.setAttribute("list_question", b);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("do_exam.jsp");
	        dispatcher.forward(request, response);
	}
	
	private static boolean check_student_do(int exam_id,int register_id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		
		return do_ExamDAO.check_do_exam(register_id, exam_id);
	}

}
