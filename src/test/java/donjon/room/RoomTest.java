package donjon.room;

import donjon.item.Gold;

import donjon.item.Item;
import donjon.personnage.Monster;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 28/09/16.
 * Time : 16:22
 * TP de COO
 */
public class RoomTest {
    @org.junit.Test
    public void addNeighbor(){
        Room room = new Room(new ArrayList<Monster>(),new ArrayList<Item>());
        Room room1 = new Room(new ArrayList<Monster>(),new ArrayList<Item>());;

        room.addNeighbor(Direction.RIGHT, room1);
        assertEquals(room.getNeighbor(Direction.RIGHT), room1);
    }

    @org.junit.Test
    public void addItem(){
        Room room = new Room(new ArrayList<Monster>(),new ArrayList<Item>());;
        Gold gold = new Gold(10);
        room.addItem(gold);
        assertEquals(gold, room.getItems().get(0));
    }

    @org.junit.Test
    public void addMonster(){
        Room room = new Room(new ArrayList<Monster>(),new ArrayList<Item>());;
        Monster monstre = new Monster(10,10,room);
        room.addMonster(monstre);
        assertTrue(room.getMonsters().contains(monstre));
    }

    @org.junit.Test
    public void ifGetMonster(){
        Room room = new Room(new ArrayList<Monster>(),new ArrayList<Item>());
        Monster monstre = new Monster(10,10,room);
        List<Monster> list = new ArrayList<Monster>();
        list.add(0, monstre);
        Room room1 = new Room(list,new ArrayList<Item>());
        assertTrue(!room.ifGetMonster());
        assertTrue(room1.ifGetMonster());
    }


    @org.junit.Test
    public void ifGetItem() throws Exception {
        Room room = new Room(new ArrayList<Monster>(),new ArrayList<Item>());
        Gold gold = new Gold(10);
        List<Item> list = new ArrayList<Item>();
        list.add(gold);
        Room room1 = new Room(new ArrayList<Monster>(), list);
        assertTrue(!room.ifGetItem());
        assertTrue(room1.ifGetItem());
    }

    @org.junit.Test
    public void deleteMonster(){
        Room room = new Room(new ArrayList<Monster>(),new ArrayList<Item>());
        Monster monstre = new Monster(10,10,room);
        monstre.setPdv(0);
        List<Monster> list = new ArrayList<Monster>();
        list.add(monstre);
        room.addMonster(monstre);
        room.deleteMonster(monstre);
        assertEquals(new ArrayList<Monster>(), room.getMonsters());
    }
}