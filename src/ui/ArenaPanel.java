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

        try {
            image = ImageIO.read(new File(arenaName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}