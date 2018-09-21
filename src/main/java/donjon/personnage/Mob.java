package donjon.personnage;


import donjon.room.Room;

import java.util.Random;

public class Mob {
    protected int pdv;
    protected int strength;
    protected int gold;
    protected Room room;

    /**
     * Constructor with random values
     */
    public Mob(){
        Random ran = new Random();
        int pdv = ran.nextInt(8)+1;
        this.pdv = pdv;
        int strength = ran.nextInt(3)+1;
        this.strength = strength;
        int gold = ran.nextInt(4);
        this.gold = gold;
        this.room = new Room();
    }

    /**
     * Constructor with pdv and strength
     *
     * @param pdv the current pdv of the mob
     * @param strength the current strength of the mob
     */
    public Mob(int pdv, int strength) {
        this.strength = strength;
        this.pdv = pdv;
        this.gold = 0;
        this.room = new Room();
    }

    /**
     * Constructor with pdv and strength
     *
     * @param pdv the current pdv of the mob
     * @param strength the current strength of the mob
     * @param gold the current gold of the mob
     */
    public Mob(int pdv, int strength, int gold) {
        this.strength = strength;
        this.pdv = pdv;
        this.gold = gold;
        this.room = new Room();
    }

    /**
     * Number pdv of the mob
     *
     * @return int point de vie
     */
    public int getPdv() {
        return pdv;
    }

    /**
     * set mob's pdv
     *
     * @param pdv int new pdv of the mob
     */
    public void setPdv(int pdv) {
        this.pdv = pdv;
    }

    /**
     * Get mob's strength
     *
     * @return the strength of the mob
     */
    public int getStrength() {
        return strength;
    }

    /**
     * set mob's strength
     *
     * @param strength int the strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * get the money of mob
     *
     * @return int how much money get the mob
     */
    public int getGold() {
        return gold;
    }

    /**
     * set mob's money
     *
     * @param gold int money to set
     */
    public void setGold(int gold) {
        this.gold = this.gold + gold;
    }


    /**
     * this function allow to know if a monster is dead
     *
     * @return true if the monster is dead
     */
    public boolean isDead(){

        return getPdv() <= 0;
    }


    /**
     * function equals to compare two mob
     *
     * @param o an object to compare
     * @return a boolean (true if they are equals, or false if not)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mob mob = (Mob) o;

        return (this.pdv == mob.pdv && this.strength == mob.strength && this.gold == mob.gold ) && this.room.equals(mob.room);

    }

    @Override
    public int hashCode() {
        int result = getPdv();
        result = 31 * result + getStrength();
        result = 31 * result + getGold();
        result = 31 * result + (getRoom() != null ? getRoom().hashCode() : 0);
        return result;
    }

    /**
     * return the current donjon.donjon.room
     *
     * @return the donjon.donjon.room
     */
    public Room getRoom() {
        return this.room;
    }


    public String toString() {
        return "Mob : " +
                " pdv = " + pdv +
                ", strength = " + strength +
                ", gold = " + gold +".";
    }

    /**
     * set a new donjon.donjon.room
     *
     * @param room the new donjon.donjon.room
     */
    public void setRoom(Room room) {
        this.room = room;
    }
}