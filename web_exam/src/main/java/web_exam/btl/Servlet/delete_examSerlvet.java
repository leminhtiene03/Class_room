package web_exam.btl.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_exam.btl.DAO.Class_Dao;
import web_exam.btl.DAO.EXAM_DAO;

/**
 * Servlet implementation class delete_examSerlvet
 */
@WebServlet("/delete_exam")
public class delete_examSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
			System.out.print("try to delete exam");
			deleteExam(request,response);
		} catch (SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	  private void deleteExam(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
		  System.out.println();
		  System.out.print(request.getParameter("id3"));
		 
	    	        int id = Integer.parseInt(request.getParameter("id3"));
	    	       EXAM_DAO.deleteExam(id);
	    	        
	    	        response.sendRedirect("list_exam.jsp");
	    	        

	    	    }
}
