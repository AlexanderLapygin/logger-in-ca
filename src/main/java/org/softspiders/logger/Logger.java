package org.softspiders.logger;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Logger implements LogService {
	List<Writer> writers = new ArrayList<Writer>();

	public Logger() {
	}

	@Override
	public List<Writer> getWriters() {
		return writers;
	}
}

