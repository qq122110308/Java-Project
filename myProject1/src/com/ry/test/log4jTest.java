package com.ry.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class log4jTest {
	public static Logger logger1 = Logger.getLogger(log4jTest.class);
	
	@Test
	public void test01(){
		logger1.trace("trace");
		logger1.debug("debug");
		logger1.info("info");
		logger1.warn("warn");
		logger1.error("error");
		logger1.fatal("fatal");
	}
}
