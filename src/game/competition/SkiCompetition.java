package game.competition;

import game.arena.WinterArena;
import game.entities.sportsman.Skier;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

/**
 * Created by Matan & Tom on 15-Apr-19.
 */
public class SkiCompetition extends WinterCompetition {
    /**
     * Ctor for the competition
     *
     * @param arena          Winter arena in which the competition takes place in
     * @param maxCompetitors max competitors in the competition
     * @param discipline     discipline
     * @param league         age league
     * @param gender         gender
     */
    public SkiCompetition(WinterArena arena, int maxCompetitors, Discipline discipline, League league, Gender gender) {
        super(arena, maxCompetitors, discipline, league, gender);
    }

    @Override
    protected boolean isValidCompetitor(Competitor competitor) {
        return competitor instanceof Skier && super.isValidCompetitor(competitor);
    }
}
