package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ButtonStyle extends JButton {

    public ButtonStyle(String text) {
        super(text);
        setSize(200, 40);
        setBorder(new LineBorder(Color.BLUE));
    }
    
}
