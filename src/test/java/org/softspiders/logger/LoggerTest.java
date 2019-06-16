package org.softspiders.logger;

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
		LogWriter writer1 = new DefaultWriter();
		logger.addWriter(writer1);
		assertTrue(logger.getWriters().contains(writer));
		assertTrue(logger.getWriters().contains(writer1));
	}

	@Test
	public void RemovingWriterRemovesItFromTheWriterList() {
		Logger logger = new Logger();
		LogWriter writer = new DefaultWriter();
		logger.addWriter(writer);
		LogWriter writer1 = new DefaultWriter();
		logger.addWriter(writer1);
		logger.removeWriter(writer);
		assertFalse(logger.getWriters().contains(writer));
		assertTrue(logger.getWriters().contains(writer1));
		logger.removeWriter(writer1);
		assertFalse(logger.getWriters().contains(writer1));
	}
}