package ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class MainScreen extends JFrame{
    public MainScreen()
    {
        setSize(1000,700);
        GridLayout main = new GridLayout(1, 2);
        this.setTitle("Competition");
        JPanel arenaPanel = new ArenaPanel("Sunny.jpg");
        JPanel sidePanel = new SidePanel();
        this.setLayout(main);
        this.getContentPane().add(sidePanel);
        this.getContentPane().add(arenaPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // this.pack();
    }
    private ArenaPanel arenaPanel;
    private SidePanel sidePanel;


}
