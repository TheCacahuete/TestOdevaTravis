package donjon.action;
import donjon.adventureGame.AdventureGame;
import donjon.item.Item;
import donjon.personnage.*;


public class Look implements Action{
    /**
     * toString
     *
     * @return the current definition of the donjon.donjon.action look
     */
    public String toString() {
        return "Look";
    }

    /**
     * function to know if the player can look
     *
     * @param game the current game
     * @return true if the player can look
     */
    public boolean isPossible(AdventureGame game){
        return true;
    }

    /**
     * give the definition of the current donjon.donjon.room
     *
     * @param game the current game
     */
    public void execute (AdventureGame game){
        System.out.print("The donjon.donjon.room\n");
        System.out.print("The monsters : ");
        int nb = 1;
        for (Monster m : game.getCurrentRoom().getMonsters()){
            System.out.print(nb + ") " + m.toString() + "\n");
            nb ++;
        }
        nb = 1;
        System.out.print("\nThe items : ");
        for (Item i : game.getCurrentRoom().getItems()){
            System.out.print(nb + ") " + i.toString());
            nb++;
        }
        System.out.print("\nThe player :\n  -pdv = " + game.getPlayer().getPdv() +
                "\n  -gold = " + game.getPlayer().getGold() +
                "\n  -strength = " + game.getPlayer().getStrength() + "\n");

    }
}
