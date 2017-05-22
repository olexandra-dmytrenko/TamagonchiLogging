package tamagochi;

import lombok.extern.java.Log;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Events generator
 */
@Log
public class StateGenerator implements Runnable {

    private final TamagochiMind mind;
    private Thread thread;

    public StateGenerator(TamagochiMind mind) {
        this.mind = mind;
    }

    public void startThread() {
        this.thread = new Thread(this);
        thread.start();
        log.info("StateGenerator has started " + Thread.currentThread().getName());
    }

    public void run() {
        log.info("StateGenerator Thread has started " + Thread.currentThread().getName());
        do {
            try {
                mind.changeState();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!mind.isTimeToDie());
        System.out.println("State Generator Thread speaking: " + thread.getState());
    }

}
