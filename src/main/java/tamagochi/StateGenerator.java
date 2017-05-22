package tamagochi;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Events generator
 */
public class StateGenerator implements Runnable {

    private final TamagochiMind mind;
    private Thread thread;

    public StateGenerator(TamagochiMind mind) {
        this.mind = mind;
    }

    public void startThread() {
        this.thread = new Thread(this);
        thread.start();
    }

    public void run() {
        do {
            try {
                synchronized (mind) {
                    waitTillNotified();
                    mind.changeState();
                    mind.setChanged(true);
                    mind.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!mind.isTimeToDie());
        System.out.println("State Generator Thread speaking: " + thread.getState());

    }

    private void waitTillNotified() throws InterruptedException {
        while (mind.isChanged()) {
            mind.wait();
        }
    }
}
