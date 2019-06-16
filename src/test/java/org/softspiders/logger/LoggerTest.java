package org.softspiders.logger;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerTest {

	@Test
	public void CalmCreation() {
		new Logger();
	}

	@Test
	public void LoggerIsInstanceOfLogService() {
		assertTrue(new Logger() instanceof LogService);
	}
}