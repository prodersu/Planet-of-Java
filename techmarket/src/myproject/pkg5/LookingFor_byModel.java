package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookingFor_byModel extends Container {
    public LookingFor_byModel(Main_content maincontent) {
        JLabel l = new JLabel("Enter good Model:");l.setBounds(10,10,150,30);add(l);
        JTextField t = new JTextField();t.setBounds(200, 10, 200, 30);add(t);
        JLabel l2 = new JLabel("");l2.setBounds(420, 10, 200, 30);add(l2);
        JButton b = new ButtonStyle("Find");b.setLocation(50, 100);add(b);
        JButton b2 = new ButtonStyle("Return");b2.setLocation(50,150);add(b2);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean q = false;
                for (int i = 0; i < maincontent.getGoodSize(); i++) {
                    if(maincontent.getGood(i).getModel().equals(t.getText())){
                        l2.setText("Its ID is: " + Integer.toString(i+1));
                        q = true;
                    }
                }
                if(!q) l2.setText("There is no good with that model");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.menuClient(), maincontent.LookFor());
            }
        });
        setVisible(false);
        setSize(600,400);
        setLayout(null);
    }
}
