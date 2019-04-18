package ui;

import game.competition.Competition;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class ArenaPanel extends JPanel {

    private BufferedImage image;
    private Vector<DrawableObjcet> competitors;
    private int width;
    private int height;



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

                    comp.setXLocation(distacne);
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
        width = 875;
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
}
