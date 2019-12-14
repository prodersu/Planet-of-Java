package school;



import javafx.scene.paint.Color;


import javax.swing.*;
import java.awt.*;


public class ButtonStyle extends JButton {
    public ButtonStyle(String text) {
        super(text);
        setSize(200, 50);
        setBackground(java.awt.Color.decode("#20B2AA"));
        setForeground(java.awt.Color.decode("#FF00FF"));
        Font font = new Font("Serif", Font.PLAIN, 24);

        setFont(font);
    }



}
