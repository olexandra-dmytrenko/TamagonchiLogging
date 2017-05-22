package tamagochi;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 */
public enum StateName {
    ALIVE("☿"), PLAY("🏈︎"), SLEEP("😔"), EAT("🍌"), WORK("🚕"), FIGHT("🤼‍"), LOVE("💕❤️💓"), DEAD("☨");

    String sign;

    StateName(String sign) {
        this.sign = sign;
    }
}
