package donjon.adventureGame;
import donjon.action.Action;
import donjon.item.*;
import donjon.room.*;
import donjon.personnage.*;
import donjon.action.*;
import donjon.scanner.*;


import java.util.*;
import java.util.List;


public class AdventureGame{
    private Room currentRoom;
    private Player player;
    private List<Action> actions;

    /**
     * Constructor
     *
     * @param startingRoom the first donjon.donjon.room of the game
     * @param player the player of the game
     */
    public AdventureGame(Room startingRoom, Player player) {
        this.currentRoom = startingRoom;
        this.player = player;
        this.actions = new ArrayList<Action>();
    }


    /**
     * get the player
     *
     * @return the current player
     */
    public Player getPlayer() {
        return this.player;
    }


    /**
     * toString
     *
     * @return the current definition of the game
     */
    public String toString() {
        return "AdventureGame{" +
                "currentRoom=" + currentRoom +
                ", player=" + player +
                '}';
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * the playing function (with choses and actions that the player chose)
     *
     *
     * @param player the current player
     */
    public void play (Player player){
        ArrayList<Action> actions_possible = new ArrayList<Action>();
        ArrayList<Action> actions = new ArrayList<Action>();
        actions.add(new Use());
        actions.add(new Attack());
        actions.add(new Look());
        actions.add(new Move());
        actions.get(2).execute(this);


        while (!isFinished() || currentRoom.ifGetMonster() ) {

            for (Action action : actions) {
                if (action.isPossible(this))
                    actions_possible.add(action);
            }

            Action action_chose;
            action_chose = ListChoser.CHOSER.chose("\nChose an donjon.donjon.action ", actions_possible);
            actions_possible.clear();
            action_chose.execute(this);
            if (player.isDead()){
                System.out.print("You re dead ...\n");
                break;
            }


        }
        System.out.print("\nGood job !! You win !!\n");
    }

    /**
     * function for add a monster in a donjon.donjon.room
     *
     * @param monster the monster that we add
     * @param room the donjon.donjon.room where we add the monster
     */
    public void addMonster (Monster monster, Room room){
        room.addMonster(monster);
    }


    /**
     * function for add an donjon.donjon.donjon.item in a donjon.donjon.room
     *
     * @param item the donjon.donjon.donjon.item that we add
     * @param room the donjon.donjon.room where we add the donjon.donjon.donjon.item
     */
    public void addItem (Item item, Room room){
        room.addItem(item);
    }


    /**
     * function use to change the current donjon.donjon.room and the player position
     *
     * @param direction the direction where the player move and the next current position
     */
    public void playerMoveTo (Direction direction){
        Look look = new Look();
        look.execute(this);
        Room tmpRoom = this.currentRoom.getNeighbor(direction);
        this.currentRoom = tmpRoom;
        getPlayer().setRoom(tmpRoom);
        System.out.print("\nYou move to " + direction + ".");
    }

    /**
     * function is finished return a boolean for the end of the game (if an exit is reach)
     *
     * @return a boolean
     */
    private boolean isFinished (){
        return this.currentRoom.isFinish();
    }

    /**
     * function equals to compare two games
     *
     * @param o an object to compare
     * @return a boolean (true if they are equals, or false if not)
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdventureGame that = (AdventureGame) o;

        if (currentRoom != null ? !currentRoom.equals(that.currentRoom) : that.currentRoom != null) return false;
        return player.equals(that.player);

    }

    /**
     * hashcode function for the current donjon.donjon.room
     *
     * @return int the result of hashcode function
     */
    public int hashCode() {
        int result = currentRoom != null ? currentRoom.hashCode() : 0;
        result = 31 * result + player.hashCode();
        return result;
    }
}
