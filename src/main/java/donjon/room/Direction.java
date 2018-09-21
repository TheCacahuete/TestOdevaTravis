package donjon.room;

import java.util.Random;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 24/09/16.
 * Time : 14:02
 * TP de COO
 */

public enum Direction{UP,DOWN,LEFT,RIGHT,UPRIGHT,UPLEFT,DOWNRIGHT,DOWNLEFT;



    private static final Direction[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Direction getRandomDirection()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}