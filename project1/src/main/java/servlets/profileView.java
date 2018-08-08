package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.Employee;
import app.EmployeeService;

/**
 * Servlet implementation class profileView
 */
public class profileView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profileView() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Employee e = EmployeeService.getEService().getEmployeeById((int) session.getAttribute("user"));
		
		PrintWriter pw = response.getWriter();
		pw.write("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>View Profile</title>"
				+ "</head><body>");
		
		String tableStart = "<table><tr><th>ID</th><th>First Name</th><th>Last Name</th><th>E-mail</th><th>Password</th></tr>";
		String tableData = "<tr><td>" + e.getU_ID() + "</td><td>" + e.getFirstname() + "</td><td>" + e.getLastname() + "</td><td>" + e.getEmail() + "</td><td>" + e.getPassword() + "</td></tr>";
		String tableEnd = "</table> <div><button onclick = \"changeUserName()\">Change Name</button><button onclick = \"changeUserEmail()\">Change E-mail</button><button onclick = \"changeUserPassword()\">Change Password</button></div>";
		String changeOptions = "<div><button onclick = \"hideUserInfo()\">Hide Profile</button></div>";
		

		pw.write(tableStart + tableData + tableEnd + changeOptions);

		pw.write("</body><script src=\"displayStuff.js\"></script></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
