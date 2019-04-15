package ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class MainScreen extends JFrame{
    public MainScreen()
    {
        setSize(1000,700);
        GridLayout main = new GridLayout(0, 2);
        this.setTitle("Competition");
        JPanel arenaPic = new ArenaPanel("Sunny.jpg");
        JPanel panel = new SidePanel();
        this.setLayout(main);
        this.getContentPane().add(arenaPic, BorderLayout.WEST);
        this.getContentPane().add(panel, BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // this.pack();
    }
    private ArenaPanel arenaPanel;
    private SidePanel sidePanel;






}
