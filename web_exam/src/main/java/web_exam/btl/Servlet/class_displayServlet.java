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
import web_exam.btl.model.Class_struct;



@WebServlet("/display")

public class class_displayServlet  extends HttpServlet{
	
		
	 
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
	       
	        // lay du lieu tu seasion
	        HttpSession session = request.getSession();
			 int student_id=(int)session.getAttribute("student_id");
			 int admin_q=(int)session.getAttribute("adminID");
			 String option_class;
			 if (admin_q >0)
			 {
				 option_class = "Xóa lớp";
			 }
			 else {
				 option_class ="Rời lớp";
			 }
	        try {
				listClass(request, response,  admin_q,student_id, option_class);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	       
	    private void listClass(HttpServletRequest request, HttpServletResponse response, int admin_id, int student_id, String option_class)
	    throws SQLException, IOException, ServletException {
	        List < Class_struct > listClass = Class_Dao.selectAllClass(admin_id, student_id);
	        if (listClass.isEmpty())
	        {
	        	request.setAttribute("notice_noclass", "Bạn chưa tham gia class nào !");
	        }
	       
	        request.setAttribute("listClass", listClass);
	        request.setAttribute("exit_class", option_class);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("main_ad.jsp");
	        dispatcher.forward(request, response);
	    }

	  
	}

