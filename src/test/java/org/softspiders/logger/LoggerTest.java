package org.softspiders.logger;

import org.junit.Test;

import java.io.Writer;

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

	// Tests related to Writers

	@Test
	public void JustAfterLoggerCreationItsWriterListIsNotNull() {
		assertNotNull((new Logger()).getWriters());
	}

	@Test
	public void JustAfterLoggerCreationItsWriterListIsEmpty() {
		assertEquals((new Logger()).getWriters().size(), 0);
	}

	@Test
	public void AddingWriterAddsItToTheWriterList() {
		Logger logger = new Logger();
		LogWriter writer = new DefaultWriter();
		logger.addWriter(writer);
		assertTrue(logger.getWriters().contains(writer));
	}
}