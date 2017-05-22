package tamagochi;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Observable
 */
public class TamagochiMind {

    private volatile TamagochiState state;
    private volatile boolean isTimeToDie = false;
    private boolean changed = false;

    public TamagochiMind() throws InterruptedException {
        this.state = new TamagochiState(StateName.ALIVE, 300);
        output(state);
    }

    void changeState() throws InterruptedException {
        int timeout = 300;
        Thread.sleep(timeout);
        TamagochiState newTamagochiState = generateNewState();
        state = newTamagochiState;
    }

    private TamagochiState generateNewState() {
        int stateAmount = StateName.values().length;
        int newStateNameNumb = (int) ((Math.random() * (stateAmount - 2) + 1));
        StateName newStateName = StateName.values()[newStateNameNumb];
        return new TamagochiState(newStateName, 200);
    }

    TamagochiState getState() {
        return state;
    }

    void output() throws InterruptedException {
        Thread.sleep(state.getSleepTime());
        System.out.println("I " + state.getName());
    }

    void output(TamagochiState state) throws InterruptedException {
        System.out.println("I'm " + state.getName());
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
