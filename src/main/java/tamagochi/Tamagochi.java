package tamagochi;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Observer
 */
public class Tamagochi implements Runnable {

    private static Logger log = LogManager.getLogger(Tamagochi.class);
    private final TamagochiMind mind;
    private AtomicInteger counter = new AtomicInteger(10);
    private Thread thread;
    //The root logger resides at the top of the logger hierarchy.
    // It always exists, cannot be retrieved by name.

    public Tamagochi(TamagochiMind mind) {
        this.mind = mind;
        log.info("Slf4j hi {} ", "Sasha");
    }
//    private void setUpLogger(){
//        Handler handler = null;
//        try {
//            handler = new FileHandler("jul.log", false);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        handler.setFormatter(new SimpleFormatter());
//        handler.setLevel(java.util.logging.Level.CONFIG);
//        handler.publish(new LogRecord(java.util.logging.Level.WARNING, "Here I config log to test"));
//        log.setLevel(java.util.logging.Level.FINEST);
//        log.addHandler(handler);
//    }

    public void startThread() {
        this.thread = new Thread(this);
        thread.start();
    }

    public void run() {
        log.info("Tamagochi Thread has started !!!!!!" + Thread.currentThread().getName());
        System.out.println("Run started with state " + mind.getState().getName());
        try {
            do {
                counter.decrementAndGet();
                mind.output();
                System.out.println(counter);

            } while (counter.get() != 0);

            TamagochiState deadState = new TamagochiState(StateName.DEAD);
            mind.output(deadState);

//            log.fine("Tamagochi Thread speaking: " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}