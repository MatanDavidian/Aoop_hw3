package ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BrokenBarrierException;

public class MainScreen extends JFrame{
    public MainScreen()
    {
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
                String arenaName = ((SidePanel) sidePanel).getWeatherCondition().getSelectedItem().toString()+".jpg";
                String arenaLengthString = ((SidePanel) sidePanel).getArenaLenght().getText().toString();
                int arenaLength = Integer.parseInt(arenaLengthString);
                System.out.println(arenaLength);
                ((ArenaPanel) arenaPanel).setImage( arenaName ,  arenaLength );
                repaint();
            }
        });
       // this.pack();
    }
    private ArenaPanel arenaPanel;
    private SidePanel sidePanel;


}
