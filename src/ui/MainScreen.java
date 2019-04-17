package ui;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import sun.awt.SunHints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BrokenBarrierException;

public class MainScreen extends JFrame{
    public MainScreen() throws Exception {
        setSize(1000,700);
        this.setTitle("Competition");
        JPanel arenaPanel = new ArenaPanel("None");
        JPanel sidePanel = new SidePanel();
        this.add(arenaPanel, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ((SidePanel) sidePanel).buildArena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("action!");
                String arenaName = ((SidePanel) sidePanel).getWeatherCondition().getSelectedItem().toString() + ".jpg";
                String arenaLengthString = ((SidePanel) sidePanel).getArenaLenght().getText().toString();
                int arenaLength = Integer.parseInt(arenaLengthString);
                System.out.println(arenaLength);
                try {
                    ((ArenaPanel) arenaPanel).setImage(arenaName , arenaLength);
                }
                catch (ValueException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                }
                repaint();
            }
        });

    }
       // this.pack();
    private ArenaPanel arenaPanel;
    private SidePanel sidePanel;


}
