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

	@Test
	public void AllLevelCallsProduceCorrespondentWriterCalls() {
		Logger logger = new Logger();
		LogWriter logTraceWriterMock = addLogWriter(logger, LogLevels.TRACE);
		LogWriter logDebugWriterMock = addLogWriter(logger, LogLevels.DEBUG);
		LogWriter logInfoWriterMock = addLogWriter(logger, LogLevels.INFO);
		LogWriter logWarnWriterMock = addLogWriter(logger, LogLevels.WARN);
		LogWriter logErrorWriterMock = addLogWriter(logger, LogLevels.ERROR);
		LogWriter logFatalWriterMock = addLogWriter(logger, LogLevels.FATAL);

		logger.trace("message");

		logger.debug("message");
		logger.debug("message");

		logger.info("message");
		logger.info("message");
		logger.info("message");

		logger.warn("message");
		logger.warn("message");
		logger.warn("message");
		logger.warn("message");

		logger.error("message");
		logger.error("message");
		logger.error("message");
		logger.error("message");
		logger.error("message");

		logger.fatal("message");
		logger.fatal("message");
		logger.fatal("message");
		logger.fatal("message");
		logger.fatal("message");
		logger.fatal("message");

		Mockito.verify(logTraceWriterMock, times(1)).log("message");
		Mockito.verify(logDebugWriterMock, times(2)).log("message");
		Mockito.verify(logInfoWriterMock, times(3)).log("message");
		Mockito.verify(logWarnWriterMock, times(4)).log("message");
		Mockito.verify(logErrorWriterMock, times(5)).log("message");
		Mockito.verify(logFatalWriterMock, times(6)).log("message");
	}

	private LogWriter addLogWriter(Logger logger, LogLevels level) {
		LogWriter logTraceWriterMock = Mockito.mock(LogWriter.class);
		when(logTraceWriterMock.getLevel()).thenReturn(level);
		logger.addWriter(logTraceWriterMock);
		return logTraceWriterMock;
	}
}