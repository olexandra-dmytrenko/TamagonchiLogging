package tamagonchi;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 */
public class TamagonchiState {

    private StateName name;
    private long sleepTime = 400;

    TamagonchiState(StateName name) {
        this.name = name;
    }

    TamagonchiState(StateName name, long sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    StateName getName() {
        return name;
    }

    long getSleepTime() {
        return sleepTime;
    }
}
