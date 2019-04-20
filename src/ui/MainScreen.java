package ui;
import game.GameEngine;
import game.arena.WinterArena;
import game.competition.*;
import game.entities.MobileEntity;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.entities.sportsman.Sportsman;
import game.entities.sportsman.WinterSportsman;
import game.enums.*;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import sun.awt.SunHints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;

public class MainScreen extends JFrame{
    private Competition competition;
    private WinterArena arena;
    private ArenaPanel arenaPanel= new ArenaPanel("None");
    private SidePanel sidePanel;
    private String compType;
    private String gender;
    private static int distance = 0;


    public MainScreen() throws Exception {
        setSize(1175,700);
        this.setTitle("Competition");
        JPanel arenaPanel = new ArenaPanel("None");
        JPanel sidePanel = new SidePanel();

        this.add(arenaPanel, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * **************************************
         * buildArena Button -  action listener *
         * **************************************
         */
        ((SidePanel) sidePanel).buildArena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * setting the arena.
                 */
                String arenaName = ((SidePanel) sidePanel).getWeatherCondition().getSelectedItem().toString() + ".jpg";
                String arenaLengthString = ((SidePanel) sidePanel).getArenaLenght().getText().toString();
                String arenaSnowSurface = ((SidePanel) sidePanel).getSnowSurface().getSelectedItem().toString().toUpperCase();
                String arenaWeatherCondition = ((SidePanel) sidePanel).getWeatherCondition().getSelectedItem().toString().toUpperCase();
                int arenaLength = 0;
                /**
                 * if arenaLengthString is not int , the value of arenaLength will be zero.
                 */
                try {
                    arenaLength = Integer.parseInt(arenaLengthString);
                }
                catch (NumberFormatException ex){
                    arenaLength = 0;
                }


                try {
                    //set image according to name and length.
                    ((ArenaPanel) arenaPanel).setImage(arenaName , arenaLength);
                }
                catch (ValueException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                // adding the arena details to competition
                arena = new WinterArena(arenaLength , SnowSurface.valueOf(arenaSnowSurface) , WeatherCondition.valueOf(arenaWeatherCondition));
                setSize(1175,arenaLength+80);
                //print details of the arena.
                System.out.println(arena);

                //painting the canvas.
                ((ArenaPanel) arenaPanel).setCompetition(null);
                ((ArenaPanel) arenaPanel).getCompetitors().removeAllElements();
                revalidate();
                repaint();
            }
        });
        /**
         * **********************************************
         * Create Competition Button -  action listener *
         * **********************************************
         */
        ((SidePanel) sidePanel).createCompetition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * setting the Competition.
                 */
                String competitionType = ((SidePanel) sidePanel).getChooseCompetition().getSelectedItem().toString() + "Competition";
                String stringMaxCompetitorsNumber = ((SidePanel) sidePanel).getMaxCompetitorsNumber().getText();
                int maxCompetitorsNumber;
                try {
                    maxCompetitorsNumber = Integer.parseInt(stringMaxCompetitorsNumber);
                }
                catch (NumberFormatException ex){
                    System.out.println("Error! enter a number at max competitors number.");
                    maxCompetitorsNumber = 0;
                }

