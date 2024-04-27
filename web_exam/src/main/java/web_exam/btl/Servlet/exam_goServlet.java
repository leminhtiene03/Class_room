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

import web_exam.btl.DAO.EXAM_DAO;
import web_exam.btl.model.EXAM_list;


@WebServlet("/exam_go")
public class exam_goServlet extends HttpServlet{
	private int class_keep;
    private static final long serialVersionUID = 1L;
    private EXAM_DAO exam_dao;
    
    public void init() {
    	exam_dao = new EXAM_DAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
        response.sendRedirect("list_exam.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
               try {
            	   System.out.println("is running");
            	   
            	   //class_keep = Integer.parseInt(request.getParameter("detect_class"));
                   System.out.println("       "+request.getParameter("id"));
                   
                   if (request.getParameter("id") != null)
                   {	
                	   class_keep = Integer.parseInt(request.getParameter("id"));
                	   HttpSession session = request.getSession();
                 		session.setAttribute("class_keep",class_keep);
           				listExam(request, response,class_keep );
           				
                   }
                   
                   else {
                	   HttpSession session = request.getSession();
                	   int admin_q=(int)session.getAttribute("class_keep");
                	   listExam(request, response,class_keep );
                   }
                 
            
		} catch (SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

       
    private void listExam(HttpServletRequest request, HttpServletResponse response, int a)
    throws SQLException, IOException, ServletException {
        List < EXAM_list > listClass = EXAM_DAO.selectAllEXAM(a);
        request.setAttribute("listClass", listClass);
        if (listClass ==null)return;
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_exam.jsp");
        dispatcher.forward(request, response);
    }

  
}
