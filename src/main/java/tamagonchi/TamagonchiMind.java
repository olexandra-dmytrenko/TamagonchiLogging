package tamagonchi;

import java.util.Random;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 */
public class TamagonchiMind {

    public void changeState(TamagonchiState newState){

    }

    public TamagonchiState generateNewState(){
        int stateAmount = StateName.values().length;
        int newStateNameNumb = (int) (Math.random() * stateAmount - 2);
        StateName newStateName = StateName.values()[newStateNameNumb];
        return new TamagonchiState(newStateName, 200, 8);
//        TamagonchiState aliveState = new TamagonchiState(StateName.ALIVE, 200, 8);
//        TamagonchiState deadState = new TamagonchiState(StateName.DIE, 200, 8);

    }
}
