package ui;

import game.competition.Competition;
import game.competition.WinterCompetition;
import game.entities.Entity;
import game.entities.sportsman.WinterSportsman;
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

public class ArenaPanel extends JPanel implements Runnable {

    private BufferedImage image;
    private Vector<DrawableObjcet> competitors;
    private int width;
    private int height;
    private Competition competition;

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public ArenaPanel(String arenaName) {
        competitors = new Vector<>();
        setImage(arenaName , 700);
    }


    public Vector<DrawableObjcet> getCompetitors() {
        return competitors;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            g.drawImage(image, 0, 0, width, height, this);
            if (competitors.size()> 0) {

                int distacne = 0;

                for (DrawableObjcet comp : competitors) {
                    Entity dis =  ((Entity)comp.getCompetitor());
                    dis.setLocation(new Point((int)dis.getLocation().getX(),distacne));
                    distacne += comp.getSize() + 10;
                    comp.draw(g);
            }

            }
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void  setImage(String arenaName, int length){
        if (length <700 || length >900){
            throw new ValueException("Invalid input values! Please try again");
        }
        height = length;
        width = 1000;
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

}
