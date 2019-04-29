package game;

import game.arena.WinterArena;
import game.competition.Competition;
import game.competition.Competitor;
import utilities.ValidationUtils;

import static java.lang.Thread.sleep;

/**
 * Created by Matan & Tom on 15-Apr-19.
 */
public class GameEngine{

    private static GameEngine instance;
    private Competition competition;
    /**

     * @return singleton instance of the game engine
     */
    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    /**
     * private empty Ctor for game engine
     */
    private GameEngine() {
    }

    /**
     * Start a race at a competition
     * This method will call to startCompetition method of competition obj to run all the threads of the competitors if they valid
     * @param competition The competition to be run
     */
    public void startRace(Competition competition) {
        ValidationUtils.assertNotNull(competition);
        competition.startCompetition();
    }
    //region Getters & setters

    /**
     * @return competition
     */
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
    //end region
}
