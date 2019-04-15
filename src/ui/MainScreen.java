package ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame{
    public MainScreen()
    {
        setSize(1000,700);
        GridLayout main = new GridLayout(1, 2);
        this.setTitle("Competition");
        JPanel arenaPanel = new ArenaPanel("None");
        JPanel sidePanel = new SidePanel();
        this.setLayout(main);
        this.getContentPane().add(arenaPanel);
        this.getContentPane().add(sidePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ((SidePanel) sidePanel).buildArena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("action!");
                ((ArenaPanel) arenaPanel).setImage(((SidePanel) sidePanel).getWeatherCondition().getSelectedItem().toString()+".jpg");
                repaint();
            }
        });
       // this.pack();
    }
    private ArenaPanel arenaPanel;
    private SidePanel sidePanel;


}
