package atj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, description = "Miki link cutter", urlPatterns = { "/LinkCutter" })
public class LinkCutter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database = new Database();
	private String chars = "qwertyuioplkjhgfdsazxcvbnm";
	private Random r = new Random();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter printWriter = response.getWriter();
		String linkLong = request.getParameter("link");
		String myLink = "";
		int paramSelect = Integer.parseInt(request.getParameter("action"));
		int length = chars.length();

		for (int i = 0; i < paramSelect; i++) {
			myLink += chars.charAt(r.nextInt(length));
		}

		database.addToDB(myLink, linkLong);

		printWriter.println("<table style=\"border: colapse; width: 100%;\">"
				+ "<tr style=\"background-color: #4caf50; color: white\">" 
				+ "<th style=\"width: 10%\">KLUCZ</th>"
				+ "<th style=\"width: 40%\">LINK</th>"
				+ "<th style=\"width: 50%\">WARTOSC</th>" 
				+ "</tr>");
		
		for (Map.Entry<String, String> entry : database.getDatabase().entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();

			printWriter.println("<tr style=\"borser: 1px solid #ddd;\">" + "<td>" + key + "</td>"
			        + "<td>" + "http://localhost:8080/FirstServlet/lr?link=" + key + "</td>" 
					+ "<td>" + value + "</td>" + "</tr>");
		}
		printWriter.println("</table>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
