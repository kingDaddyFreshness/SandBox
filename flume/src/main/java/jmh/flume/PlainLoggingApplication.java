package jmh.flume;

import org.apache.log4j.Logger;

public class PlainLoggingApplication {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(PlainLoggingApplication.class);
		
		for (int i = 1; i <= 1000; i++) {
		
			logger.info("message " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
