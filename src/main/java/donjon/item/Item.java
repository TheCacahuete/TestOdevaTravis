package donjon.item;

import donjon.personnage.Player;

public interface Item{

    public String toString();

    public void action(Player player);
}
