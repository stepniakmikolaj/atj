package atj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, description = "Miki link cutter", urlPatterns = { "/LinkCutter" })
public class LinkCutter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> mapa = new LinkedHashMap<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String linkLong = request.getParameter("link");
//		String myLink = "https://miki/";
		String myLink = "miki/";
		int paramSelect = Integer.parseInt(request.getParameter("action"));
		String chars = "qwertyuiopasdfghjklzxcvbnm";
		int length = chars.length();
		java.util.Random r = new java.util.Random();

		for (int i = 0; i < paramSelect; i++) {
			myLink += chars.charAt(r.nextInt(length));
		}

		mapa.put(myLink, linkLong);

		printWriter.println("<table style=\"border: colapse; width: 100%;\">"
				+ "<tr style=\"background-color: #4caf50; color: white\">" + "<th style=\"width: 30%\">KLUCZ</th>"
				+ "<th style=\"width: 70%\">WARTOSC</th>" + "</tr>");
		for (Map.Entry<String, String> entry : mapa.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();

			printWriter.println("<tr style=\"borser: 1px solid #ddd;\">" + "<td>" + key + "</td>" + "<td>" + value
					+ "</td>" + "</tr>");
		}
		printWriter.println("</table>");

		String userLink = request.getQueryString();
		for (Map.Entry<String, String> entry : mapa.entrySet()) {
			printWriter.println(userLink + "<br>");
			String key = entry.getKey();
			String value = entry.getValue();
			printWriter.println(key + "<br>");
			printWriter.println(value + "<br>");
			if (userLink.contains(key))
				response.sendRedirect(value);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
