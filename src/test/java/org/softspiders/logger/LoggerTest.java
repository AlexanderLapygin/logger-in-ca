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

	// LogWriter: create, add, remove

	@Test
	public void JustAfterLoggerCreationItsWriterListIsNotNull() {
		assertNotNull((new Logger()).getWriters());
	}

	@Test
	public void JustAfterLoggerCreationItsWriterListHasDefaultWriterOnly() {
		Logger logger = new Logger();
		assertEquals(logger.getWriters().size(), 1);
		LogWriter writer = logger.getWriters().get(0);
		assertTrue(writer instanceof DefaultWriter);
	}

	@Test
	public void AddingWriterAddsItToTheWriterList() {
		Logger logger = new Logger();
		LogWriter writer = new DefaultWriter(); // any LogWriter
		logger.addWriter(writer);
		assertTrue(logger.getWriters().contains(writer));
	}

	@Test
	public void RemovingWriterRemovesItFromTheWriterList() {
		Logger logger = new Logger();
		LogWriter writer = new DefaultWriter(); // any LogWriter
		logger.addWriter(writer);
		logger.removeWriter(writer);
		assertFalse(logger.getWriters().contains(writer));
	}

	// Logging: trace, debug, info, warn, error, fatal

//	@Test
//	public void TraceCallsTracedWriter() {
//		Logger logger = new Logger();
//		logger.trace("!!!");
//	}
}