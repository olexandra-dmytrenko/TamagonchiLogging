package tamagochi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Events generator
 */

public class StateGenerator implements Runnable {

    private final TamagochiMind mind;
    private Thread thread;
    private static Logger log = LogManager.getLogger(StateGenerator.class);

    public StateGenerator(TamagochiMind mind) {
        this.mind = mind;
    }

    public void startThread() {
        this.thread = new Thread(this);
        thread.start();
        log.info("StateGenerator has started " + Thread.currentThread().getName());
    }

    public void run() {
        log.fatal("StateGenerator Thread has started " + Thread.currentThread().getName());
        do {
            try {
                mind.changeState();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!mind.isTimeToDie());
        log.error("State Generator Thread speaking: " + thread.getState());
    }
}