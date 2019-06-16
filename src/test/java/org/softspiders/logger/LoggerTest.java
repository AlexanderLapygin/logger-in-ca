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
		assertNotNull((new Logger()).getWriters());
	}

	@Test
	public void JustAfterLoggerCreationItsWriterListIsEmpty() {
		assertEquals((new Logger()).getWriters().size(), 0);
	}
}