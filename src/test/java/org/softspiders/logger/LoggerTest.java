package org.softspiders.logger;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerTest {

	// Creation tests

	@Test
	public void CalmCreation() {
		new Logger();
	}

	@Test
	public void LoggerIsInstanceOfLogService() {
		assertTrue(new Logger() instanceof LogService);
	}

	// Writers basic tests

	@Test
	public void JustAfterLoggerCreationItsWriterListIsNotNull() {
		Assert.assertNotNull((new Logger()).getWriters());
	}
}