package tamagochi;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Events generator
 */
public class StateGenerator implements Runnable {

    private TamagochiMind mind;
    private Thread thread;

    public StateGenerator(TamagochiMind mind) {
        this.mind = mind;
    }

    public void startThread() {
        this. thread = new Thread(this);
        thread.start();
    }

    public void run() {
        TamagochiState state = null;
        do {
            try {
                state = mind.changeState();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!mind.isTimeToDie() && state.getName() != StateName.DEAD);
        System.out.println("State Generator Thread speaking: " + thread.getState());
        thread.interrupt();
    }
}
