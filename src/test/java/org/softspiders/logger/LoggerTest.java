package org.softspiders.logger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoggerTest {
	// tested class
	private Logger logger;

	@Mock
	private LogWriter traceLogWriterMock;

	@Mock
	private LogWriter debugLogWriterMock;

	@Mock
	private LogWriter infoLogWriterMock;

	@Mock
	private LogWriter warnLogWriterMock;

	@Mock
	private LogWriter errorLogWriterMock;

	@Mock
	private LogWriter fatalLogWriterMock;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(traceLogWriterMock.getLevel()).thenReturn(LogLevels.TRACE);
		when(debugLogWriterMock.getLevel()).thenReturn(LogLevels.DEBUG);
		when(infoLogWriterMock.getLevel()).thenReturn(LogLevels.INFO);
		when(warnLogWriterMock.getLevel()).thenReturn(LogLevels.WARN);
		when(errorLogWriterMock.getLevel()).thenReturn(LogLevels.ERROR);
		when(fatalLogWriterMock.getLevel()).thenReturn(LogLevels.FATAL);

		logger = new Logger();
	}

	// Creation tests

	@Test
	public void CalmCreation() {
		new Logger();
	}

	@Test
	public void LoggerIsInstanceOfLogService() {
		assertTrue(logger instanceof LogService);
	}

	// LogWriters: create, add, remove

	@Test
	public void JustAfterLoggerCreationItsWriterListIsNotNull() {
		assertNotNull(logger.getWriters());
	}

	@Test
	public void JustAfterLoggerCreationItsWriterListIsEmpty() {
		assertEquals(logger.getWriters().size(), 0);
	}

	@Test
	public void AddingWriterAddsItToTheWriterList() {
		LogWriter anyWriter = traceLogWriterMock;
		logger.addWriter(anyWriter);
		assertTrue(logger.getWriters().contains(anyWriter));
	}

	@Test
	public void RemovingWriterRemovesItFromTheWriterList() {
		LogWriter anyWriter = traceLogWriterMock;
		logger.addWriter(anyWriter);
		logger.removeWriter(anyWriter);
		assertFalse(logger.getWriters().contains(anyWriter));
	}

	// LogWriters invocations by: logger.trace, logger.debug, logger.info, logger.warn, logger.error, logger.fatal

	@Test
	public void TraceCallsTraceWriter() {
		logger.addWriter(traceLogWriterMock);
		String message = "trace message";
		logger.trace(message);
		verify(traceLogWriterMock).log(message);
	}

	@Test
	public void DebugCallsDebugWriter() {
		logger.addWriter(debugLogWriterMock);
		String message = "debug message";
		logger.debug(message);
		verify(debugLogWriterMock).log(message);
	}

	@Test
	public void InfoCallsInfoWriter() {
		logger.addWriter(infoLogWriterMock);
		String message = "info message";
		logger.info(message);
		verify(infoLogWriterMock).log(message);
	}

	@Test
	public void WarnCallsWarnWriter() {
		logger.addWriter(warnLogWriterMock);
		String message = "warn message";
		logger.warn(message);
		verify(warnLogWriterMock).log(message);
	}

	@Test
	public void ErrorCallsErrorWriter() {
		logger.addWriter(errorLogWriterMock);
		String message = "error message";
		logger.error(message);
		verify(errorLogWriterMock).log(message);
	}

	@Test
	public void FatalCallsFatalWriter() {
		logger.addWriter(fatalLogWriterMock);
		String message = "fatal message";
		logger.fatal(message);
		verify(fatalLogWriterMock).log(message);
	}

	@Test
	public void EachLogLevelCallInMixProduceCorrespondentLogWriterCall() {
		logger.addWriter(traceLogWriterMock);
		logger.addWriter(debugLogWriterMock);
		logger.addWriter(infoLogWriterMock);
		logger.addWriter(warnLogWriterMock);
		logger.addWriter(errorLogWriterMock);
		logger.addWriter(fatalLogWriterMock);

		logger.trace("trace message");
		logger.debug("debug message");
		logger.info("info message");
		logger.warn("warn message");
		logger.error("error message");
		logger.fatal("fatal message");

		verify(traceLogWriterMock).log("trace message");
		verify(debugLogWriterMock).log("debug message");
		verify(infoLogWriterMock).log("info message");
		verify(warnLogWriterMock).log("warn message");
		verify(errorLogWriterMock).log("error message");
		verify(fatalLogWriterMock).log("fatal message");
	}
}