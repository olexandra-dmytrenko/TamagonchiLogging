package tamagonchi;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 */
public class TamagonchiProcess implements Runnable, Subscribed {

    private State myState;
    AtomicInteger counter = new AtomicInteger(10);

    public TamagonchiProcess(State newState) {
        System.out.println("Tamagonchi created with state " + newState.getName());
        this.myState = newState;
        counter.set(newState.getCounter());
    }

    public synchronized void run() {
        System.out.println("Run started with state " + myState.getName());
        do {
            counter.decrementAndGet();
            System.out.println("I'm " + myState.getName());
            try {
                this.wait(myState.getSleepTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter);
        } while (counter.get() != 0 && myState.getName() != StateName.DIE);
    }

    public synchronized void changeState(State newState) {
        myState = newState;
        counter.set(newState.getCounter());
        System.out.println("Changed state to " + newState.getName());
//        this.notifyAll();
    }
}
