package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class changeProfile
 */
public class changeName extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Logger nameChange = Logger.getLogger(changeName.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Employee e = EmployeeService.getEService().getEmployeeById((int)session.getAttribute("user"));
		
		String nFName = request.getParameter("newFname");
		String nLName = request.getParameter("newLname");
		
		EmployeeService.getEService().updateName(e.getU_ID(), nFName, nLName);
		
		nameChange.info(e.getU_ID() + " changed their name to " + nFName + " " + nLName);
		
		RequestDispatcher rd = request.getRequestDispatcher("homePage.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
