package tamagochi;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Observer
 */
//@Log
public class Tamagochi implements Runnable {
    Logger logger;
    private final TamagochiMind mind;
    private AtomicInteger counter = new AtomicInteger(5);
    private Thread thread;

    public Tamagochi(TamagochiMind mind) {
        this.mind = mind;
    }

    public void startThread() throws IOException {
        setUpFileLogger();
        this.thread = new Thread(this);
        thread.start();
    }

    private void setUpFileLogger() throws IOException {

            logger = Logger.getAnonymousLogger();
            FileHandler handler = new FileHandler("log/julLog.log");
            handler.setFormatter(new SimpleFormatter());
            handler.publish(new LogRecord(Level.CONFIG, "Configuring logger"));
            logger.addHandler(handler);
            logger.setLevel(Level.ALL);
            handler.setLevel(Level.FINE);
    }

    public void run() {
        logger.finest("Tamagochi Thread has started " + Thread.currentThread().getName());
        System.out.println("Run started with state " + mind.getState().getName());
        try {
            do {
                counter.decrementAndGet();
                mind.output();
                System.out.println(counter);
            } while (counter.get() != 0);

            TamagochiState deadState = new TamagochiState(StateName.DEAD);
            mind.output(deadState);

            logger.fine("Tamagochi Thread speaking: " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
