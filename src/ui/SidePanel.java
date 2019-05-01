package ui;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {


    /**
     * build arena part
     */
    private JPanel buildArenaPanel;
    private JTextField arenaLenght;
    private JComboBox<String> snowSurface;
    private JComboBox<String> weatherCondition;
    JButton buildArena;

    /**
     * create competition part
     */
    private JPanel createCompetitionPanel;
    private JComboBox<String> chooseCompetition;
    private JTextField maxCompetitorsNumber;
    private JComboBox<String> discipline;
    private JComboBox<String> league;
    private JComboBox<String> gender;
    JButton createCompetition;

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
        this.addCompetitorPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.buildArenaPanel = new JPanel();
        this.buildArenaPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.createCompetitionPanel = new JPanel();
        this.createCompetitionPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.startAndInfoPanel = new JPanel();
        this.startAndInfoPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));


        //this.setBackground(Color.CYAN);
        this.arenaLenght = new JTextField();
        this.snowSurface = new JComboBox<>(new String[] {"Powder", "Crud" , "Ice"});
        this.weatherCondition = new JComboBox<>(new String[] {"Sunny" , "Stormy" , "Cloudy"});
        this.buildArena = new JButton("Build Arena");
        this.chooseCompetition = new JComboBox<>(new String[] {"Ski" , "Snowboard"});
        this.maxCompetitorsNumber = new JTextField("10");
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

        this.setLayout(new GridLayout(0 , 1));
        this.buildArenaPanel.setLayout(new GridLayout(8 , 1));
        this.createCompetitionPanel.setLayout(new GridLayout(11 , 1));
        this.addCompetitorPanel.setLayout(new GridLayout(10 , 1));
        this.startAndInfoPanel.setLayout(new GridLayout(2 , 1));


        JSeparator js = new JSeparator();
        js.setBorder(BorderFactory.createEmptyBorder(100,0,100,0));


        this.add(new JLabel("<HTML><U><font color=blue><b>Build Arena</b></font></U></HTML>"));
        this.add(new JLabel("Arena Length"));
        this.add(this.arenaLenght);
        this.add(new JLabel("Snow Surface"));
        this.add(this.snowSurface);
        this.add(new JLabel("Weather Condition"));
        this.add(this.weatherCondition);
        this.add(new JLabel(""));
        this.add(this.buildArena);
        this.add(new JLabel(""));
        this.add(new JSeparator());

        this.add(new JLabel("<HTML><U><font color=blue><b>Choose Competition</b></font></U></HTML>"));
        this.add(this.chooseCompetition);
        this.add(new JLabel("Max competitors number"));
        this.add(this.maxCompetitorsNumber);
        this.add(new JLabel("Discipline"));
        this.add(this.discipline);
        this.add(new JLabel("League"));
        this.add(this.league);
        this.add(new JLabel("Gender"));
        this.add(this.gender);
        this.add(new JLabel(""));
        this.add(this.createCompetition);
        this.add(new JLabel(""));
        this.add(new JSeparator());


        this.add(new JLabel("<HTML><U><font color=blue><b>Add competitor</b></font></U></HTML>"));
        this.add(new JLabel("name"));
        this.add(this.name);
        this.add(new JLabel("Age"));
        this.add(this.age);
        this.add(new JLabel("Max speed"));
        this.add(this.maxSpeed);
        this.add(new JLabel("Acceleration"));
        this.add(this.acceleration);
        this.add(new JLabel(""));
        this.add(this.addCompetitor);
        this.add(new JLabel(""));
        this.add(new JSeparator());


        this.add(this.startCompetition);
        this.add(this.showInfo);


        this.setVisible(true);




    }

    public JTextField getArenaLenght() {
        return arenaLenght;
    }

    public JComboBox<String> getSnowSurface() {
        return snowSurface;
    }


    public JComboBox<String> getWeatherCondition() {
        return weatherCondition;
    }

    public JComboBox<String> getChooseCompetition() {
        return chooseCompetition;
    }
    public JTextField getMaxCompetitorsNumber() {
        return maxCompetitorsNumber;
    }

    public JComboBox<String> getDiscipline() {
        return discipline;
    }

    public JComboBox<String> getLeague() {
        return league;
    }

    public JComboBox<String> getGender() {
        return gender;
    }

    public void setGender(JComboBox<String> gender) {
        this.gender = gender;
    }

    public JTextField getNameFromTxtBox() {
        return name;
    }

    public JTextField getAge() {
        return age;
    }

    public JTextField getMaxSpeed() {
        return maxSpeed;
    }

    public JTextField getAcceleration() {
        return acceleration;
    }

    public JButton getAddCompetitor() {
        return addCompetitor;
    }

    public JButton getStartCompetition() {
        return startCompetition;
    }


    public JButton getShowInfo() {
        return showInfo;
    }

}
