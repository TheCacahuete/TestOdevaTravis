package donjon.item;

import donjon.personnage.Player;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 28/09/16.
 * Time : 16:23
 * TP de COO
 */
public class GoldTest {
    @Test
    public void action() throws Exception {
        Gold gold = new Gold(10);
        Player player = new Player(20,10,10);
        Player player2 = new Player(10,10,20);
        gold.action(player);
        assertEquals(player.getGold(), player2.getGold());
    }

    @Test
    public void getValue(){
        Gold gold = new Gold(10);
        assertEquals(10, gold.getValue());
    }

}