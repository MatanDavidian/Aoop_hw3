package game.entities;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import utilities.Point;
/**
 * Created by itzhak on 07-Mar-19.
 */
public class MobileEntity extends Entity implements IMobileEntity{
    private final double maxSpeed;
    private final double acceleration;
    private double speed;
    private double friction = -1;
    public void setFriction(double friction) {
        this.friction = friction;
    }
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

    //region IMobileEntity Implementation

    /**
     * @see IMobileEntity#move(double)
     */
    @Override
    public synchronized void move(double friction) {
        this.setSpeed(Math.min(this.maxSpeed,this.speed + this.getAcceleration()* (1-friction)));
        Point newLocation = this.getLocation().offset(this.speed,0);
        this.setLocation(newLocation);
    }
    //endregion

    //region Setters

    /**
     * Note: speed can theoretically be negative
     * @param speed the current speed of the entity
     */
    private void setSpeed(double speed) {
        this.speed = speed;
    }
    //endregion

    //region Getters

    /**
     * @return the acceleration of the entity
     */
    protected double getAcceleration() {
        return acceleration;
    }
    //endregion
    /**
     * in order to "strat()" u need
     */
    @Override
    public void run() {
        if(friction!=-1) {
            move(friction);
        }
        else{
            throw new ValueException("friction value is -1 , try to upddate friction");
        }
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getSpeed() {
        return speed;
    }
}
