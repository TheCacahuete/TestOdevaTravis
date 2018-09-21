package donjon.personnage;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 28/09/16.
 * Time : 16:17
 * TP de COO
 */
public class
MobTest {
    @Test
    public void getPdv(){
        Player player = new Player(10,10);
        assertEquals(10, player.getPdv());
    }

    @Test
    public void setPdv(){
        Player player = new Player(5,10);
        player.setPdv(10);
        assertEquals(10, player.getPdv());
    }

    @Test
    public void getStrength(){
        Player player = new Player(10,10);
        assertEquals(10, player.getStrength());
    }

    @Test
    public void setStrength(){
        Player player = new Player(5,10);
        player.setStrength(10);
        assertEquals(10, player.getStrength());
    }

    @Test
    public void getGold(){
        Player player = new Player(10,10,10);
        assertEquals(10, player.getStrength());
    }

    @Test
    public void setGold(){
        Player player = new Player(5,10);
        player.setGold(10);
        assertEquals(10, player.getGold());
    }

    @Test
    public void isDead(){
        Player player = new Player(0,0);
        assertTrue(player.isDead());
    }

}