package tamagochi;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 * Observable
 */
public class TamagochiMind {

    private TamagochiState state;
    private boolean isTimeToDie = false;

    public TamagochiMind() throws InterruptedException {
        this.state = new TamagochiState(StateName.ALIVE, 300);
        output(state);
    }

    synchronized TamagochiState changeState() throws InterruptedException {
        int timeout = 300;
        wait(timeout);
        TamagochiState newTamagochiState = generateNewState();
        state = newTamagochiState;
        return newTamagochiState;
    }

    private TamagochiState generateNewState() {
        int stateAmount = StateName.values().length;
        int newStateNameNumb = (int) ((Math.random() * (stateAmount - 2) + 1));
        StateName newStateName = StateName.values()[newStateNameNumb];
        return new TamagochiState(newStateName);
    }

    synchronized TamagochiState getState() {
        return state;
    }

    synchronized void output() throws InterruptedException {
        wait(state.getSleepTime());
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
}
