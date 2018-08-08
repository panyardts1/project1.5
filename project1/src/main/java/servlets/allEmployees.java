package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.Employee;
import app.EmployeeService;
import app.Reimbursment;
import app.ReimbursmentService;

/**
 * Servlet implementation class allEmployees
 */
public class allEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> EList = EmployeeService.getEService().listEmployees();
		
		PrintWriter pw = response.getWriter();
		pw.write("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>View Profile</title>"
				+ "</head><body>");
		
		String tableStart = "<table><tr><th>ID</th><th>First Name</th><th>Last Name</th><th>E-mail</th></tr>";
		String tableEnd = "</table>";

		pw.write(tableStart);
		
		for(Employee e : EList) {
			pw.write("<tr><td>" + e.getU_ID() + "</td><td>" + e.getFirstname() + "</td><td>" + e.getLastname() + "</td><td>" + e.getEmail() + "</td></tr>");
		}
		pw.write(tableEnd);

		pw.write("</body><script src=\"displayStuff.js\"></script></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
