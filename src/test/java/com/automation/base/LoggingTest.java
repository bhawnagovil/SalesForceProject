package com.automation.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggingTest {

	
	@Test
	public void login() {
		Logger log= LogManager.getLogger(LoggingTest.class);
		log.info("browser has been launched");
		log.warn("printing warning");
		log.debug("printing error messages");
		log.error("printing error");
		log.fatal("printing fatal messages");
		log.info("completed");
	}
}
