package org.softspiders.logger;

/**
 * The default level is INFO
 */
public interface LogWriter {
	void log(String message);

	Enum getLevel();
}
