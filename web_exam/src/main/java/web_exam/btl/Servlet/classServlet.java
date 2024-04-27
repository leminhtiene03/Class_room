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


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the Book.
 * @email Ramesh Fadatare
 */

@WebServlet("/insert")
public class classServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Class_Dao classDao;
    
 

    public void init() {
    	classDao = new Class_Dao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	  request.setCharacterEncoding("UTF-8");
    	    response.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("class_name");
        String lastName = request.getParameter("class_des");
        
       
       
        Class_struct account = new Class_struct(firstName,lastName);
       

        try {
        	HttpSession session = request.getSession();
			 int admin=(int)session.getAttribute("adminID");
			 if (admin <= 0)
			 {
				 request.setAttribute("notice", "Học sinh không thể tạo lớp học");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/display");
			        dispatcher.forward(request, response);
				 return;
			 }
            Class_Dao.inseartClass(account,admin);
        	
        } catch (Exception e) {
           
            e.printStackTrace();
        }

      //  response.sendRedirect("main_ad.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("/display");
        rd.forward(request,response);
    }
}