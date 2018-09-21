package donjon.room;

import donjon.item.Item;
import donjon.personnage.*;

import java.util.*;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 21/09/16.
 * Time : 20:17
 * TP de COO
 */
public class Room {

    /**
     * toString
     *
     * @return the description of the donjon.donjon.room
     */
    public String toString() {
        return "Room{" +
                "monsters= " + monsters.size() +
                ", items= " + items.size() +
                '}';
    }

    private ArrayList<Monster> monsters;
    private ArrayList<Item> items;
    private Map<Direction, Room> neighbors;
    protected boolean finish;
    private Player player;

    /**
     * Constructor without monsters and items
     */
    public Room(){
        this.finish = false;
        this.monsters = new ArrayList<Monster>();
        this.items = new ArrayList<Item>();
        this.neighbors = new HashMap<Direction, Room>();
    }

    /**
     * Constructor
     *
     * @param monsters_list a list of monsters of the donjon.donjon.room
     * @param items_list a list of items of the donjon.donjon.room
     */
    public Room(List<Monster> monsters_list, List<Item> items_list) {
        this.monsters = new ArrayList<Monster>();
        this.items = new ArrayList<Item>();

        this.neighbors = new HashMap<Direction, Room>();
        for (Monster mon : monsters_list){

            this.monsters.add(mon);
        }

        for (Item ite : items_list){

            this.items.add(ite);
        }

        finish = false;
    }

    /**
     * add a neighbor to the donjon.donjon.room
     *
     * @param dir the direction of the neighbor
     * @param room the donjon.donjon.room of the neighbor
     */
    public void addNeighbor(Direction dir, Room room){
        this.neighbors.put(dir, room);
    }

    /**
     * add an donjon.donjon.donjon.item in a donjon.donjon.room
     *
     * @param item to add to the donjon.donjon.room
     */
    public void addItem(Item item){
        this.items.add(item);
    }

    /**
     * add a monster in a donjon.donjon.room
     *
     * @param monster to add to the donjon.donjon.room
     */
    public void addMonster(Monster monster){
        this.monsters.add(monster);
    }

    /**
     * return all the neighbors of the donjon.donjon.room
     *
     * @return all the neighbors
     */
    public Collection<Room> getNeighbors(){
        return this.neighbors.values();
    }

    /**
     * get the neighbor to a direction
     *
     * @param direction the direction where we look the neighbor
     * @return the donjon.donjon.room of the neighbor
     */
    public Room getNeighbor(Direction direction){

        return this.neighbors.get(direction);
    }

    /**
     * allow to get all the directions use for the donjon.donjon.room to a neighbor
     *
     * @return the list of the directions
     */
    public List<Direction> getDirections(){
        return new ArrayList<Direction>(this.neighbors.keySet());
    }

    public boolean isFinish(){
        return finish;
    }

    /**
     * allow to know if there is monster in the donjon.donjon.room
     *
     * @return true if there is monster
     */
    public boolean ifGetMonster(){
        return !this.monsters.isEmpty();
    }

    /**
     * get for the monsters
     *
     * @return the monsters
     */
    public List<Monster> getMonsters() {
        return this.monsters;
    }

    /**
     * get for the items
     *
     * @return the items list
     */
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * allow to know if there is donjon.donjon.donjon.item in the donjon.donjon.room
     *
     * @return true if there is donjon.donjon.donjon.item
     */
    public boolean ifGetItem(){
        return !this.items.isEmpty();
    }

    /**
     * remove a monster when he s dead
     *
     * @param monster the monster to remove if he's dead after taking damage
     */
    public void deleteMonster (Monster monster){
        if (monster.isDead()){
            monsters.remove(monster);
        }
    }

    /**
     * function equals to compare two rooms
     *
     * @param o an object to compare
     * @return a boolean (true if they are equals, or false if not)
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (finish != room.finish) return false;
        if (monsters != null ? !monsters.equals(room.monsters) : room.monsters != null) return false;
        if (items != null ? !items.equals(room.items) : room.items != null) return false;
        return neighbors != null ? neighbors.equals(room.neighbors) : room.neighbors == null;

    }

    /**
     * hashcode function
     *
     * @return int the result of hashcode function
     */
    public int hashCode() {
        int result = monsters != null ? monsters.hashCode() : 0;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (neighbors != null ? neighbors.hashCode() : 0);
        result = 31 * result + (finish ? 1 : 0);
        return result;
    }


}
