package tamagochi;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Observer
 */
public class Tamagochi implements Runnable {

    private final TamagochiMind mind;
    private AtomicInteger counter = new AtomicInteger(10);
    private Thread thread;

    public Tamagochi(TamagochiMind mind) {
        this.mind = mind;
    }

    public void startThread() {
        this.thread = new Thread(this);
        thread.start();
    }

    public void run() {
        System.out.println("Run started with state " + mind.getState().getName());
        try {
            do {
                synchronized (mind) {
                    while (!mind.isChanged()) {
                        mind.wait();
                    }
                    counter.decrementAndGet();
                    mind.output();
                    System.out.println(counter);
                    mind.setChanged(false);
                    mind.notifyAll();
                }
            } while (counter.get() != 0);

            TamagochiState deadState = new TamagochiState(StateName.DEAD);
            mind.output(deadState);
            mind.setTimeToDie(true);

            System.out.println("Tamagochi Thread speaking: " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
