package ui;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ArenaPanel extends JPanel {

    private BufferedImage image;
    private int width;
    private int height;



    public ArenaPanel(String arenaName) {
        try {
            setImage(arenaName, 700);
        }
        catch (ValueException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            g.drawImage(image, 0, 0, width, height,this);
        }
    }

    public BufferedImage getImage() {
        return image;
    }



    public void setImage (String arenaName, int length) throws ValueException{
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
        }
        catch (IOException e) {
        e.printStackTrace();
    }
    }
}
