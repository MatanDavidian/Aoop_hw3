package game.competition;

import game.arena.IArena;
import game.entities.MobileEntity;
import utilities.ValidationUtils;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * Created by Matan & Tom on 15-Apr-19.
 */
public abstract class Competition extends Thread implements Observer{
    /**
     * Important note:
     * Those fields (and more in this project) are currently final due to them not changing in HW3.
     * If in future tasks you will need to change them you could remove the final modifier and add a setter.
     */
    private IArena arena;
    private final Vector<Competitor> activeCompetitors;
    private final Vector<Competitor> finishedCompetitors;
    private final int maxCompetitors;

    /**
     * Ctor for an abstract competition
     *
     * @param arena          Arena in which the competition takes place in
     * @param maxCompetitors Maximum number of competitor allowed in the competition
     */
    public Competition(IArena arena, int maxCompetitors) {
        this.maxCompetitors = maxCompetitors;
        this.activeCompetitors = new Vector<>();
        this.finishedCompetitors = new Vector<>();
        this.arena = arena;
    }
    /**
     * Validate if a competitor can compete
     *
     * @param competitor contending competitor
     * @return true if competitor is validated else false
     */
    protected abstract boolean isValidCompetitor(Competitor competitor);

    /**
     * adds a valid competitor to the competition
     *
     * @param competitor competitor to be added
     */
    public void addCompetitor(Competitor competitor) {
        ValidationUtils.assertNotNull(competitor);
        if (maxCompetitors <= activeCompetitors.size()) {
            throw new IllegalStateException("WinterArena is full max = " + maxCompetitors);
        }
        if (isValidCompetitor(competitor)) {
            competitor.initRace();
            activeCompetitors.add(competitor);
        } else {
            throw new IllegalArgumentException("Invalid competitor " + competitor);
        }
    }
    /**
     *  Start the race
     ** This method will run the threads of all players.
     */
    public void startCompetition() {
        //ArrayList<Competitor> tmp = new ArrayList<>(activeCompetitors);
        for (Competitor competitor : activeCompetitors) {
            ((MobileEntity) competitor).addObserver(this);
            if (!arena.isFinished(competitor)) {
                ((MobileEntity)competitor).setMyArena(arena);
                new Thread((MobileEntity)competitor).start();
            }
        }
    }
    /**
     *  @see Observer update methood
     * add the competitior to finishedCompetitors.
     * remove the competitior from activeCompetitors(Realization with lower running time than vector.remove(Object) ).
     */
    @Override
    public synchronized void update(Observable o, Object arg) {
        finishedCompetitors.add((Competitor) o);
        int index=activeCompetitors.indexOf(o);
        activeCompetitors.set(index,activeCompetitors.lastElement());
        activeCompetitors.remove(activeCompetitors.size()-1);

    }
    //region Getters & setters
    /**
     * Get competitors who have finished (used later so we could print them)
     * @return all finished competitors.
     */
    public Vector<Competitor> getFinishedCompetitors() {
        return new Vector<>(finishedCompetitors);
    }
    public IArena getArena() {
        return arena;
    }
    public void setArena(IArena arena) {
        this.arena = arena;
    }
    public Vector<Competitor> getActiveCompetitors() {
        return activeCompetitors;
    }
    public int getMaxCompetitors() {
        return maxCompetitors;
    }
    //end region

}
