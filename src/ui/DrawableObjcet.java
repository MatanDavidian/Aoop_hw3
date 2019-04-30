package ui;

import game.entities.Entity;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawableObjcet{
    private BufferedImage image;
    private Entity competitor;
    private JPanel myArena;
    private final int size = 40;
    /**
     *Ctor
     * create the competitor GUI object to shown on the screen according his picture.
     * @param imgName the name of the picture according the gender of the competitor and his kind.
     * @param competitor the competitor obj
     * @param myArena the arena that the competition run on.
     */
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

    /**
     * draw the player on the screen according his image and location.
     * @param g the <code>Graphics</code> object to protect
     */
    public void draw(Graphics g){
        g.drawImage(image , (int)competitor.getLocation().getX(),(int)competitor.getLocation().getY() , size ,size , myArena);
    }
    //region Getters & setters
    public Entity getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Entity competitor) {
        this.competitor = competitor;
    }

    public int getSize() {
        return size;
    }
    //end region
}


