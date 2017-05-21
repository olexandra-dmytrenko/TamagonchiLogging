package tamagonchi;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Observable
 */
public class TamagochiMind {

    private TamagonchiState state;
    private boolean isTimeToDie = false;

    public TamagochiMind() throws InterruptedException {
        this.state = new TamagonchiState(StateName.ALIVE, 300);
        output(state);
    }

    synchronized TamagonchiState changeState() throws InterruptedException {
        int timeout = 300;
        wait(timeout);
        TamagonchiState newTamagonchiState = generateNewState();
        state = newTamagonchiState;
        return newTamagonchiState;
    }

    private TamagonchiState generateNewState() {
        int stateAmount = StateName.values().length;
        int newStateNameNumb = (int) ((Math.random() * (stateAmount - 2) + 1));
        StateName newStateName = StateName.values()[newStateNameNumb];
        return new TamagonchiState(newStateName);
    }

    TamagonchiState getState() {
        return state;
    }

    synchronized void output() throws InterruptedException {
        wait(state.getSleepTime());
        System.out.println("I " + state.getName());
    }

    void output(TamagonchiState state) throws InterruptedException {
        System.out.println("I'm " + state.getName());
    }

    boolean isTimeToDie() {
        return isTimeToDie;
    }

    void setTimeToDie(boolean timeToDie) {
        isTimeToDie = timeToDie;
    }
}
