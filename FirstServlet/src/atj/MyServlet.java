package atj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(asyncSupported = true, description = "Miki servlet", urlPatterns = { "/MyServlet" })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private double result;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// System.out.println("Krzycz Tyrbson HaHaHa"); to nie działa
		// PrintWriter printWriter = response.getWriter();
		// printWriter.println("<h1 style=\"color: green\">Serwlet</h1>");
//		String paramOne = request.getParameter("param1");
//		PrintWriter printWriter = response.getWriter();
//		printWriter.println("<h1 style=\"color: green\">" + paramOne + " Serwlet</h1>");
		//html kalkulator
		String paramSelect = request.getParameter("action");
		double valueOne = Double.parseDouble(request.getParameter("value1"));
		double valueTwo = Double.parseDouble(request.getParameter("value2"));
		if (paramSelect.equals("add")) {
 			result = valueOne + valueTwo;
		} else if (paramSelect.equals("sub")) {
			result = valueOne - valueTwo;
		} else if (paramSelect.equals("mul")) {
			result = valueOne * valueTwo;
		} else if (paramSelect.equals("div")){
		    result = valueOne / valueTwo;
		} else {
			result = valueOne % valueTwo;
		}
 		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1 style=\"color: green\">" + result + " Serwlet</h1>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
