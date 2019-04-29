package ui;

import game.competition.Competitor;
import game.entities.Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import utilities.Point;

public class DrawableObjcet{

    private BufferedImage image;
    //private Point location;
    private Entity competitor;
    private JPanel myArena;
    private final int size = 40;

    public DrawableObjcet(String imgName , Entity competitor , ArenaPanel myArena){
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

    public Entity getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Entity competitor) {
        this.competitor = competitor;
    }

    public int getSize() {
        return size;
    }
}


