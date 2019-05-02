package ui;
import game.GameEngine;
import game.arena.WinterArena;
import game.competition.*;
import game.entities.sportsman.Sportsman;
import game.entities.sportsman.WinterSportsman;
import game.enums.*;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

public class MainScreen extends JFrame{
    private Competition competition;
    private WinterArena arena;
    private String compType;
    private String gender;
    private int widthSize=1175;
    private int heightSize=700;
    private static String stage="build arena";
    private static String cType;
    /**
     *Ctor
     * set the size of the windows
     * contain two panels, the arena panel and the size panel
     * listen to action that make on the side panel and execute the action on arena panel.
     * @see ArenaPanel
     * @see SidePanel
     */
    public MainScreen()
    {
        setSize(widthSize,heightSize);
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
         * read the input from the side panel and build the arena according to them.
         */
        ((SidePanel) sidePanel).buildArena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * setting the arena.
                 */
                boolean RightArenaLen=true;
                if(stage.equals("build arena") || stage.equals("create competition"))
                {
                    String arenaName = ((SidePanel) sidePanel).getWeatherCondition().getSelectedItem().toString() + ".jpg";
                    String arenaLengthString = ((SidePanel) sidePanel).getArenaLenght().getText().toString();
                    String arenaSnowSurface = ((SidePanel) sidePanel).getSnowSurface().getSelectedItem().toString().toUpperCase();
                    String arenaWeatherCondition = ((SidePanel) sidePanel).getWeatherCondition().getSelectedItem().toString().toUpperCase();
                    int arenaLength = 0;
                    /**
                     * if arenaLengthString is not int , the value of arenaLength will be 700.
                     */
                    try {
                        arenaLength = Integer.parseInt(arenaLengthString);
                        if(arenaLength<700 || arenaLength>900) {
                            JOptionPane.showMessageDialog(null, "You must input int between 700-900");
                            RightArenaLen=false;
                        }
                    }
                    catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "You must input int between 700-900");
                        RightArenaLen=false;
                    }
                    //set image according to name and length.
                    if(RightArenaLen==true) {
                        ((ArenaPanel) arenaPanel).setImage(arenaName, arenaLength);
                        if (competition == null || competition.getActiveCompetitors().size() == 0) {
                            // adding the arena details to competition
                            arena = new WinterArena(arenaLength, SnowSurface.valueOf(arenaSnowSurface), WeatherCondition.valueOf(arenaWeatherCondition));
                            heightSize = arenaLength + 80;
                            setSize(1175, heightSize);

                            //print details of the arena.
                            //System.out.println(arena);

                            //painting the canvas.
                            ((ArenaPanel) arenaPanel).setCompetition(null);
                            ((ArenaPanel) arenaPanel).getCompetitors().removeAllElements();
                            revalidate();
                            repaint();
                            stage = "create competition";
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Right now you need to "+stage);
                }

            }
        });
        /**
         * **********************************************
         * Create Competition Button -  action listener *
         * **********************************************
         * read the input from the side panel and create Competition according to them.
         */
        ((SidePanel) sidePanel).createCompetition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * setting the Competition id necessary .
                 */
                if(((ArenaPanel) arenaPanel).getCompetition()!=null || stage.equals("create competition")) {
                    String competitionType = ((SidePanel) sidePanel).getChooseCompetition().getSelectedItem().toString() + "Competition";
                    cType=competitionType;
                    String stringMaxCompetitorsNumber = ((SidePanel) sidePanel).getMaxCompetitorsNumber().getText();
                    int maxCompetitorsNumber;
                    try {
                        maxCompetitorsNumber = Integer.parseInt(stringMaxCompetitorsNumber);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error! enter a number at max competitors number, set by default to 10..");
                        System.out.println("Error! enter a number at max competitors number, set by default to 10.");
                        maxCompetitorsNumber = 10;
                    }

                    String stringDiscipline = ((SidePanel) sidePanel).getDiscipline().getSelectedItem().toString();
                    Discipline discipline;
                    if (stringDiscipline == "Slalom")
                        discipline = Discipline.SLALOM;
                    else if (stringDiscipline == "Giant Slalom")
                        discipline = Discipline.GIANT_SLALOM;
                    else if (stringDiscipline == "Downhill")
                        discipline = Discipline.DOWNHILL;
                    else if (stringDiscipline == "Freestyle")
                        discipline = Discipline.FREESTYLE;
                    else
                        discipline = Discipline.FREESTYLE;
                    String stringLeague = ((SidePanel) sidePanel).getLeague().getSelectedItem().toString();
                    League league;
                    if (stringLeague == "Junior")
                        league = League.JUNIOR;
                    else if (stringLeague == "Adult")
                        league = League.ADULT;
                    else if (stringLeague == "Senior")
                        league = League.SENIOR;
                    else
                        league = League.JUNIOR;
                    String stringGender = ((SidePanel) sidePanel).getGender().getSelectedItem().toString();
                    Gender gender;
                    if (stringGender == "Male")
                        gender = Gender.MALE;
                    else if (stringGender == "Female")
                        gender = Gender.FEMALE;
                    else
                        gender = Gender.MALE;

                    Class c;
                    ClassLoader cl = ClassLoader.getSystemClassLoader();
                    try {

                        c = cl.loadClass("game.competition." + competitionType);
                        Constructor con = c.getConstructor(WinterArena.class, int.class, Discipline.class, League.class, Gender.class);
                        competition = new WinterCompetition((WinterCompetition) con.newInstance(arena, maxCompetitorsNumber, discipline, league, gender));

                    } catch (InstantiationException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        ex.printStackTrace();
                    } catch (InvocationTargetException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        ex.printStackTrace();
                    } catch (NoSuchMethodException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        ex.printStackTrace();
                    } catch (IllegalAccessException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        ex.printStackTrace();
                    }
                    ((ArenaPanel) (arenaPanel)).setCompetition(competition);
                    ((ArenaPanel) arenaPanel).getCompetitors().removeAllElements();
                    //increase the arena width
                    if(maxCompetitorsNumber*50>((ArenaPanel) arenaPanel).getWidth()) {
                        ((ArenaPanel) arenaPanel).setWidth(maxCompetitorsNumber*50);
                        ((ArenaPanel)arenaPanel).revalidate();
                        ((ArenaPanel)arenaPanel).repaint();
                        pack();
                        widthSize=(maxCompetitorsNumber*50)+175;
                        setSize(widthSize,heightSize);
                    }
                    revalidate();
                    repaint();
                    //print details of the arena.
                    //System.out.println(competition);
                    stage="add competitors";
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Right now you need to "+stage);
                }
            }
        });


        /**
         * **************************************
         * Add Competitor Button -  action listener *
         * **************************************
         * read the input from the side panel and add competitor according to them.
         */
        ((SidePanel) sidePanel).getAddCompetitor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * setting the competitor.
                 */
                boolean RightAge=true;
                boolean RightMaxSpeed=true;
                boolean RightAcc=true;
                if(stage.equals("add competitors") || stage.equals("start competition")) {
                    String name = ((SidePanel) sidePanel).getNameFromTxtBox().getText();
                    String stringAge = ((SidePanel) sidePanel).getAge().getText();
                    int age;
                    try {
                        age = Integer.parseInt(stringAge);
                    } catch (NumberFormatException ex) {
                        age=1;
                        JOptionPane.showMessageDialog(null, "Invalid age input(has to be integer)");
                        RightAge=false;
                    }
                    String stringMaxSpeed = ((SidePanel) sidePanel).getMaxSpeed().getText();
                    int maxSpeed;
                    try {
                        maxSpeed = Integer.parseInt(stringMaxSpeed);
                    } catch (NumberFormatException ex) {
                        maxSpeed=1;
                        JOptionPane.showMessageDialog(null, "Invalid max speed input(has to be integer)");
                        RightMaxSpeed=false;
                    }
                    String stringAcceleration = ((SidePanel) sidePanel).getAcceleration().getText();
                    int acceleration;
                    try {
                        acceleration = Integer.parseInt(stringAcceleration);
                    } catch (NumberFormatException ex) {
                        acceleration=1;
                        JOptionPane.showMessageDialog(null, "Invalid acceleration input(has to be integer)");
                        RightAcc=false;
                    }
                    //if the inputs are valid add the competitor.
                    if(RightAcc && RightAge && RightMaxSpeed) {
                        // adding the arena details to competition
                        WinterSportsman competitor;
                        gender = ((WinterCompetition) competition).getGender().toString();
                        compType = "";
                        String competitorType = "";
                        String competitionType = cType;
                        if (competitionType.equals("SkiCompetition")) {
                            competitorType = "Skier";
                            compType = "Ski";
                        } else {
                            competitorType = "Snowboarder";
                            compType = "Snowboard";
                        }
                        Class c;
                        ClassLoader cl = ClassLoader.getSystemClassLoader();
                        try {

                            c = cl.loadClass("game.entities.sportsman." + competitorType);
                            Constructor con = c.getConstructor(String.class, double.class, Gender.class, double.class, double.class, Discipline.class);
                            competitor = (WinterSportsman) con.newInstance(name, age, ((WinterCompetition) competition).getGender(), acceleration, maxSpeed, ((WinterCompetition) competition).getDiscipline());

                            competition.addCompetitor(competitor);
                            ////print details of the competitor.
                            //System.out.println(competitor);
                            String stringGender = ((WinterCompetition) competition).getGender().toString();
                            if (stringGender.equals("MALE"))
                                stringGender = "Male";
                            else
                                stringGender = "Female";
                            ((ArenaPanel) arenaPanel).getCompetitors().add(new DrawableObjcet(compType + stringGender, competitor, ((ArenaPanel) arenaPanel)));
                            revalidate();
                            repaint();
                        } catch (IllegalThreadStateException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        } catch (IllegalArgumentException invalidComp) {
                            System.out.println(invalidComp.getMessage());
                            JOptionPane.showMessageDialog(null, invalidComp.getMessage());
                        } catch (IllegalStateException maxComp) {
                            System.out.println(maxComp.getMessage());
                            JOptionPane.showMessageDialog(null, maxComp.getMessage());
                        } catch (InstantiationException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            ex.printStackTrace();
                        } catch (InvocationTargetException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            ex.printStackTrace();
                        } catch (NoSuchMethodException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            ex.printStackTrace();
                        } catch (IllegalAccessException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            ex.printStackTrace();
                        }
                        stage = "start competition";
                    }
                }
                else
                {
                    if(competition!=null && competition.getActiveCompetitors().size()>0)
                        JOptionPane.showMessageDialog(null, "The competition already started.");
                    else
                        JOptionPane.showMessageDialog(null, "Right now you need to "+stage);
                }
            }
        });
        /**
         * *********************************************
         * Start Competition Button -  action listener *
         * *********************************************
         * read the input from the side panel and start competition according to them.
         */
        ((SidePanel) sidePanel).getStartCompetition().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * start competition.
                 */
                if (stage.equals("start competition")) {
                    Thread T = new Thread(((ArenaPanel) arenaPanel));
                    GameEngine.getInstance().setCompetition(competition);
                    try {
                        T.start();
                        GameEngine.getInstance().startRace(competition);
                    } catch (Exception e1) {
                        T.stop();
                        e1.printStackTrace();
                    }

                    stage="build arena";
                } else {
                    JOptionPane.showMessageDialog(null, "Right now you need to " + stage);
                }
            }
        });

        /**
         * *************************************
         * Show info Button -  action listener *
         * *************************************
         * build a table and present the competitors details on the table.
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
                            dataOfCompetitor.add("NO");
                            data.add(dataOfCompetitor);
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
