package web_exam.btl.Servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_exam.btl.DAO.Class_Dao;



@WebServlet("/delete")
public class class_deleteServlet  extends HttpServlet{
	

	 
	    private static final long serialVersionUID = 1L;
	    private Class_Dao class_dao;

	    public void init() {
	    	class_dao = new Class_Dao();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        doGet(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        String action = request.getServletPath();
	        HttpSession session = request.getSession();
			 int student_id=(int)session.getAttribute("student_id");
			 int admin_q=(int)session.getAttribute("adminID");
			 if (admin_q >0)
			 {
				 try {
			        	deleteClass(request, response);
			        	
					} catch (SQLException | IOException q) {
						// TODO Auto-generated catch block
				
					}
			 }
			 else {
				 try {
					remove_class(request,response,student_id);
				} catch (SQLException | IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
	      
	    }

	       
	    private void deleteClass(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    	        int id = Integer.parseInt(request.getParameter("id"));
	    	        Class_Dao.deleteClass(id);
	    	        
	    	       // response.sendRedirect("main_ad.jsp");
	    	        RequestDispatcher rd = request.getRequestDispatcher("/display");
	                 rd.forward(request,response);
	    	        

	    	    }
	    
	    private void remove_class(HttpServletRequest request, HttpServletResponse response,int register_id)
	    	    throws SQLException, IOException, ServletException {
	    	        int class_id = Integer.parseInt(request.getParameter("id"));
	    	        Class_Dao.remove_class(register_id,class_id);
	    	        
	    	      //  response.sendRedirect("main_ad.jsp");
	    	        RequestDispatcher rd = request.getRequestDispatcher("/display");
	                 rd.forward(request,response);
	    	        

	    	    }

	  
	}


