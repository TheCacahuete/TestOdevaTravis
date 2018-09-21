package donjon.personnage;

import donjon.room.Room;

import java.util.*;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 23/09/16.
 * Time : 09:55
 * TP de COO
 */
public class Player extends Mob{


    /**
     * Constructor with random
     */
    public Player (){
        Random ran = new Random();
        int pdv = ran.nextInt(20)+1;
        this.pdv = pdv;
        int strength = ran.nextInt(4)+3;
        this.strength = strength;
        int gold = ran.nextInt(10);
        this.gold = gold;
        this.room = new Room();
    }

    /**
     * Constructor with pdv and strength
     *
     * @param pdv the current player pdv
     * @param strength the currend player strength
     */
    public Player(int pdv, int strength) {
        super(pdv, strength);
    }

    /**
     * Constructor with pdv and strength and gold
     *
     * @param pdv the current player pdv
     * @param strength the current player strength
     * @param gold the current gold of the player
     */
    public Player(int pdv, int strength, int gold) {
        super(pdv, strength, gold);
    }

}
