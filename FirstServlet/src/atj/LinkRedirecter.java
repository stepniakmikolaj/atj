package atj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, description = "Miki link cutter", urlPatterns = { "/lr" })
public class LinkRedirecter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Database database = new Database();
	public String redirectSite;
	boolean redirect = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			response.sendRedirect(database.getHTTPSite(request.getParameter("link")));
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
