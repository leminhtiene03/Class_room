package web_exam.btl.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_exam.btl.DAO.LoginDao;
import web_exam.btl.model.LoginBean;



/**
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
   

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("useremail");
        String password = request.getParameter("userpassword");
       
     
        
    	
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
               try {
            	   
            	   
        	int admin_num = loginDao.validate(loginBean);
            if (admin_num>0) {
            	 HttpSession session = request.getSession();
                 session.setAttribute("username",username);
                 session.setAttribute("adminID",admin_num);
                 session.setAttribute("student_id",-1);
              	 
            	
            	// response.sendRedirect("main_ad.jsp");
                 RequestDispatcher rd = request.getRequestDispatcher("/display");
                 rd.forward(request,response);
            	 return;
            } 
            int student_id = loginDao.validate2(loginBean);
            System.out.print(student_id);
            if (student_id >0) {
            	 HttpSession session = request.getSession();
                 session.setAttribute("username",username);
                 session.setAttribute("student_id",student_id);
                 session.setAttribute("adminID",-1);
                
              	 
            	
            //	 response.sendRedirect("main_ad.jsp");
                 RequestDispatcher rd = request.getRequestDispatcher("/display");
                 rd.forward(request,response); 
            	 
            } 
            
            
             else {
            	 request.setAttribute("wrong_login", "Wrong username or password ! ");
        		 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        	        dispatcher.forward(request, response);
            	 
             }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
        	
        
    }
}