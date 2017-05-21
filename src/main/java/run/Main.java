package run;

import tamagonchi.StateGenerator;
import tamagonchi.Tamagochi;
import tamagonchi.TamagochiMind;

//https://videoportal.epam.com/video/QoVbL9o9
//https://www.tutorialspoint.com/java/java_thread_communication.htm
public class Main {

    public synchronized static void main(String[] args) throws InterruptedException {

        System.out.println("Hello My Maser! I'm your Tamagonchi. ❥✿✿✿❤︎");

        TamagochiMind mind = new TamagochiMind();

        new StateGenerator(mind);
        new Tamagochi(mind);
    }
}
