package utilities;
import ui.MainScreen;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Created by Matan & Tom on 15-Apr-19.
 * the driver to run the program
 * Create a object of MainScreen class(call to his constructor)
 */
public class Program {

    public static void main(String[] args) {
            MainScreen frame = new MainScreen();
            frame.setVisible(true);
            //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
