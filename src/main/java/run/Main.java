package run;

import tamagonchi.State;
import tamagonchi.StateGenerator;
import tamagonchi.StateName;
import tamagonchi.TamagonchiProcess;

public class Main {

    public synchronized static void main(String[] args) throws InterruptedException {

        System.out.println("Hello World!");

                State playState = new State(StateName.PLAY, 100, 8);
        TamagonchiProcess tamagonchi = new TamagonchiProcess(playState);
        tamagonchi.run();
        StateGenerator generator = new StateGenerator(tamagonchi);
        generator.run();
//        State deadState = new State(StateName.DIE, 200, 8);
//        TamagonchiProcess alive = new TamagonchiProcess(aliveState);
//        alive.run();
//        alive.changeState(deadState);
    }
}
