// client
public static void main() {

    Logger logger = new Logger();

    // test scenarios
    logger.log(LogType.error, "Null ref error occurred!"); // Error: Null ref error occurred!
    logger.log(LogType.info, "Info to user to use this button"); // Info: Info to user to use this button
}

// Chain Of Responsibility system

Enum LogType {
    error,
    info,
    warning,
    verbose
};

// can be made single
public class Logger {
    private LogProcessor logProcessor;
    Logger() {
        buildChain();
    }
    private buildChain() {
        logProcessor = new InfoLogger(
            new ErrorLogger(
            new WarningLogger(
            new VerboseLogger(null))));
    }

    public log(LogType logType, string msg) {
        logProcessor.log(logType, msg);
    }
}

abstract class LogProcessor {
    private LogProcessor nextLogger;
    
    public LogProcessor(LogProcessor nextLogger) {
        this.nextLogger = nextLogger;
    }

    public log(LogType logType, string msg) {
        if (nextLogger != null) {
            nextLogger.log(logType, msg);
        } else {
            throw new Error("Logtype is unavailable");
        }
    }
}

public class InfoLogger extends LogProcessor {
    public InfoLogger(LogProcessor nextLogger) {
        super(nextLogger);
    }

    public log(LogType logType, string msg) {
        if (logType == LogType.info) {
            print("Info: "+msg);
        } else {
            super(logType, msg);
        }
    }
}

public class WarningLogger extends LogProcessor {
    public WarningLogger(LogProcessor nextLogger) {
        super(nextLogger);
    }

    public log(LogType logType, string msg) {
        if (logType == LogType.warning) {
            print("Warning: "+msg);
        } else {
            super(logType, msg);
        }
    }
}

public class ErrorLogger extends LogProcessor {
    public ErrorLogger(LogProcessor nextLogger) {
        super(nextLogger);
    }

    public log(LogType logType, string msg) {
        if (logType == LogType.error) {
            print("Error: "+msg);
        } else {
            super(logType, msg);
        }
    }
}

public class VerboseLogger extends LogProcessor {
    public ErrorLogger(LogProcessor nextLogger) {
        super(nextLogger);
    }

    public log(LogType logType, string msg) {
        if (logType == LogType.verbose) {
            print("Verbose: "+msg);
        } else {
            super(logType, msg);
        }
    }
}