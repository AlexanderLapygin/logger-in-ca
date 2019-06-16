package org.softspiders.logger;

import java.util.ArrayList;
import java.util.List;

public class Logger implements LogService {
	private List<LogWriter> writers = new ArrayList<>();

	public Logger() {
	}

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

	}
}

