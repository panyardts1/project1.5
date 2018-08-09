package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import app.Employee;
import app.EmployeeService;
import app.Reimbursment;
import app.ReimbursmentService;

/**
 * Servlet implementation class submitReimbursment
 */
public class submitReimbursment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public submitReimbursment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		float amount = Float.parseFloat(request.getParameter("reimbursmentAmount"));
		String description = request.getParameter("reimbursmentDescription");
		
		HttpSession session = request.getSession(false);
		Employee e = EmployeeService.getEService().getEmployeeById((int)session.getAttribute("user"));
		
		System.out.println(e.toString());
		
		Reimbursment r = new Reimbursment(0, amount, description, e.getU_ID(), new Date(), "pending", 0);
		
		ReimbursmentService.getRService().submitReimbursment(r);
		
		RequestDispatcher rd = request.getRequestDispatcher("homePage.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
