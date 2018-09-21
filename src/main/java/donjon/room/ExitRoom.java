package donjon.room;

import donjon.item.Item;
import donjon.personnage.Monster;

import java.util.List;

/**
 * Created by Lefebvre Ryan && Poupart Valentin on 23/09/16.
 * Time : 09:37
 * TP de COO
 */
public class ExitRoom extends Room {
    /**
     * Constructor with monsters and items
     *
     * @param monsters a list of monsters of the donjon.donjon.room
     * @param items a list of items of the donjon.donjon.room
     */
    public ExitRoom(List<Monster> monsters, List<Item> items) {
        super(monsters, items);
        finish = true;
    }
}
