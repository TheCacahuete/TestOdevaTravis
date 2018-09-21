package donjon.action;

import donjon.adventureGame.AdventureGame;

public interface Action {
    public boolean isPossible(AdventureGame game);
    public void execute (AdventureGame game);
    public String toString();
}

