package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.Reimbursment;
import app.ReimbursmentService;

/**
 * Servlet implementation class ReimbursementView
 */
public class allReimbursments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public allReimbursments() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Reimbursment> pendList = ReimbursmentService.getRService().viewAllPending();
		List<Reimbursment> resolveList = ReimbursmentService.getRService().viewAllResolved();

		PrintWriter pw = response.getWriter();
		pw.write("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>View Profile</title>"
				+ "</head><body>");

		String tableStart = "<table><tr><th>ID</th><th>Amount</th><th>Description</th><th>Employee</th><th>Date Submitted</th><th>Status</th><th>Manager ID</th><th></th><th></th></tr>";
		String tableEnd = "</table>";

		pw.write(tableStart);

		// useless comment

		for (Reimbursment r : pendList) {
			pw.write("<tr><td>" + r.getR_ID() + "</td><td>" + r.getAmount() + "</td><td>" + r.getDescription()
					+ "</td><td>" + r.getU_ID() + "</td><td>" + r.getDateSubmitted() + "</td><td>" + r.getStatus()
					+ "</td><td>" + r.getM_ID() + 
					"</td><td><form action=\"resolveReimbursment\"><input name=\"rName\" type=\"hidden\" value=" + r.getR_ID() 
					+ "><input name=\"button\" type=\"hidden\" value=\"Approve\"><input type=\"submit\" value=\"Approve\"/></form></td><td><form action=\"resolveReimbursment\"><input name=\"rName\" type=\"hidden\" value="
					+ r.getR_ID() 
					+ "><input name=\"button\" type=\"hidden\" value=\"Reject\"><input type=\"submit\" value=\"Reject\"/></form></td></tr>");
		}

		for (Reimbursment r : resolveList) {
			pw.write("<tr><td>" + r.getR_ID() + "</td><td>" + r.getAmount() + "</td><td>" + r.getDescription()
					+ "</td><td>" + r.getU_ID() + "</td><td>" + r.getDateSubmitted() + "</td><td>" + r.getStatus()
					+ "</td><td>" + r.getM_ID() + "</td><td></td><td></td></tr>");
		}

		pw.write(tableEnd);

		pw.write("</body><script src=\"displayStuff.js\"></script></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
