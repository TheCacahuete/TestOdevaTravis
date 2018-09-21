package donjon.item;


public abstract class Potion implements Item{
    public int value;

    /**
     * get the value
     *
     * @return the value of the potion
     */
    public int getValue() {
        return this.value;
    }
}
