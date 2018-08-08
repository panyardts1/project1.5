package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.Employee;
import app.EmployeeService;
import app.ReimbursmentService;

/**
 * Servlet implementation class resolveReimbursment
 */
public class resolveReimbursment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public resolveReimbursment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = Integer.parseInt(request.getParameter("rName"));
		String status = request.getParameter("button");
		
		HttpSession session = request.getSession(false);
		Employee e = EmployeeService.getEService().getEmployeeById((int)session.getAttribute("user"));
		
		if(status.equals("Approve")) {
			ReimbursmentService.getRService().approveReimbursment(number, e.getU_ID());
		}
		else if(status.equals("Reject")) {
			ReimbursmentService.getRService().rejectReimbursment(number, e.getU_ID());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("managerPage.html");
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
