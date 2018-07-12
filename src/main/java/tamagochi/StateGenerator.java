package tamagochi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017. Events generator
 */

public class StateGenerator implements Runnable {

    private final TamagochiMind mind;
    private Thread thread;
    private static Logger log = null;
    //Logger.getLogger(StateGenerator.class.getName());

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        log = Logger.getLogger(StateGenerator.class.getName());
    }

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
//        Handler handler = null;
//        try {
//            handler = new FileHandler("jul.log");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        final SimpleFormatter logFormatter = new SimpleFormatter();
//        handler.setFormatter(logFormatter);
//
//        handler.setLevel(Level.FINEST);
//        log.addHandler(handler);
        log.setLevel(Level.FINE);
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
        log.fine("State Generator Thread speaking: " + thread.getState());
    }
}
