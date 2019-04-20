package game;

import game.arena.WinterArena;
import game.competition.Competition;
import game.competition.Competitor;
import utilities.ValidationUtils;

import static java.lang.Thread.sleep;

public class GameEngine implements Runnable {

    private static GameEngine instance;
    private Competition competition;

    /**
     * .
     *
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
     * This method will play competition turns until finished then print the results.
     *
     * @param competition The competition to be run
     */
    public void startRace(Competition competition) {
        ValidationUtils.assertNotNull(competition);
        int step=0;
        competition.startCompetition();
        //here was loop that call to play turn at competition to make a step
        /**
        for (step = 0; competition.hasActiveCompetitors(); step++) {
            competition.playTurn();
            try{
                sleep(30);
            }
            catch (Exception e) {}
        }
         **/
        System.out.println("race finished in " + step + " steps");
        printResults(competition);
    }

    /**
     * print the game results
     */
    private void printResults(Competition competition) {
        System.out.println("Race results:");
        int place = 1;
        for (Competitor skier : competition.getFinishedCompetitors()) {
            System.out.println(place + ". " + skier);
            place++;
        }
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Override
    public void run() {
        if (competition != null){
            startRace(competition);
        }
    }
}
