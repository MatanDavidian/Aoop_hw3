package ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class MainScreen extends JFrame{
    public MainScreen()
    {
        this.setTitle("Competition");
        JPanel p1 = new ArenaPanel("Sunny.jpg");
        JPanel p2 = new SidePanel();
        this.setLayout(new BorderLayout());
        this.getContentPane().add(p1, BorderLayout.WEST);
        this.getContentPane().add(p2, BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
    private ArenaPanel arenaPanel;
    private SidePanel sidePanel;






}
