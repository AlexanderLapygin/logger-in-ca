package org.softspiders.logger;

import org.junit.Test;

public class LoggerTest {

	@Test
	public void CalmDefaultCreation() {
		new Logger();
	}

	@Test
	public void CalmCreationWithOptions() {
		new Logger(new LoggerOptions());
	}
}