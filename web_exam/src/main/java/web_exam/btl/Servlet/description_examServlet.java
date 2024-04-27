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
import web_exam.btl.model.Detail_class;

@WebServlet("/description")
public class description_examServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private EXAM_DAO exam_dao;
  
	 public void init() {
	    	exam_dao = new EXAM_DAO();
	    }

	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        doGet(request, response);
			       
			    }

			    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        String action = request.getServletPath();
			               try {
			            	   System.out.println("is running des");
			            	   
			            	   //class_keep = Integer.parseInt(request.getParameter("detect_class"));
			                   System.out.println("       "+request.getParameter("id2"));
			                  int exam_keep = Integer.parseInt(request.getParameter("id2"));
			                   HttpSession session = request.getSession();
			                   session.setAttribute("exam_keep",exam_keep);
			                   listDES(request, response,Integer.parseInt(request.getParameter("id2"))  );
					} catch (SQLException | IOException | ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }

			       
			    private void listDES(HttpServletRequest request, HttpServletResponse response, int a)
			    throws SQLException, IOException, ServletException {
			    	 HttpSession session = request.getSession();
					
					 int admin_q=(int)session.getAttribute("adminID");
			        List < Detail_class > listClass = EXAM_DAO.selectAllDescription(a,admin_q);
			        if(listClass ==null) return; 
			        System.out.print(listClass.size());
			        
			        request.setAttribute("listDes", listClass);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("list_exam.jsp");
			        dispatcher.forward(request, response);
			    }

}
