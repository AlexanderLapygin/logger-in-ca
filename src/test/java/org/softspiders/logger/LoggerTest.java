package org.softspiders.logger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoggerTest {
	@Mock
	LogWriter traceLogWriterMock;

	@Mock
	LogWriter debugLogWriterMock;

	@Mock
	LogWriter infoLogWriterMock;

	@Mock
	LogWriter warnLogWriterMock;

	@Mock
	LogWriter errorLogWriterMock;

	@Mock
	LogWriter fatalLogWriterMock;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(traceLogWriterMock.getLevel()).thenReturn(LogLevels.TRACE);
		when(debugLogWriterMock.getLevel()).thenReturn(LogLevels.DEBUG);
		when(infoLogWriterMock.getLevel()).thenReturn(LogLevels.INFO);
		when(warnLogWriterMock.getLevel()).thenReturn(LogLevels.WARN);
		when(errorLogWriterMock.getLevel()).thenReturn(LogLevels.ERROR);
		when(fatalLogWriterMock.getLevel()).thenReturn(LogLevels.FATAL);
	}

	// Creation tests

	@Test
	public void CalmCreation() {
		new Logger();
	}

	@Test
	public void LoggerIsInstanceOfLogService() {
		assertTrue(new Logger() instanceof LogService);
	}

	// LogWriters: create, add, remove

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
		LogWriter anyWriter = traceLogWriterMock;
		logger.addWriter(anyWriter);
		assertTrue(logger.getWriters().contains(anyWriter));
	}

	@Test
	public void RemovingWriterRemovesItFromTheWriterList() {
		Logger logger = new Logger();
		LogWriter anyWriter = traceLogWriterMock;
		logger.addWriter(anyWriter);
		logger.removeWriter(anyWriter);
		assertFalse(logger.getWriters().contains(anyWriter));
	}

	// LogWriters invocations by: logger.trace, logger.debug, logger.info, logger.warn, logger.error, logger.fatal

	@Test
	public void TraceCallsTraceWriter() {
		Logger logger = new Logger();
		logger.addWriter(traceLogWriterMock);
		String message = "trace message";
		logger.trace(message);
		verify(traceLogWriterMock, times(1)).log(message);
	}

	@Test
	public void DebugCallsDebugWriter() {
		Logger logger = new Logger();
		logger.addWriter(debugLogWriterMock);
		String message = "debug message";
		logger.debug(message);
		verify(debugLogWriterMock, times(1)).log(message);
	}

	@Test
	public void InfoCallsInfoWriter() {
		Logger logger = new Logger();
		logger.addWriter(infoLogWriterMock);
		String message = "info message";
		logger.info(message);
		verify(infoLogWriterMock, times(1)).log(message);
	}

	@Test
	public void WarnCallsWarnWriter() {
		Logger logger = new Logger();
		logger.addWriter(warnLogWriterMock);
		String message = "warn message";
		logger.warn(message);
		verify(warnLogWriterMock, times(1)).log(message);
	}

	@Test
	public void ErrorCallsErrorWriter() {
		Logger logger = new Logger();
		logger.addWriter(errorLogWriterMock);
		String message = "error message";
		logger.error(message);
		verify(errorLogWriterMock, times(1)).log(message);
	}

	@Test
	public void FatalCallsFatalWriter() {
		Logger logger = new Logger();
		logger.addWriter(fatalLogWriterMock);
		String message = "fatal message";
		logger.fatal(message);
		verify(fatalLogWriterMock, times(1)).log(message);
	}

	@Test
	public void EachLogLevelCallInMixProduceCorrespondentLogWriterCall() {
		Logger logger = new Logger();

		when(traceLogWriterMock.getLevel()).thenReturn(LogLevels.TRACE);
		logger.addWriter(traceLogWriterMock);
		when(debugLogWriterMock.getLevel()).thenReturn(LogLevels.DEBUG);
		logger.addWriter(debugLogWriterMock);
		when(infoLogWriterMock.getLevel()).thenReturn(LogLevels.INFO);
		logger.addWriter(infoLogWriterMock);
		when(warnLogWriterMock.getLevel()).thenReturn(LogLevels.WARN);
		logger.addWriter(warnLogWriterMock);
		when(errorLogWriterMock.getLevel()).thenReturn(LogLevels.ERROR);
		logger.addWriter(errorLogWriterMock);
		when(fatalLogWriterMock.getLevel()).thenReturn(LogLevels.FATAL);
		logger.addWriter(fatalLogWriterMock);

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

		verify(traceLogWriterMock, times(1)).log("message");
		verify(debugLogWriterMock, times(2)).log("message");
		verify(infoLogWriterMock, times(3)).log("message");
		verify(warnLogWriterMock, times(4)).log("message");
		verify(errorLogWriterMock, times(5)).log("message");
		verify(fatalLogWriterMock, times(6)).log("message");
	}
}