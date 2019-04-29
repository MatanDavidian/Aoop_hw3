package game.arena;

import game.entities.IMobileEntity;

/**
 * Created by Matan & Tom on 15-Apr-19.
 */
public interface IArena {
    /**
     * returns the friction of the arena
     *
     * @return friction
     */
    double getFriction();

    /**
     * indicated if a mobile entity has finished the arena course.
     *
     * @param mobileEntity entity to check
     * @return true if finished else false
     */
    boolean isFinished(IMobileEntity mobileEntity);


}
