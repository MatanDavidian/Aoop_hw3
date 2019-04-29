
package utilities;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import ui.MainScreen;
import game.GameEngine;
import game.arena.WinterArena;
import game.competition.Competition;
import game.competition.SkiCompetition;
import game.competition.WinterCompetition;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.entities.sportsman.WinterSportsman;
import game.enums.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
/**
 * Created by Matan & Tom on 15-Apr-19.
 * the driver to run the program
 */
public class Program {

    public static void main(String[] args) {
        BufferedReader decisionReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            MainScreen frame = new MainScreen();
            frame.setVisible(true);
        } catch (ValueException e) {
            System.out.println("main error");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
