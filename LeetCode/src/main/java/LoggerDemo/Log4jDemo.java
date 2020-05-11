package LoggerDemo;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4jDemo {
	static final Logger logger = Logger.getLogger(Log4jDemo.class);

	public static void main(String[] args) {

		logger.setLevel(Level.WARN);
		// debug level
		logger.debug("This is debug level  log");
		// info level
		logger.info("This is info level log");
		// warning level
		logger.warn("This is warning level log");
		// error level
		logger.error("This is error level log");
	}

}
