package org.example.task4;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;


public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        LocalDateTime dateTime = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        sb.append(dateTime.getDayOfMonth()).append(", ");
        sb.append(dateTime.getMonth()).append(", ");
        sb.append(dateTime.getYear()).append(", ");
//        sb.append(record.getLongThreadID()).append(", ");
        sb.append(record.getLevel()).append(", ");
        sb.append(record.getLoggerName()).append(", ");
        sb.append(record.getMessage()).append("\n");

        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            record.getThrown().printStackTrace(pw);
            sb.append(sw);
        }

        return sb.toString();
    }
}

