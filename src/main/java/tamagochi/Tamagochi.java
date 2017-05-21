package tamagochi;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Observer
 */
public class Tamagochi implements Runnable {

    private TamagochiMind mind;
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
                counter.decrementAndGet();
                mind.output();
                System.out.println(counter);
            } while (counter.get() != 0 && mind.getState().getName() != StateName.DEAD);

            TamagochiState deadState = new TamagochiState(StateName.DEAD);
            mind.output(deadState);
            mind.setTimeToDie(true);
            thread.interrupt();
            System.out.println("Tamagochi Thread speaking: " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
