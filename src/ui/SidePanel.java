package ui;

import java.awt.GridLayout;

import javax.swing.*;

public class SidePanel extends JPanel {

    /**
     * build arena part
     */
    private JTextField arenaLenght;
    private JComboBox<String> snowSurface;
    private JComboBox<String> weatherCondition;
    private JButton buildArena;

    /**
     * create competition part
     */
    private JComboBox<String> chooseCompetition;
    private JTextField maxCompetitorsNumber;
    private JComboBox<String> Discipline;
    private JComboBox<String> league;
    private JComboBox<String> gender;
    private JButton createCompetition;

    /**
     * add competitor part
     */
    private JTextField name;
    private JTextField age;
    private JTextField maxSpeed;
    private JTextField acceleration;
    private JButton addCompetitor;

    /**
     * start and info
     */
    private JButton startCompetition;
    private JButton showInfo;

}
