package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawableObjcet{

    private BufferedImage image;
    private Point location;
    private JPanel myArena;
    private final int size = 30;

    public DrawableObjcet(String imgName , Point location , ArenaPanel myArena){
        try {
            this.image = ImageIO.read(new File(imgName+".png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.location = location;
        this.myArena = myArena;
    }

    public void draw(Graphics g){
        g.drawImage(image , (int)location.getX() , (int)location.getY() , size ,size , myArena);
    }

    public void setLocation(int x , int y) {
        this.location = new Point(x,y);
    }

    public void setXLocation(int x) {
        this.location = new Point(x,(int)this.location.getY());
    }

    public void setYLocation(int y) {
        this.location = new Point( (int) this.location.getX(),y);
    }

    public int getSize() {
        return size;
    }
}


