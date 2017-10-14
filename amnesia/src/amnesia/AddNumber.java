package amnesia;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import timer.HourMessage;
import model.User;

/**
 * Servlet implementation class AddNumber
 */
public class AddNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("user") == null) {
			
			String name = request.getParameter("name");
			String mobile = request.getParameter("mobile");
			
			User user = new User();
			user.setMobile(mobile);
			user.setName(name);
			
			HourMessage hm = new HourMessage(name, mobile);
			hm.startTask();
			
			ServletContext sc = this.getServletConfig().getServletContext();
			sc.setAttribute("messageStatus", hm);
			
			System.out.println("OBJECT STORED");
			session.setAttribute("user", user);
			session.setAttribute("time", Calendar.getInstance());
		}
		response.sendRedirect("logs.jsp");
	}

}
