package logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogExample {
    static Logger logger = Logger.getLogger(LogExample.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "This is InFo log");
    }
}
