package ua.goit.homework511;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogWriter {
    final Logger logger = LoggerFactory.getLogger(LogWriter.class);

    public LogWriter(String msgLog) {
        logger.debug(msgLog);
    }
}
