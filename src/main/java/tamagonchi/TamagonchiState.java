package tamagonchi;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 */
public class TamagonchiState {
    private StateName name;
    private long sleepTime;
    private int counter;

    public TamagonchiState(StateName name, long sleepTime, int counter) {
        this.name = name;
        this.sleepTime = sleepTime;
        this.counter = counter;
    }

    public StateName getName() {
        return name;
    }

    public void setName(StateName name) {
        this.name = name;
    }

    public long getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
