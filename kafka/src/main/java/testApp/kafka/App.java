package testApp.kafka;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class App {

	static final Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		System.out.println("BEGIN");
		BasicConfigurator.configure();
		logger.debug("Hello John!");
		System.out.println("DONE");
	}
}
