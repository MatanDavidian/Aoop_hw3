package ui;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {

    private JPanel sidePanel;
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
    private JComboBox<String> discipline;
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


    public SidePanel() {
        this.sidePanel = new JPanel();
        this.sidePanel.setBackground(Color.CYAN);

        this.arenaLenght = new JTextField();
        this.snowSurface = new JComboBox<>(new String[] {});
        this.weatherCondition = new JComboBox<>();
        this.buildArena = new JButton("Build Arena");
        this.chooseCompetition = new JComboBox<>();
        this.maxCompetitorsNumber = new JTextField();
        this.discipline = new JComboBox<>();
        this.league = new JComboBox<>();
        this.gender = new JComboBox<>();
        this.createCompetition = new JButton("Create Competition");
        this.name = new JTextField();
        this.age = new JTextField();
        this.maxSpeed = new JTextField();
        this.acceleration = new JTextField();
        this.addCompetitor = new JButton("Add Competitor");
        this.startCompetition = new JButton("Start Competition");
        this.showInfo = new JButton("Show Info");
    }
}
