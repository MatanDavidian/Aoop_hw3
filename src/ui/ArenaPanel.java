package ui;
import game.competition.Competition;
import game.entities.Entity;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import utilities.Point;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import static java.lang.Thread.sleep;

/**
 * Created by Matan & Tom on 15-Apr-19.
 */
public class ArenaPanel extends JPanel implements Runnable {
    private BufferedImage image;
    private Vector<DrawableObjcet> competitors;
    private int width=1000;
    private int height;
    private Competition competition;
    /**
     *Ctor
     * create Vector of object of DrawableObjcet class to paint the competitors on the screen.
     * @param arenaName the name of the arena by string to change the background image.
     */
    public ArenaPanel(String arenaName) {
        competitors = new Vector<>();
        setImage(arenaName , 700);
    }

    /**
     * update the objects on the  screen.
     */
    @Override
    public void run() {
        while(competition.getActiveCompetitors().size()>0) {
            this.repaint();
            this.revalidate();
            try {
                sleep(30);
            } catch (Exception e) {

            }
        }
    }

    /**
     * set all the competitors from the Vector<DrawableObjcet> competitors on the screen according there locations.
     * @param g the <code>Graphics</code> object to protect
     * @see JComponent
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            g.drawImage(image, 0, 0, width, height, this);
            if (competitors.size()> 0) {
                int distance = 0;
                for (DrawableObjcet comp : competitors) {
                    Entity dis =  ((Entity)comp.getCompetitor());
                    dis.setLocation(new Point(distance,(int)dis.getLocation().getY()));
                    distance += comp.getSize() + 10;
                    comp.draw(g);
                }
            }
        }
    }
    //region Getters & setters
    public void setWidth(int width) {
        this.width = width;
    }
    public Competition getCompetition() {
        return competition;
    }
    public void setCompetition(Competition competition) { this.competition = competition; }
    public void  setImage(String arenaName, int length){
        height = length;

        try{
            if (arenaName == "None"){
                image = null;
            }
            else {
                image = ImageIO.read(new File(arenaName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Vector<DrawableObjcet> getCompetitors() {
        return competitors;
    }
    //end region
}
