package game.entities.sportsman;

import game.enums.Discipline;
import game.enums.Gender;

/**
 * Created by Matan & Tom on 15-Apr-19.
 */
public class Skier extends WinterSportsman {
    /**
     * Ctor
     *
     * @param name
     * @param age
     * @param gender
     * @param acceleration
     * @param maxSpeed
     * @param discipline
     */
    public Skier(String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline) {
        super(name, age, gender, acceleration, maxSpeed, discipline);
    }
}
