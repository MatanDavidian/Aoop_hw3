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

        this.setBackground(Color.CYAN);
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



    public JPanel getBuildArenaPanel() {
        return buildArenaPanel;
    }

    public void setBuildArenaPanel(JPanel buildArenaPanel) {
        this.buildArenaPanel = buildArenaPanel;
    }

    public JTextField getArenaLenght() {
        return arenaLenght;
    }

    public void setArenaLenght(JTextField arenaLenght) {
        this.arenaLenght = arenaLenght;
    }

    public JComboBox<String> getSnowSurface() {
        return snowSurface;
    }

    public void setSnowSurface(JComboBox<String> snowSurface) {
        this.snowSurface = snowSurface;
    }

    public JComboBox<String> getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(JComboBox<String> weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public JButton getBuildArena() {
        return buildArena;
    }

    public void setBuildArena(JButton buildArena) {
        this.buildArena = buildArena;
    }

    public JPanel getCreateCompetitionPanel() {
        return createCompetitionPanel;
    }

    public void setCreateCompetitionPanel(JPanel createCompetitionPanel) {
        this.createCompetitionPanel = createCompetitionPanel;
    }

    public JComboBox<String> getChooseCompetition() {
        return chooseCompetition;
    }

    public void setChooseCompetition(JComboBox<String> chooseCompetition) {
        this.chooseCompetition = chooseCompetition;
    }

    public JTextField getMaxCompetitorsNumber() {
        return maxCompetitorsNumber;
    }

    public void setMaxCompetitorsNumber(JTextField maxCompetitorsNumber) {
        this.maxCompetitorsNumber = maxCompetitorsNumber;
    }

    public JComboBox<String> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(JComboBox<String> discipline) {
        this.discipline = discipline;
    }

    public JComboBox<String> getLeague() {
        return league;
    }

    public void setLeague(JComboBox<String> league) {
        this.league = league;
    }

    public JComboBox<String> getGender() {
        return gender;
    }

    public void setGender(JComboBox<String> gender) {
        this.gender = gender;
    }

    public JButton getCreateCompetition() {
        return createCompetition;
    }

    public void setCreateCompetition(JButton createCompetition) {
        this.createCompetition = createCompetition;
    }

    public JPanel getAddCompetitorPanel() {
        return addCompetitorPanel;
    }

    public void setAddCompetitorPanel(JPanel addCompetitorPanel) {
        this.addCompetitorPanel = addCompetitorPanel;
    }


    public void setName(JTextField name) {
        this.name = name;
    }

    public JTextField getAge() {
        return age;
    }

    public void setAge(JTextField age) {
        this.age = age;
    }

    public JTextField getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(JTextField maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public JTextField getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(JTextField acceleration) {
        this.acceleration = acceleration;
    }

    public JButton getAddCompetitor() {
        return addCompetitor;
    }

    public void setAddCompetitor(JButton addCompetitor) {
        this.addCompetitor = addCompetitor;
    }

    public JPanel getStartAndInfoPanel() {
        return startAndInfoPanel;
    }

    public void setStartAndInfoPanel(JPanel startAndInfoPanel) {
        this.startAndInfoPanel = startAndInfoPanel;
    }

    public JButton getStartCompetition() {
        return startCompetition;
    }

    public void setStartCompetition(JButton startCompetition) {
        this.startCompetition = startCompetition;
    }

    public JButton getShowInfo() {
        return showInfo;
    }

    public void setShowInfo(JButton showInfo) {
        this.showInfo = showInfo;
    }
}
