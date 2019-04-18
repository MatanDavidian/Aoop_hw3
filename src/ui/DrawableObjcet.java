package ui;

import game.competition.Competitor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawableObjcet{

    private BufferedImage image;
    //private Point location;
    private Competitor competitor;
    private JPanel myArena;
    private final int size = 30;

    public DrawableObjcet(String imgName , Competitor competitor , ArenaPanel myArena){
        try {
            this.image = ImageIO.read(new File(imgName+".png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.competitor = competitor;
        this.myArena = myArena;
    }

    public void draw(Graphics g){
        g.drawImage(image , (int)competitor.getLocation().getY(),(int)competitor.getLocation().getX() , size ,size , myArena);
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    public int getSize() {
        return size;
    }
}


