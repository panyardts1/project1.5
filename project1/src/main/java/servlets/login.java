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

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import app.Employee;
import app.EmployeeService;
import dao.EmployeeDAOImpl;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger loginLog = Logger.getLogger(login.class);
    public login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String email = request.getParameter("useremail");
		String password = request.getParameter("userpassword");
		
		//System.out.println(email);
		
		Employee e = EmployeeService.getEService().getEmployeeByEmail(email);
		if(e != null) {
			if(e.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("sessionID", Integer.toString(e.getU_ID()) + new Date());
				session.setAttribute("user", e.getU_ID());
				if(e.isManager()) {
					RequestDispatcher rd = request.getRequestDispatcher("managerPage.html");
					rd.forward(request, response);
					loginLog.info(email + " logged in");
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("homePage.html");
					rd.forward(request, response);
					loginLog.info(email + " logged in");
				}
			}
			else {
				response.getWriter().append("password incorrect");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);
				loginLog.info(email + " tried to log in with the wrong password");
			}
		}
		else {
			response.getWriter().append("e-mail incorrect");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			loginLog.info("Non-user attempted to log in");
		}
		


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
