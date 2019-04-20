package game.entities;

import game.arena.IArena;
import game.arena.WinterArena;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import utilities.Point;

import static java.lang.Thread.sleep;

/**
 * Created by itzhak on 07-Mar-19.
 */
public class MobileEntity extends Entity implements IMobileEntity{
    private final double maxSpeed;
    private final double acceleration;
    private double speed;
    private double friction = -1;
    private IArena myArena;
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
        if(getLocation().getX()>((WinterArena)myArena).getLength()) {
           setLocation(new Point(((WinterArena)myArena).getLength(),getLocation().getY()));
        }
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
            while (!isFinished((int)((WinterArena)myArena).getLength())) {
                move(friction);
                try {
                    sleep(100);
                } catch (Exception e) {

                }
            }
            System.out.println(this.countObservers());
            setChanged();
            notifyObservers("Finished");
        }
        else{
            throw new ValueException("friction value is -1 , try to upddate friction");
        }
    }


    public boolean isFinished(int len)
    {
        return this.getLocation().getX()>len;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getSpeed() {
        return speed;
    }
    public void setMyArena(IArena myArena) {
        this.myArena = myArena;
        this.friction = myArena.getFriction();
    }
}
