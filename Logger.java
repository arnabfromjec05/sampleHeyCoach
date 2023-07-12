
Singleton design patter -->


// Non Thread safe

public class Logger {
    
    private static Logger logger = null;

    private Logger() {
        // print (new logger created)
    };

    public static synchronized getLogger() {
        if (logger == null) {
            synchronized {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

}

main() {

    Logger logger = Logger.getLogger();

    /**
     * Logger logger = new Logger() -> compile time error
     * Logger logger = Logger.getLogger();  -> logger member variable is set to new Logger(); -> step1
     * Logger logger2 = Logger.getLogger(); -> same logger object as step1
     * Logger logger3 = Logger.getLogger(); -> same logger object as step1
     */
}

1. Non-Thread safe implemtation
2. Thread safe via synchronized
3. Double check thread safe via synchronized