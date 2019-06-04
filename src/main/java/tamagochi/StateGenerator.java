package tamagochi;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Events generator
 */
//@Log
public class StateGenerator implements Runnable {
    private final TamagochiMind mind;
    private Thread thread;
    private static Logger log = Logger.getLogger(StateGenerator.class.getName());

    public StateGenerator(TamagochiMind mind) {
        setUpConsoleLogger();
        this.mind = mind;
    }

    private void setUpConsoleLogger() {
        Handler logHandler = new ConsoleHandler();
        logHandler.setLevel(Level.FINE);
        log.setLevel(Level.FINEST);
        log.addHandler(logHandler);
//        logHandler.setLevel(Level.OFF);
    }

    public void startThread() {
        this.thread = new Thread(this);
        thread.start();
        log.finest("StateGenerator has started from thread " + Thread.currentThread().getName());
    }

    public void run() {
        log.warning("StateGenerator Thread has started in thread" + Thread.currentThread().getName());
        do {
            try {
                mind.changeState();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!mind.isTimeToDie());
        log.fine("State Generator Thread speaking: " + thread.getState());
    }
}