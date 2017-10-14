package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HourMessage {

	private ScheduledExecutorService s;
	private String name;
	private String number;

	HourMessage() {
		s = Executors.newSingleThreadScheduledExecutor();
	}

	public HourMessage(String name, String number) {
		this();
		this.name = name;
		this.number = number;
	}

	public void startTask() {
		SendMessage task = new SendMessage(name, number);
		s.scheduleAtFixedRate(task, 0, 1, TimeUnit.HOURS);
	}

	public void shutDown() {
		if (s != null) {
			System.out.println("SHUTDOWN");
			s.shutdown();
		}
	}
}
