package donjon.action;
import donjon.adventureGame.AdventureGame;
import donjon.item.Item;
import donjon.scanner.*;

public class Use implements Action{


    /**
     * function to know if the player can use an donjon.donjon.donjon.item
     *
     * @param game the current game
     * @return true if the player can use an donjon.donjon.donjon.item
     */
    public boolean isPossible(AdventureGame game){

        return game.getCurrentRoom().ifGetItem();
    }

    /**
     * the execute of use, the player can chose and use an donjon.donjon.donjon.item
     *
     * @param game the current game
     */
    public void execute (AdventureGame game) {
        Item item;

        item = ListChoser.CHOSER.chose("\nChose an donjon.donjon.donjon.item to use ", game.getCurrentRoom().getItems());
        item.action(game.getPlayer());
        game.getCurrentRoom().getItems().remove(item);

    }

    /**
     * toString
     *
     * @return the current definition of the donjon.donjon.action use
     */
    public String toString() {
        return "Use";
    }
}
