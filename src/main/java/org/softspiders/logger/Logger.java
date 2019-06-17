package org.softspiders.logger;

import java.util.ArrayList;
import java.util.List;

public class Logger implements LogService {
	private List<LogWriter> writers = new ArrayList<>();

	@Override
	public List<LogWriter> getWriters() {
		return writers;
	}

	@Override
	public void addWriter(LogWriter writer) {
		writers.add(writer);
	}

	@Override
	public void removeWriter(LogWriter writer) {
		writers.remove(writer);
	}

	@Override
	public void trace(String message) {
		callWritersByLevel(message, LogLevels.TRACE);
	}

	@Override
	public void debug(String message) {
		callWritersByLevel(message, LogLevels.DEBUG);
	}

	@Override
	public void info(String message) {
		callWritersByLevel(message, LogLevels.INFO);
	}

	@Override
	public void warn(String message) {
		callWritersByLevel(message, LogLevels.WARN);
	}

	@Override
	public void error(String message) {
		callWritersByLevel(message, LogLevels.ERROR);
	}

	@Override
	public void fatal(String message) {
		callWritersByLevel(message, LogLevels.FATAL);
	}

	private void callWritersByLevel(String message, LogLevels logLevel) {
		for(LogWriter logWriter: writers) {
			if(logLevel.equals(logWriter.getLevel())) {
				logWriter.log(message);
			}
		}
	}
}

