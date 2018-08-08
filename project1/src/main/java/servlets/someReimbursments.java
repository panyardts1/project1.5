package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.Reimbursment;
import app.ReimbursmentService;

/**
 * Servlet implementation class someReimbursments
 */
public class someReimbursments extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public someReimbursments() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = request.getParameter("eID");

		PrintWriter pw = response.getWriter();
		List<Reimbursment> pendList = ReimbursmentService.getRService().viewEmployeePending(Integer.parseInt(output));
		List<Reimbursment> resolveList = ReimbursmentService.getRService().viewEmployeeResolved(Integer.parseInt(output));
		
		
		pw.write("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>View Profile</title>"
				+ "</head><body>");
		
		String tableStart = "<table><tr><th>ID</th><th>Amount</th><th>Description</th><th>Date Submitted</th><th>Status</th><th>Manager ID</th><th></th><th></th></tr>";
		String tableEnd = "</table><div><button onclick = \"displayAllReimbursments()\">Close</button></div>";

		pw.write(tableStart);
		
		//useless comment
		
		for (Reimbursment r : pendList) {
			pw.write("<tr><td>" + r.getR_ID() + "</td><td>" + r.getAmount() + "</td><td>" + r.getDescription()
					+ "</td><td>" + r.getU_ID() + "</td><td>" + r.getDateSubmitted() + "</td><td>" + r.getStatus()
					+ "</td><td>" + r.getM_ID() + 
					"</td><td><form action=\"resolveReimbursment\"><input name=\"rName\" type=\"hidden\" value=" + r.getR_ID() 
					+ "><input name=\"button\" type=\"hidden\" value=\"Approve\"><input type=\"submit\" value=\"Approve\"/></form></td><td><form action=\"resolveReimbursment\"><input name=\"rName\" type=\"hidden\" value="
					+ r.getR_ID() 
					+ "><input name=\"button\" type=\"hidden\" value=\"Reject\"><input type=\"submit\" value=\"Reject\"/></form></td></tr>");
		}
		
		for(Reimbursment r : resolveList) {
			pw.write("<tr><td>" + r.getR_ID() + "</td><td>" + r.getAmount() + "</td><td>" + r.getDescription() + "</td><td>" + r.getDateSubmitted() + "</td><td>" + r.getStatus() + "</td><td>" + r.getM_ID() + "</td><td></td><td></td></tr>");
		}
		
		pw.write(tableEnd);

		pw.write("</body><script src=\"displayStuff.js\"></script></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
