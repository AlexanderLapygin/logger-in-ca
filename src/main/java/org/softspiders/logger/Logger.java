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
		for(LogWriter logWriter: writers) {
			logWriter.log(message);
		}
	}

	@Override
	public void debug(String message) {
		for(LogWriter logWriter: writers) {
			logWriter.log(message);
		}
	}

	@Override
	public void info(String message) {
		for(LogWriter logWriter: writers) {
			logWriter.log(message);
		}
	}

	@Override
	public void warn(String message) {
		for(LogWriter logWriter: writers) {
			logWriter.log(message);
		}
	}

	@Override
	public void error(String message) {
		for(LogWriter logWriter: writers) {
			logWriter.log(message);
		}
	}

	@Override
	public void fatal(String message) {
		for(LogWriter logWriter: writers) {
			logWriter.log(message);
		}
	}
}

