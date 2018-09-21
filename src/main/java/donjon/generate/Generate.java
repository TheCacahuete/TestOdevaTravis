package donjon.generate;

import donjon.adventureGame.AdventureGame;
import donjon.item.*;
import donjon.personnage.Monster;
import donjon.room.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 08/10/16.
 * Time : 13:39
 * TP de COO
 */
public class Generate {

    public static final Generate GENERATOR = new Generate();

    public Generate(){

    }

    /**
     * this function add items and monsters and generate the dungeon
     *
     * @param deep the numbers of recursivity of the function
     * @param room the current donjon.donjon.room
     */
    public void generateDungeon (int deep, Room room, AdventureGame game){
        // ajout voisin père
        if (!room.getNeighbors().isEmpty()){
            room.addNeighbor(room.getDirections().get(0), room.getNeighbor(room.getDirections().get(0)));
        }

        Random ran_room = new Random();
        Random ran_monster = new Random();
        Random ran_item = new Random();
        Random ran_bandit = new Random();

        ArrayList<Direction> direct_use = new ArrayList<Direction>();
        List<Monster> monsters = new ArrayList<Monster>();
        List<Item> items = new ArrayList<Item>();
        int len_dir = 0;

        // genere nombre de monstres,items,rooms
        int numb_of_rooms = ran_room.nextInt(4);
        int numb_of_monsters = ran_monster.nextInt(4)+1;
        int numb_of_items = ran_item.nextInt(3)+1;
        int bandit = ran_bandit.nextInt(3)+1;



        // genere les items
        if (numb_of_items >0){
            items = generateRandomItemsList(numb_of_items);
            for (Item it : items){

                game.addItem(it,room);

            }
        }


        // genere les monstres
        if (numb_of_monsters > 0){
            monsters = generateRandomMonstersList(numb_of_monsters);
            for (Monster mo : monsters){

                game.addMonster(mo,room);
            }
        }



        // genere un bandit avec un nombre d'items aléatoire
        if (bandit == 1) {
            ;
        }


        // creation derniere salle (sortie) si deep est a la fin ou si il n'y a pas de salle enfant
        if ((deep == 0) || (numb_of_rooms == 0)){
            // choix direction
            Direction dir = Direction.getRandomDirection();
            room.addNeighbor(dir, new ExitRoom(generateRandomMonstersList(ran_monster.nextInt(4)),generateRandomItemsList(ran_item.nextInt(3))));
        }


        else {
            // recursivité generate
            for (int j = numb_of_rooms; j > 0; j--) {
                while (len_dir <= 4) {
                    // choix directions
                    Direction dir = Direction.getRandomDirection();
                    if (!direct_use.contains(dir)) {
                        direct_use.add(dir);
                        len_dir += 1;

                    }
                }
            }

            for (Direction di : direct_use) {
                // ajout voisin et recursivité
                room.addNeighbor(di, new Room());
                generateDungeon(deep - 1, room.getNeighbor(di), game);
            }

        }

    }

    /**
     * generate a list of random items (*numb items)
     *
     * @param numb the numbers of items to generate
     * @return the generate items list
     */
    public List<Item> generateRandomItemsList(int numb){
        List<Item> items_generate = new ArrayList<Item>();
        List<Item> all_items = new ArrayList<Item>();
        all_items.add(new Life());
        all_items.add(new Strength());
        all_items.add(new Gold());


        for (int i = numb; i>0; i--){
            Random ran = new Random();
            int which_item_ind = ran.nextInt(3);
            items_generate.add(all_items.get(which_item_ind));
        }

        return items_generate;
    }

    /**
     * genereate a list of random monsters (*numb monsters)
     *
     * @param numb the numbers of monsters to generate
     * @return the generate monsters list
     */
    public List<Monster> generateRandomMonstersList(int numb){
        List<Monster> monsters_generate = new ArrayList<Monster>();
        for (int l = numb; l > 0 ; l --){
            monsters_generate.add(new Monster());
        }

        return monsters_generate;
    }
}
