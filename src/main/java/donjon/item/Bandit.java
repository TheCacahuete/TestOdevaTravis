package donjon.item;

import donjon.personnage.Player;

import java.util.List;
import java.util.Random;

public class Bandit {
    private int value;
    private List<Item> items;

    /**
     *  Constructor random values
     *
     * @param items the list of items that he can drop
     */
    public Bandit(List<Item> items) {
        Random ran = new Random();
        int cost = ran.nextInt(11)+5;
        this.value = cost;
        this.items = items;
    }

    /**
     * Constructor
     *
     * @param value the cost for the player
     * @param items the list of items that he can drop
     */
    public Bandit(int value, List<Item> items) {
        this.value = value;
        this.items = items;
    }

    /**
     * set the new cost
     *
     * @param value the new cost for the player
     */
    public void setValue(int value) {
        this.value = value;
    }

    public void action(Player player) {
        if (player.getGold()>= this.getValue()){
            player.setGold((player.getGold()-this.getValue()));
            Item new_item;
            Random ran = new Random();
            int i = ran.nextInt(items.size());
            player.getRoom().addItem(items.get(i));
        }
        else {
            System.out.println("You don't have anny gold! It's a pity...");
        }

    }

    /**
     * toString
     *
     * @return the description of bandit
     */
    public String toString() {
        return "This one-armed bandit cost " + this.value + ".\n";
    }


    /**
     * get the cost
     *
     * @return int the cost
     */
    public int getValue() {
        return this.value;
    }


    /**
     * function equals to compare two bandits
     *
     * @param o an object to compare
     * @return a boolean (true if they are equals, or false if not)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bandit bandit = (Bandit) o;

        if (getValue() != bandit.getValue()) return false;
        return items != null ? items.equals(bandit.items) : bandit.items == null;

    }


    /**
     * hashcode function
     *
     * @return int the result of hashcode function
     */
    @Override
    public int hashCode() {
        int result = getValue();
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }
}
