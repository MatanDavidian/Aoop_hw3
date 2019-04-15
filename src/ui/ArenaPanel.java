package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ArenaPanel extends JPanel {

    private BufferedImage image;



    public ArenaPanel(String arenaName) {
        setImage(arenaName);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(String arenaName) {
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
