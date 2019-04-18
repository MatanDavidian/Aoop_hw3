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
    private BufferedImage playerImage;
    private int width;
    private int height;
    private final int playerHeight = 20;
    private  final int playerWidth = 20;

    public ArenaPanel(String arenaName) {
        setImage(arenaName , 700);
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
    public void  setPlayerImage(String playerType){
        height = 30;
        width = 30;
        try{
            image = ImageIO.read(new File(playerType));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void  addPlayer() {
        //JLabel Player = new JLabel();
        //Player.setPreferredSize(new Dimension(30,30));
        this.add(new JLabel("Player 1"));
    }

}
