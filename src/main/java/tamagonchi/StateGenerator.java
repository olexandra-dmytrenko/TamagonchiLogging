package tamagonchi;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 */
public class StateGenerator implements Runnable {
    TamagonchiProcess tamagonchi;
    State aliveState = new State(StateName.ALIVE, 200, 8);
    State deadState = new State(StateName.DIE, 200, 8);

    public StateGenerator(TamagonchiProcess tamagonchi) {
        this.tamagonchi = tamagonchi;
    }

    public synchronized void run() {
        try {
            this.wait(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tamagonchi.changeState(aliveState);
        tamagonchi.notifyAll();
        try {
            this.wait(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        tamagonchi.changeState(deadState);
//        tamagonchi.notifyAll();
    }
}
