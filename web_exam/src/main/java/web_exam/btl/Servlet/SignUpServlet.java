package web_exam.btl.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_exam.btl.DAO.SignUpDao;
import web_exam.btl.model.SignUp;



/**
 * @email Ramesh Fadatare
 */

@WebServlet("/register")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SignUpDao signupdao;

    public void init() {
        signupdao = new SignUpDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	  request.setCharacterEncoding("UTF-8");
    	    response.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String admin = request.getParameter("vehicle1");
       

        SignUp account = new SignUp();
        account.setUsername(username);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setPassword(password);
        account.setAdmin(admin);
        

        try {
        	if(admin !=null)
            signupdao.registeraccount(account);
        	else signupdao.normal_user(account);
        } catch (Exception e) {
           
            e.printStackTrace();
        }

        response.sendRedirect("login.jsp");
    }
}