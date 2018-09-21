package donjon.action;
import donjon.adventureGame.AdventureGame;
import donjon.personnage.*;
import donjon.scanner.*;



public class Attack implements Action {

    /**
     * function to know if the player can attack
     *
     * @param game the current game
     * @return true if the player can attack
     */
    public boolean isPossible(AdventureGame game){

        return game.getCurrentRoom().ifGetMonster();
    }

    /**
     * the execute of the attack, the player can chose and kill a monster
     *
     * @param game the current game
     */
    public void execute (AdventureGame game){
        Monster choseMonster;

        if (game.getCurrentRoom().getMonsters().size()==1){
            choseMonster = game.getCurrentRoom().getMonsters().get(0);

        }
        else {
            choseMonster = ListChoser.CHOSER.chose("\nChose a monster to attack ", game.getCurrentRoom().getMonsters());

        }

        System.out.print("\nYou attack with " + game.getPlayer().getStrength() + " damage, the monster have " + (choseMonster.getPdv() - game.getPlayer().getStrength()) + " hp.\n");

        choseMonster.setPdv(choseMonster.getPdv() - game.getPlayer().getStrength());
        if (choseMonster.isDead()){
            choseMonster.dropGold(game.getCurrentRoom());
            game.getCurrentRoom().deleteMonster(choseMonster);
            System.out.print("\nSomeone die... but not you");
        }
        else {
            choseMonster.ripost(game.getPlayer());
            System.out.print("\nThe monster inflict you " + choseMonster.getStrength() + "You've " + game.getPlayer().getPdv());
        }
    }

    /**
     * toString
     *
     * @return the current definition of the donjon.donjon.action attack
     */
    public String toString() {
        return "Attack";
    }
}
