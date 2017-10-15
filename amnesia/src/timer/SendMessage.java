package timer;

import java.util.Calendar;
import java.util.TimerTask;

import utils.Constants;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

class SendMessage extends TimerTask {

	private String name;
	private String number;

	SendMessage(String name, String number) {
		this.name = name;
		this.number = number;
	}

	@Override
	public void run() {
		Calendar c = Calendar.getInstance();
		int HOUR = c.get(Calendar.HOUR_OF_DAY);
		if (HOUR < Constants.NIGHT && HOUR > Constants.DAY) {
			Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
			int i = 0;
			while (i < 5) {
				try {
					Message message = Message.creator(
							new PhoneNumber(number),
							new PhoneNumber("+13232104804"),
							"This message is just to make you remember that your name is " + name).create();
					System.out.println(message.getStatus());
					break;
				} catch (Exception e) {
					System.out.println("Exception occured : " + e.getMessage());
					i++;
				}
			}
		} else {
			System.out.println("SLEEPING TIME !!");
		}
	}

}
