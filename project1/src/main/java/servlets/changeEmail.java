package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import app.Employee;
import app.EmployeeService;
import dao.EmployeeDAOImpl;

/**
 * Servlet implementation class changeEmail
 */
public class changeEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger emailLog = Logger.getLogger(changeEmail.class);
    public changeEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Employee e = EmployeeService.getEService().getEmployeeById((int)session.getAttribute("user"));
		
		String nEmail = request.getParameter("newEmail");
		
		EmployeeService.getEService().updateEmail(e.getU_ID(), nEmail);
		
		emailLog.info(e.getU_ID() + " changed their email to " + nEmail);
		
		RequestDispatcher rd = request.getRequestDispatcher("homePage.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
