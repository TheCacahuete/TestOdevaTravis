package donjon.item;

import donjon.personnage.Player;

import java.util.Random;

public class Life extends Potion{

    /**
     * Constructor with value
     *
     * @param value the life give by the potion
     */
    public Life(int value) {
        this.value = value;
    }

    /**
     * Constructor with random value
     */
    public Life() {
        Random ran = new Random();
        int val = ran.nextInt(6)+1;
        this.value = val;
    }

    /**
     * toString
     *
     * @return the description of the life potion
     */
    public String toString() {
        return "This potion add " + this.value + " hearth point.\n";
    }

    /**
     * the donjon.donjon.action for the life potion, she add hp to the player
     *
     * @param player the current player
     */
    public void action(Player player) {
        player.setPdv(this.value + player.getPdv());
    }


    /**
     * function equals to compare two life potions
     *
     * @param o an object to compare
     * @return a boolean (true if they are equals, or false if not)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Life life = (Life) o;

        return value == life.value;

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
