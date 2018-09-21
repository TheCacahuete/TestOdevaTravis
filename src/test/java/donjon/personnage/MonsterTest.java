package donjon.personnage;

import donjon.item.Gold;
import donjon.item.Item;
import donjon.room.Room;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 28/09/16.
 * Time : 16:20
 * TP de COO
 */
public class MonsterTest extends MobTest     {
    @org.junit.Test
    public void getRoom(){
        Room room = new Room(new ArrayList<Monster>(),new ArrayList<Item>());
        Monster monstre = new Monster(10,10,room);
        assertEquals(room, monstre.getRoom());
    }

    @org.junit.Test
    public void dropGold() throws Exception {
        Room room = new Room(new ArrayList<Monster>(),new ArrayList<Item>());
        Monster monstre = new Monster(10,10,room,10);
        Gold gold = new Gold(10);
        monstre.dropGold(room);
        assertEquals(room.getItems().get(0), gold);
        assertEquals(0, monstre.getGold());
    }

    @org.junit.Test
    public void ripost(){
        Player player = new Player(10,10,10);
        Monster monstre = new Monster(11,5,null);
        monstre.ripost(player);
        assertEquals(5, player.getPdv());
    }
}