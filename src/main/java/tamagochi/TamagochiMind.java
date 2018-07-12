package tamagochi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Observable
 */
//@Slf4j
public class TamagochiMind {
    private static Logger log = LoggerFactory.getLogger(TamagochiMind.class);
//    Logger logger = Logger.getLogger("name");

    private TamagochiState state;
    private volatile boolean isTimeToDie = false;
    private boolean changed = false;
    public static final int CHANGE_STATE_TIMEOUT = 100;

    public TamagochiMind() throws InterruptedException {
        this.state = new TamagochiState(StateName.ALIVE, 300);
        output(state);
    }

    synchronized void changeState() throws InterruptedException {
        //Thread.sleep(CHANGE_STATE_TIMEOUT);
        while (isChanged()) {
            wait();
        }
        state = generateNewState();
        log.warn("Tamagochi mind changes state to {}", state);
        setChanged(true);
        notifyAll();
    }

    private TamagochiState generateNewState() {
        int stateAmount = StateName.values().length;
        int newStateNameNumb = (int) ((Math.random() * (stateAmount - 2) + 1));
        StateName newStateName = StateName.values()[newStateNameNumb];
        return new TamagochiState(newStateName, 100);
    }

    TamagochiState getState() {
        return state;
    }

    synchronized void output() throws InterruptedException {
   //     Thread.sleep(state.getSleepTime());
        while (!isChanged()) {
            wait();
        }
        System.out.println("I " + state.getName() + " " + state.getName().sign);
        setChanged(false);
        notifyAll();
    }

   synchronized void output(TamagochiState state) throws InterruptedException {
        System.out.println("I'm " + state.getName() + " " + state.getName().sign);
        if (state.getName() == StateName.DEAD) {
            setTimeToDie(true);
        }
       setChanged(false);
       notifyAll();
    }

    boolean isTimeToDie() {
        return isTimeToDie;
    }

    void setTimeToDie(boolean timeToDie) {
        isTimeToDie = timeToDie;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}
