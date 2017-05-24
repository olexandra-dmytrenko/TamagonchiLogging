package tamagochi;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Observer
 */
//@Log4j
public class Tamagochi implements Runnable {
    private final TamagochiMind mind;
    private AtomicInteger counter = new AtomicInteger(10);
    private Thread thread;
    //The root logger resides at the top of the logger hierarchy.
    // It always exists, cannot be retrieved by name.
    private static Logger loggerRoot = Logger.getRootLogger();
    private static Logger logger = Logger.getLogger(Tamagochi.class.getName());
    private static Logger loggerPack = Logger.getLogger("observerpattern");

    public Tamagochi(TamagochiMind mind) {
        loggerRoot.setLevel(Level.ERROR);
        loggerPack.setLevel(Level.DEBUG);
        logger.setLevel(Level.INFO);
        logger.warn("Hello warning");
        logger.info("Hello info");
        loggerPack.debug("Hello debug");
        this.mind = mind;
    }

    public void startThread() {
        this.thread = new Thread(this);
        thread.start();
    }

    public void run() {

//        log.info("Tamagochi Thread has started !!!!!!" + Thread.currentThread().getName());
        System.out.println("Run started with state " + mind.getState().getName());
        try {
            do {
                counter.decrementAndGet();
                mind.output();
                System.out.println(counter);

            } while (counter.get() != 0);

               TamagochiState deadState = new TamagochiState(StateName.DEAD);
               mind.output(deadState);

            System.out.println("Tamagochi Thread speaking: " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
