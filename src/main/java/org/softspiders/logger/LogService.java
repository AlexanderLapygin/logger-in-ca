package org.softspiders.logger;

import java.util.List;

public interface LogService {
	List<LogWriter> getWriters();

	void addWriter(LogWriter writer);

	void removeWriter(LogWriter writer);

	void trace(String message);

	void debug(String message);

	void info(String message);

	void warn(String message);

	void error(String message);

	void fatal(String message);
}
