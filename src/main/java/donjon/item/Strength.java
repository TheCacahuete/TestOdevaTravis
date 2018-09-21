package donjon.item;

import donjon.personnage.Player;

import java.util.Random;

public class Strength extends Potion{


    /**
     * Constructor with random value
     */
    public Strength() {
        Random ran = new Random();
        int val = ran.nextInt(6)+1;
        this.value = val;
    }

    /**
     * Constructor with value
     *
     * @param value the strength give by the potion
     */
    public Strength(int value) {
        this.value = value;
    }

    /**
     * toString
     *
     * @return the description of the strength potion
     */
    public String toString() {
        return "This potion add " + this.value + " strength point.\n";
    }


    /**
     * the donjon.donjon.action for the strength potion, she add strength to the player
     *
     * @param player the current player
     */
    public void action(Player player) {
        player.setStrength(this.value + player.getStrength());
    }

    /**
     * function equals to compare two strength potions
     *
     * @param o an object to compare
     * @return a boolean (true if they are equals, or false if not)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Strength strength = (Strength) o;

        return value == strength.value;

    }


    /**
     * hashcode function
     *
     * @return int the result of hashcode function
     */
    @Override
    public int hashCode() {
        return value;
    }
}
