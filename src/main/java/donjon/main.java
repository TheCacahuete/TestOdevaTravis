package donjon;

import donjon.adventureGame.AdventureGame;
import donjon.generate.Generate;
import donjon.personnage.*;
import donjon.room.*;


public class main {
    public static void main (String[] args) {
        Player player = new Player();
        Room start = new Room();

        AdventureGame the_game = new AdventureGame(start, player);

        Generate.GENERATOR.generateDungeon(2,start, the_game);
        System.out.print("You wake up in a dungeon ...\n");
        the_game.play(player);
    }

}
