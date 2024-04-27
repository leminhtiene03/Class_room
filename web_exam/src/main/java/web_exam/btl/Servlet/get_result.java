package web_exam.btl.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_exam.btl.DAO.Save_ResultDAO;
import web_exam.btl.DAO.do_ExamDAO;
import web_exam.btl.model.BT_model;
import web_exam.btl.model.Question;

/**
 * Servlet implementation class get_result
 */
@WebServlet("/get_result")
public class get_result extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final DecimalFormat df = new DecimalFormat("0.00");
	 private static final DecimalFormat dc = new DecimalFormat("0");
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  HttpSession session = request.getSession();
		  int exam_keep=(int)session.getAttribute("exam_keep");
		  int student_id=(int)session.getAttribute("student_id");
		
		
		double point = show_result(exam_keep,request,response);
		if (student_id >0)
		{
			try {
				Save_ResultDAO.insert_Result( student_id, exam_keep, point);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static List <String> get_Result(int exam_id) 
	{
		List <String> result_list = do_ExamDAO.selectAllAnswer(exam_id);
		
		return result_list;
	}
	private static double show_result(int exam_id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			
		BT_model a = do_ExamDAO.showI4_exam(exam_id);
		List <Question> b = do_ExamDAO.selectAllQuestion(exam_id);
		List <String> c = get_Result(exam_id);
		double keep2= b.size();
		List <String> user =  new ArrayList < > () ;
		for (int i=1;i<=keep2;i++)
		{	
			String keep3 = Integer.toString(i);
			user.add( request.getParameter(keep3));
		}
		for (int i=0;i<b.size();i++)
		{
			Question keep = b.get(i);
			keep.setUser_answer(user.get(i));
			b.set(i, keep);
		}
		int check =0;
		for (int i=0;i<b.size();i++)
		{	System.out.println(b.get(i).getRight_answer());
			System.out.print(user.get(i));
			if (b.get(i).getRight_answer().equals(user.get(i)))
			{
				check +=1;
			}
			
				
		}
		String num_ques = df.format(keep2);
		double point = (double)(check/keep2)*10;
		String point2 = df.format(point);
		System.out.print(check);
		request.setAttribute("answer_All", check);
		request.setAttribute("point", point2);
		request.setAttribute("num_question", c.size());
		request.setAttribute("in4_exam", a);
		request.setAttribute("list_question", b);
		request.setAttribute("list_answer", c);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
	        dispatcher.forward(request, response);
	        return point;
	 }
	
}
