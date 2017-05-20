package run;

import tamagonchi.TamagonchiState;
import tamagonchi.StateGenerator;
import tamagonchi.StateName;
import tamagonchi.TamagonchiProcess;
//https://videoportal.epam.com/video/QoVbL9o9
//https://www.tutorialspoint.com/java/java_thread_communication.htm
public class Main {

    public synchronized static void main(String[] args) throws InterruptedException {

        System.out.println("Hello World!");

                TamagonchiState playState = new TamagonchiState(StateName.PLAY, 100, 8);
        TamagonchiProcess tamagonchi = new TamagonchiProcess(playState);
        Thread generator = new Thread(new StateGenerator(tamagonchi));
        generator.start();
        Thread threadTamagochi = new Thread(tamagonchi);
        threadTamagochi.start();
//        TamagonchiState deadState = new TamagonchiState(StateName.DIE, 200, 8);
//        TamagonchiProcess alive = new TamagonchiProcess(aliveState);
//        alive.run();
//        alive.changeState(deadState);
    }
}
