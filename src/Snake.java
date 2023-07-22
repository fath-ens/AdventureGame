import java.util.Random;

public class Snake extends Monster{

    public Snake() {
        super(4, "Snake", randDamage(), 12, 0);
    }

    private static int randDamage() {
        Random random = new Random();
        return random.nextInt(4)+3;
    }


}
