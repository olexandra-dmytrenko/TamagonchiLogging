package run;

import tamagochi.StateGenerator;
import tamagochi.Tamagochi;
import tamagochi.TamagochiMind;

//https://videoportal.epam.com/video/QoVbL9o9
//https://www.tutorialspoint.com/java/java_thread_communication.htm
public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello My Maser! I'm your Tamagochi. ❥✿✿✿❤");

        TamagochiMind mind = new TamagochiMind();

        new StateGenerator(mind).startThread();
        new Tamagochi(mind).startThread();
    }
}
