
package school;

import java.awt.*;
import javax.swing.*;

public class JLabelStyle extends JLabel {
    public JLabelStyle(String text) {
        super(text);      
        setForeground(java.awt.Color.decode("#4169E1"));
        Font font = new Font("Comic sans ms", Font.PLAIN, 20);

        setFont(font);
    }
    
}
