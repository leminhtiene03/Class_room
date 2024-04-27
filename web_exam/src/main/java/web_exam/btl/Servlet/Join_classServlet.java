package web_exam.btl.Servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_exam.btl.DAO.Class_Dao;
import web_exam.btl.DAO.Student_Join;



@WebServlet("/join_class")
public class Join_classServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private Class_Dao classDao;
	    
	 

	    public void init() {
	    	classDao = new Class_Dao();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    	  request.setCharacterEncoding("UTF-8");
	    	    response.setCharacterEncoding("UTF-8");
	      
	       
	       
	        try {
	        	 HttpSession session = request.getSession();
	        	 int student_id=(int)session.getAttribute("student_id");
				 int admin_q=(int)session.getAttribute("adminID");
	        	 
				 int a = Integer.parseInt(request.getParameter("join_class_l"));
				 String result = Student_Join.join_class(a, student_id);
				 request.setAttribute("join_class_result", result);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("display");
			        dispatcher.forward(request, response);
				 
	        	
	        	
	        } catch (Exception e) {
	           
	            e.printStackTrace();
	        }

	       
	    }
}
