package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoodList extends Container {
    public GoodList(Main_content maincontent) {
        JButton b = new ButtonStyle("Return");
        b.setLocation(50,50);add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.menuClient(), maincontent.goodList());
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
}
