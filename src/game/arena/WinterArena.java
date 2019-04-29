package game.arena;

import game.entities.IMobileEntity;
import game.entities.MobileEntity;
import game.enums.WeatherCondition;
import game.enums.SnowSurface;
import utilities.ValidationUtils;

/**
 * Created by Matan & Tom on 15-Apr-19.
 */
public class WinterArena implements IArena {
    /**
     * Important note:
     * Those fields (and more in this project) are currently final due to them not changing in HW3.
     * If in future tasks you will need to change them you could remove the final modifier and add a setter.
     */
    private final double length;
    private final SnowSurface surface;
    private final WeatherCondition condition;


    /**
     * Ctor for a generic arena
     *
     * @param length    the length of the arena
     * @param surface   the snow surface of the arena
     * @param condition the weather condition in the arena
     */
    public WinterArena(double length, SnowSurface surface, WeatherCondition condition) {
        this.length = length;
        this.surface = surface;
        this.condition = condition;
    }
    /**
     * @return string s that represent the arena.
     * @see Object toString
     */
    @Override
    public String toString() {
        String s= "length: " + length +"\nsurface: " + surface + "\ncondition: " + condition;
        return s;
    }
    /**
     * @param mobileEntity a mobileEntity to check if crossed the finished line.
     * @return represent of the arena.
     */
    @Override
    public boolean isFinished(IMobileEntity mobileEntity) {
        ValidationUtils.assertNotNull(mobileEntity);
        return mobileEntity.getLocation().getY() >= length;
    }
    //region Getters & setters
    /**
     * @return arena's friction
     */
    @Override
    public double getFriction() {
        return surface.getFriction();
    }
    /**
     * @return arena's length
     */
    public double getLength() {
        return length;
    }
    //end region

}
