package org.softspiders.logger;

import java.util.List;

public interface LogService {
	List<LogWriter> getWriters();

	void addWriter(LogWriter writer);

	void removeWriter(LogWriter writer);
}
