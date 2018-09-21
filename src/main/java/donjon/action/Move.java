package donjon.action;
import donjon.adventureGame.AdventureGame;

import donjon.room.*;
import donjon.scanner.ListChoser;

import java.util.List;


public class Move implements Action{
    /**
     * toString
     *
     * @return the current definition of the donjon.donjon.action move
     */
    public String toString() {
        return "Move";
    }

    /**
     * function to know if the player can move
     *
     * @param game the current game
     * @return true if the player can move
     */
    public boolean isPossible(AdventureGame game) {
        return game.getCurrentRoom().getDirections() != null && !game.getCurrentRoom().ifGetMonster() && !game.getCurrentRoom().isFinish();
    }

    /**
     * do the move donjon.donjon.action (select a direction)
     *
     * @param game the current game
     */
    public void execute(AdventureGame game) {
        List<Direction> dirs;
        Direction dir;
        dirs = game.getCurrentRoom().getDirections();

        dir = ListChoser.CHOSER.chose("\nChose a direction ", dirs);
        game.playerMoveTo(dir);
    }
}
