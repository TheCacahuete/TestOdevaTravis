package donjon.item;


import donjon.personnage.Player;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 28/09/16.
 * Time : 16:25
 * TP de COO
 */
public class LifeTest {
    @org.junit.Test
    public void action(){
        Player player = new Player(10,10);
        Player player2 = new Player(20,10);
        Life life = new Life(10);
        life.action(player);
        assertEquals(player2.getPdv(), player.getPdv());
    }

}