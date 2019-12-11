package school;



import javafx.scene.paint.Color;


import javax.swing.*;



public class ButtonStyle extends JButton {
    public ButtonStyle(String text) {
        super(text);
        setSize(200, 50);
        setBackground(java.awt.Color.getHSBColor(135, 206, 235));
        setForeground(java.awt.Color.getHSBColor(124, 252, 0));
    }



}
