package game.entities;

import game.arena.IArena;
import game.arena.WinterArena;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import utilities.Point;

import static java.lang.Thread.sleep;

/**
 * Created by Matan & Tom on 15-Apr-19.
 */
public class MobileEntity extends Entity implements IMobileEntity{
    private final double maxSpeed;
    private final double acceleration;
    private double speed;
    private IArena myArena;
    /**
     * Ctor for a mobile entity in the game
     * @param initialSpeed initial speed of the entity
     * @param acceleration entity acceleration
     * @param maxSpeed entity maximum speed
     */
    public MobileEntity( double initialSpeed,double acceleration, double maxSpeed){
        this.setSpeed(initialSpeed);
        this.acceleration = acceleration;
        this.maxSpeed = maxSpeed;
    }
    /**
     * make competitors move until they cross the finish line.
     * and sleep for 100 ms between turns.
     */
    @Override
    public void run() {

        while (!myArena.isFinished(this)/**!isFinished((int)((WinterArena)myArena).getLength())**/) {
            move(myArena.getFriction());
            try {
                sleep(100);
            } catch (Exception e) { }
        }
        System.out.println(this.countObservers());
        setChanged();
        notifyObservers("Finished");
    }
    //region IMobileEntity Implementation

    /**
     * @see IMobileEntity#move(double)
     */
    @Override
    public void move(double friction) {
        //update the competitor speed.
        this.setSpeed(Math.min(this.maxSpeed,this.speed + this.getAcceleration()* (1-friction)));
        //update the competitor location, if the competitor cross the finish line he will be return to the finish line.
        setLocation(new Point(getLocation().getX(), Math.min(((WinterArena) myArena).getLength(),this.getLocation().getY()+this.speed)));
    }
    //endregion

    //region Setters
    public void setMyArena(IArena myArena) {
        this.myArena = myArena;
    }
    /**
     * Note: speed can theoretically be negative
     * @param speed the current speed of the entity
     */
    private void setSpeed(double speed) {
        this.speed = speed;
    }
    //endregion

    //region Getters
    public double getMaxSpeed() {
        return maxSpeed;
    }
    public double getSpeed() {
        return speed;
    }

    /**
     * @return the acceleration of the entity
     */
    protected double getAcceleration() {
        return acceleration;
    }
    //endregion

}
