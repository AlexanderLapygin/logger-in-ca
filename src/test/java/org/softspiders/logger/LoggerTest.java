package org.softspiders.logger;

import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

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
	public void JustAfterLoggerCreationItsWriterListIsEmpty() {
		Logger logger = new Logger();
		assertEquals(logger.getWriters().size(), 0);
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

	@Test
	public void InfoCallsInfoWriter() {
		LogWriter logWriterMock = Mockito.mock(LogWriter.class);
		when(logWriterMock.getLevel()).thenReturn(LogLevels.INFO);
		Logger logger = new Logger();
		logger.addWriter(logWriterMock);
		String message = "some message";
		logger.info(message);
		Mockito.verify(logWriterMock, times(1)).log(message);
	}
}