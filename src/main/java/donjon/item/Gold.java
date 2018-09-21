package donjon.item;

import donjon.personnage.Player;

import java.util.Random;

public class Gold implements Item{
    private  int value;


    /**
     * Constructor with value
     *
     * @param value the gold give
     */
    public Gold(int value) {
        this.value = value;
    }


    /**
     * Constructor with random value
     */
    public Gold() {
        Random ran = new Random();
        int val = ran.nextInt(8)+1;
        this.value = val;
    }

    /**
     * toString
     *
     * @return the description of the life potion
     */
    public String toString() {
        return "There is " + this.value + " gold.\n";
    }

    /**
     * the donjon.donjon.action for the gold, she add gold to the player
     *
     * @param player the current player
     */
    public void action(Player player) {
        player.setGold(this.getValue());
    }

    /**
     * get the numbers of gold
     *
     * @return the gold value
     */
    public int getValue() {
        return value;
    }


    /**
     * function equals to compare two golds items
     *
     * @param o an object to compare
     * @return a boolean (true if they are equals, or false if not)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gold gold = (Gold) o;

        return value == gold.value;

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
