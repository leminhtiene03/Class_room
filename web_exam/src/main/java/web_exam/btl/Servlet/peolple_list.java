package web_exam.btl.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_exam.btl.DAO.EXAM_DAO;
import web_exam.btl.model.Student;

/**
 * Servlet implementation class peolple_list
 */
@WebServlet("/people_list")
public class peolple_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		int a = (int) session.getAttribute("class_keep");
		try {

			List<Student> all_student = listPeople(request, response, a);
			List<Student> all_teacher = new ArrayList<>();
			
			Student Admin =  listAdmin(request,response,a);
			all_teacher.add(Admin);
			request.setAttribute("List_Student", all_student);
			request.setAttribute("all_teacher", all_teacher);
			request.setAttribute("Giangvien", "Giảng viên");
			request.setAttribute("Hocsinh", "Học sinh");
			RequestDispatcher dispatcher = request.getRequestDispatcher("list_exam.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private List<Student> listPeople(HttpServletRequest request, HttpServletResponse response, int a)
			throws SQLException, IOException, ServletException {

		List<Student> List_Student = EXAM_DAO.selectAllPeople(a);
		
		return List_Student;
	}

	private Student listAdmin(HttpServletRequest request, HttpServletResponse response, int a)
			throws SQLException, IOException, ServletException {

		Student adminne = EXAM_DAO.selectAdmin(a);

		
		return adminne;
	}

}
