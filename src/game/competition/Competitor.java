package game.competition;

import game.arena.IArena;
import game.entities.IMobileEntity;

/**
 * Created by Matan & Tom on 15-Apr-19.
 */
public interface Competitor extends IMobileEntity {
    /**
     * start the race for this competitor
     * set the competitor place to the start of the competition
     */
    void initRace();

}
