package tamagochi;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Events generator
 */

public class StateGenerator implements Runnable {

    private final TamagochiMind mind;
    private Thread thread;
    Logger log = Logger.getLogger(StateGenerator.class.getName());

    public StateGenerator(TamagochiMind mind) {
        setUpLogger();
        this.mind = mind;
    }

    public void startThread() {
        this.thread = new Thread(this);
        thread.start();
        log.config("StateGenerator has started " + Thread.currentThread().getName());
    }

    private void setUpLogger() {
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINEST);
        log.setLevel(Level.FINEST);
        log.addHandler(handler);
    }

    public void run() {
        log.fine("StateGenerator Thread has started " + Thread.currentThread().getName());
        do {
            try {
                mind.changeState();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!mind.isTimeToDie());
        log.finest("State Generator Thread speaking: " + thread.getState());
    }
}