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

        this.sidePanel.setLayout(new GridLayout(32 , 1));

        this.sidePanel.add(new JLabel("Build Arena"));
        this.sidePanel.add(new JLabel("Arena Length"));
        this.sidePanel.add(this.arenaLenght);
        this.sidePanel.add(new JLabel("Snow Surface"));
        this.sidePanel.add(this.snowSurface);
        this.sidePanel.add(new JLabel("Weather Condition"));
        this.sidePanel.add(this.weatherCondition);
        this.sidePanel.add(this.buildArena);
        this.sidePanel.add(new JLabel("Choose Competition"));
        this.sidePanel.add(this.chooseCompetition);
        this.sidePanel.add(new JLabel("Max competitors number"));
        this.sidePanel.add(this.maxCompetitorsNumber);
        this.sidePanel.add(new JLabel("Discipline"));
        this.sidePanel.add(this.discipline);
        this.sidePanel.add(new JLabel("League"));
        this.sidePanel.add(this.league);
        this.sidePanel.add(new JLabel("Gender"));
        this.sidePanel.add(this.gender);
        this.sidePanel.add(this.createCompetition);
        this.sidePanel.add(new JLabel("Add competitor"));
        this.sidePanel.add(new JLabel("name"));
        this.sidePanel.add(this.name);
        this.sidePanel.add(new JLabel("Age"));
        this.sidePanel.add(this.age);
        this.sidePanel.add(new JLabel("Max speed"));
        this.sidePanel.add(this.maxSpeed);
        this.sidePanel.add(new JLabel("Acceleration"));
        this.sidePanel.add(this.acceleration);
        this.sidePanel.add(this.addCompetitor);
        this.sidePanel.add(this.startCompetition);
        this.sidePanel.add(this.showInfo);






    }
}
