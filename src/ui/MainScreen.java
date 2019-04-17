package ui;
import game.arena.WinterArena;
import game.competition.Competition;
import game.competition.Competitor;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import sun.awt.SunHints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BrokenBarrierException;

public class MainScreen extends JFrame{
    private Competition competition;
    private WinterArena arena;

    public MainScreen() throws Exception {
        setSize(1000,700);
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

                //print details of the arena.
                System.out.println(arena);

                //painting the canvas.
                revalidate();
                repaint();
            }
        });



    }
    private ArenaPanel arenaPanel;
    private SidePanel sidePanel;


}