                String stringDiscipline = ((SidePanel) sidePanel).getDiscipline().getSelectedItem().toString();
                Discipline discipline;
                if(stringDiscipline=="Slalom")
                    discipline= Discipline.SLALOM;
                else if(stringDiscipline=="Giant Slalom")
                    discipline= Discipline.GIANT_SLALOM;
                else if(stringDiscipline=="Downhill")
                    discipline= Discipline.DOWNHILL;
                else if(stringDiscipline=="Freestyle")
                    discipline= Discipline.FREESTYLE;
                else
                    discipline= Discipline.FREESTYLE;
                String stringLeague = ((SidePanel) sidePanel).getLeague().getSelectedItem().toString();
                League league;
                if(stringLeague=="Junior")
                    league= League.JUNIOR;
                else if(stringLeague=="Adult")
                    league= League.ADULT;
                else if(stringLeague=="Senior")
                    league= League.SENIOR;
                else
                    league= League.JUNIOR;
                String stringGender = ((SidePanel) sidePanel).getGender().getSelectedItem().toString();
                Gender gender;
                if(stringGender=="Male")
                    gender= Gender.MALE;
                else if(stringGender=="Female")
                    gender= Gender.FEMALE;
                else
                    gender= Gender.MALE;
                // adding the arena details to competition
                if(competitionType.equals("SkiCompetition"))
                     competition = new SkiCompetition(arena,maxCompetitorsNumber,discipline,league,gender);
                else if (competitionType.equals("SnowboardCompetition"))
                    competition = new SnowboardCompetition(arena,maxCompetitorsNumber,discipline,league,gender);
                ((ArenaPanel)(arenaPanel)).setCompetition(competition);
                ((ArenaPanel) arenaPanel).getCompetitors().removeAllElements();
                revalidate();
                repaint();
                //print details of the arena.
                System.out.println(competition);
            }
        });


        /**
         * **************************************
         * Add Competitor Button -  action listener *
         * **************************************
         */
        ((SidePanel) sidePanel).getAddCompetitor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * setting the competitor.
                 */
                String name = ((SidePanel) sidePanel).getNameFromTxtBox().getText();
                String stringAge = ((SidePanel) sidePanel).getAge().getText();
                int age;
                try {
                    age = Integer.parseInt(stringAge);
                }
                catch (NumberFormatException ex){
                    throw new ValueException("Wrong age value");
                }
                String stringMaxSpeed = ((SidePanel) sidePanel).getMaxSpeed().getText();
                int maxSpeed;
                try {
                    maxSpeed = Integer.parseInt(stringMaxSpeed);
                }
                catch (NumberFormatException ex){
                    throw new ValueException("Wrong max speed value");
                }
                String stringAcceleration = ((SidePanel) sidePanel).getAcceleration().getText();
                int acceleration;
                try {
                    acceleration = Integer.parseInt(stringAcceleration);
                }
                catch (NumberFormatException ex){
                    throw new ValueException("Wrong max speed value");
                }
                // adding the arena details to competition
                WinterSportsman competitor;
                gender = ((WinterCompetition)competition).getGender().toString();
                compType="" ;
                if(competition instanceof SkiCompetition) {
                    competitor = new Skier(name, age, ((WinterCompetition) competition).getGender(), acceleration, maxSpeed, ((WinterCompetition) competition).getDiscipline());

                    compType = "Ski";
                }
                else if(competition instanceof SnowboardCompetition) {
                    competitor = new Snowboarder(name, age, ((WinterCompetition) competition).getGender(), acceleration, maxSpeed, ((WinterCompetition) competition).getDiscipline());
                    compType = "Snowboard";
                }
                else
                    competitor= new Snowboarder(name,age,((WinterCompetition)competition).getGender(),acceleration,maxSpeed,((WinterCompetition)competition).getDiscipline());
                competition.addCompetitor(competitor);
                //print details of the arena.
                System.out.println(competitor);





                //(name, age , ((WinterCompetition)competition).getGender() , acceleration , maxSpeed)
                String stringGender = ((SidePanel) sidePanel).getGender().getSelectedItem().toString();

                ((ArenaPanel) arenaPanel).getCompetitors().add(new DrawableObjcet( compType+stringGender,competitor,((ArenaPanel)arenaPanel)));

                revalidate();
                repaint();
            }
        });
        /**
         * *********************************************
         * Start Competition Button -  action listener *
         * *********************************************
         */
        ((SidePanel) sidePanel).getStartCompetition().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * start comtetition.
                 */
                GameEngine.getInstance().setCompetition(competition);
                new Thread((ArenaPanel)arenaPanel).start();
                new Thread(GameEngine.getInstance()).start();

            }
        });

        /**
         * *************************************
         * Show info Button -  action listener *
         * *************************************
         */
        ((SidePanel) sidePanel).getShowInfo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(competition.getActiveCompetitors().size() + competition.getFinishedCompetitors().size() > 0){
                    Vector<String> columnNames = new Vector<>();
                    columnNames.add("Name");
                    columnNames.add("Speed");
                    columnNames.add("Max Speed");
                    columnNames.add("Location");
                    columnNames.add("Finished");
                    Vector<Object> data = new Vector<>();
                    for (Object competitor : competition.getFinishedCompetitors()){
                        try {
                            Vector<String> dataOfCompetitor =new Vector<>();
                            dataOfCompetitor.add(((Sportsman)competitor).getName() );
                            dataOfCompetitor.add(((Sportsman)competitor).getSpeed()+"");
                            dataOfCompetitor.add(((Sportsman)competitor).getMaxSpeed()+"");
                            dataOfCompetitor.add(((Sportsman)competitor).getLocation()+"");
                            dataOfCompetitor.add("YES");
                            data.add(dataOfCompetitor);
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }

                    }

                    for (Competitor competitor : competition.getActiveCompetitors()){
                        try {
                            Vector<String> dataOfCompetitor =new Vector<>();
                            dataOfCompetitor.add(((Sportsman)competitor).getName() );
                            dataOfCompetitor.add(((Sportsman)competitor).getSpeed()+"");
                            dataOfCompetitor.add(((Sportsman)competitor).getMaxSpeed()+"");
                            dataOfCompetitor.add(((Sportsman)competitor).getLocation()+"");
                            dataOfCompetitor.add("NO");                            data.add(dataOfCompetitor);
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }

                    }
                    JFrame frame = new JFrame();
                    JTable infoTable = new JTable(data,columnNames);
                    JScrollPane scrollPane = new JScrollPane(infoTable);
                    scrollPane.setViewportView(infoTable);
                    scrollPane.setVisible(true);
                    frame.add(scrollPane);
                    frame.pack();
                    frame.setVisible(true);


                }


            }
        });

    }






}
