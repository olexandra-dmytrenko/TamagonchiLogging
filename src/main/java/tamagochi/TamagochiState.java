package tamagochi;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 */
public class TamagochiState {

    private StateName name;
    private long sleepTime = 400;

    TamagochiState(StateName name) {
        this.name = name;
    }

    TamagochiState(StateName name, long sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    StateName getName() {
        return name;
    }

    long getSleepTime() {
        return sleepTime;
    }

    @Override
    public String toString() {
        return name + " " + name.sign;
    }
}
