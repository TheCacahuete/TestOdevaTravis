package donjon.personnage;


import donjon.item.Gold;

import donjon.room.Room;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 21/09/16.
 * Time : 17:17
 * TP de COO
 */
public class Monster extends Mob {
    /**
     * Constructor with random values
     */
    public Monster(){
        super();
    }

    /**
     * Constructor with pdv, strength, donjon.donjon.room;
     *
     * @param pdv
     * @param strength
     * @param room
     */
    public Monster(int pdv, int strength, Room room){
        super(pdv, strength);
        this.room = room;
        this.gold = 0;
    }

    /**
     * Constructor with all parameters
     *
     * @param pdv the current pdv of the monster
     * @param strength the current strength of the monster
     * @param room the current donjon.donjon.room of the monster
     * @param gold the current gold of the monster
     */
    public Monster(int pdv, int strength,Room room, int gold){
        super(pdv, strength, gold);
        this.room = room;
    }

    /**
     * get the donjon.donjon.room of the monster
     *
     * @return the donjon.donjon.room
     */
    public Room getRoom(){
        return room;
    }

    /**
     * drop the gold of the monster
     *
     * @param room the donjon.donjon.room where he drop gold
     */
    public void dropGold(Room room){
        room.addItem(new Gold(this.gold));
        this.gold = 0;
    }

    /**
     * do the monster ripost
     *
     * @param mob the target to attack
     */
    public void ripost(Mob mob){
        mob.setPdv(mob.pdv-this.strength);
    }
}
