package ui;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {

    private JPanel sidePanel;
    /**
     * build arena part
     */
    private JPanel buildArenaPanel;
    private JTextField arenaLenght;
    private JComboBox<String> snowSurface;
    private JComboBox<String> weatherCondition;
    private JButton buildArena;

    /**
     * create competition part
     */
    private JPanel createCompetitionPanel;
    private JComboBox<String> chooseCompetition;
    private JTextField maxCompetitorsNumber;
    private JComboBox<String> discipline;
    private JComboBox<String> league;
    private JComboBox<String> gender;
    private JButton createCompetition;

    /**
     * add competitor part
     */
    private JPanel addCompetitorPanel;
    private JTextField name;
    private JTextField age;
    private JTextField maxSpeed;
    private JTextField acceleration;
    private JButton addCompetitor;

    /**
     * start and info
     */
    private JPanel startAndInfoPanel;
    private JButton startCompetition;
    private JButton showInfo;


    public SidePanel() {
        this.addCompetitorPanel = new JPanel();
        this.buildArenaPanel = new JPanel();
        this.createCompetitionPanel = new JPanel();
        this.startAndInfoPanel = new JPanel();
        this.sidePanel = new JPanel();

        this.sidePanel.setBackground(Color.CYAN);
        this.arenaLenght = new JTextField();
        this.snowSurface = new JComboBox<>(new String[] {"Powder", "Crud" , "Ice"});
        this.weatherCondition = new JComboBox<>(new String[] {"Sunny" , "Stormy" , "Cloudy"});
        this.buildArena = new JButton("Build Arena");
        this.chooseCompetition = new JComboBox<>(new String[] {"Ski" , "Snowboard"});
        this.maxCompetitorsNumber = new JTextField();
        this.discipline = new JComboBox<>(new String[]{ "Slalom", "Giant Slaloom", "Downhill", "Freestyle"});
        this.league = new JComboBox<>(new String[]{"Junior" , "Adult" , "Senior"});
        this.gender = new JComboBox<>(new String[] {"Male" , "Female"});
        this.createCompetition = new JButton("Create Competition");
        this.name = new JTextField();
        this.age = new JTextField();
        this.maxSpeed = new JTextField();
        this.acceleration = new JTextField();
        this.addCompetitor = new JButton("Add Competitor");
        this.startCompetition = new JButton("Start Competition");
        this.showInfo = new JButton("Show Info");


        this.arenaLenght.setPreferredSize(new Dimension(125,25));
        this.snowSurface.setPreferredSize(new Dimension(125,25));
        this.weatherCondition.setPreferredSize(new Dimension(125,25));
        this.buildArena.setPreferredSize(new Dimension(125,25));
        this.chooseCompetition.setPreferredSize(new Dimension(125,25));
        this.maxCompetitorsNumber.setPreferredSize(new Dimension(125,25));
        this.discipline.setPreferredSize(new Dimension(125,25));
        this.league.setPreferredSize(new Dimension(125,25));
        this.gender.setPreferredSize(new Dimension(125,25));
        this.createCompetition.setPreferredSize(new Dimension(125,25));
        this.name.setPreferredSize(new Dimension(125,25));
        this.age.setPreferredSize(new Dimension(125,25));
        this.maxSpeed.setPreferredSize(new Dimension(125,25));
        this.acceleration.setPreferredSize(new Dimension(125,25));
        this.addCompetitor.setPreferredSize(new Dimension(125,25));
        this.startCompetition.setPreferredSize(new Dimension(125,25));
        this.showInfo.setPreferredSize(new Dimension(125,25));

        this.sidePanel.setLayout(new GridLayout(4 , 1));
        this.buildArenaPanel.setLayout(new GridLayout(8 , 1));
        this.createCompetitionPanel.setLayout(new GridLayout(11 , 1));
        this.addCompetitorPanel.setLayout(new GridLayout(10 , 1));
        this.startAndInfoPanel.setLayout(new GridLayout(2 , 1));

        this.buildArenaPanel.add(new JLabel("Build Arena"));
        this.buildArenaPanel.add(new JLabel("Arena Length"));
        this.buildArenaPanel.add(this.arenaLenght);
        this.buildArenaPanel.add(new JLabel("Snow Surface"));
        this.buildArenaPanel.add(this.snowSurface);
        this.buildArenaPanel.add(new JLabel("Weather Condition"));
        this.buildArenaPanel.add(this.weatherCondition);
        this.buildArenaPanel.add(this.buildArena);

        this.createCompetitionPanel.add(new JLabel("Choose Competition"));
        this.createCompetitionPanel.add(this.chooseCompetition);
        this.createCompetitionPanel.add(new JLabel("Max competitors number"));
        this.createCompetitionPanel.add(this.maxCompetitorsNumber);
        this.createCompetitionPanel.add(new JLabel("Discipline"));
        this.createCompetitionPanel.add(this.discipline);
        this.createCompetitionPanel.add(new JLabel("League"));
        this.createCompetitionPanel.add(this.league);
        this.createCompetitionPanel.add(new JLabel("Gender"));
        this.createCompetitionPanel.add(this.gender);
        this.createCompetitionPanel.add(this.createCompetition);

        this.addCompetitorPanel.add(new JLabel("Add competitor"));
        this.addCompetitorPanel.add(new JLabel("name"));
        this.addCompetitorPanel.add(this.name);
        this.addCompetitorPanel.add(new JLabel("Age"));
        this.addCompetitorPanel.add(this.age);
        this.addCompetitorPanel.add(new JLabel("Max speed"));
        this.addCompetitorPanel.add(this.maxSpeed);
        this.addCompetitorPanel.add(new JLabel("Acceleration"));
        this.addCompetitorPanel.add(this.acceleration);
        this.addCompetitorPanel.add(this.addCompetitor);

        this.startAndInfoPanel.add(this.startCompetition);
        this.startAndInfoPanel.add(this.showInfo);






    }
}
