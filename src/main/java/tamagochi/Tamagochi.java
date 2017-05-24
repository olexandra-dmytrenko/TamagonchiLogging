package tamagochi;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Observer
 */
@Slf4j
public class Tamagochi implements Runnable {
    private final TamagochiMind mind;
    private AtomicInteger counter = new AtomicInteger(10);
    private Thread thread;
    //The root logger resides at the top of the logger hierarchy.
    // It always exists, cannot be retrieved by name.

    public Tamagochi(TamagochiMind mind) {
        this.mind = mind;
        log.error("Slf4j hi {} ", "Sasha");
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
