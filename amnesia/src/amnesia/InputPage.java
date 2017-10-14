package amnesia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Constants;
import model.MessageLog;
import model.User;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

/**
 * Servlet implementation class InputPage
 */
public class InputPage extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
		ResourceSet<Message> messages = Message.reader().read();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String num = user.getMobile();

		List<MessageLog> logs = new ArrayList<>();
		for (Message message : messages) {
			System.out.println("NUM : " + num);
			if (message.getTo().toString().compareTo(num) == 0) {
				MessageLog log = new MessageLog();
				log.setBody(message.getBody());
				log.setReceiver(message.getTo());
				log.setStatus(message.getStatus().toString());
				log.setTime(message.getDateSent().toString());
				logs.add(log);
			}
		}

		System.out.println("LOG : " + logs);

		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(logs,
				new TypeToken<List<MessageLog>>() {
				}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
