package donjon.item;

import donjon.personnage.Monster;
import org.junit.*;
import static org.junit.Assert.*;

import donjon.generate.Generate;
import donjon.personnage.Player;
import donjon.room.Room;

import java.util.ArrayList;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 28/09/16.
 * Time : 16:23
 * TP de COO
 */
public class BanditTest {
    @org.junit.Test
    public void action(){
        Room room = new Room(new ArrayList<Monster>(),new ArrayList<Item>());
        Item bandit = new Bandit(Generate.GENERATOR.generateRandomItemsList(3));
        //Player player1 = new Player(10,11,bandit.getValue());
        assertTrue(true);
    }

}