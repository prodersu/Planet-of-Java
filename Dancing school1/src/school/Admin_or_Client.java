package school;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 28354 on 27.11.2019.
 */
public class Admin_or_Client extends Container {
    public Admin_or_Client(School school){
        JPanel p = new JPanel();p.setLayout(null);
        p.setBorder(new TitledBorder(null, "<html><h2>Welcome to Dancing School!!!</h2>"));p.setBounds(5, 100, 570, 100);
        JButton a = new ButtonStyle("Admin");a.setLocation(50,150);add(a);
        JButton c = new ButtonStyle("Client");c.setLocation(350,150);add(c);
        JButton r = new ButtonStyle("Register"); r.setLocation(200, 300); add(r);
        JButton e = new ButtonStyle("Exit");e.setLocation(200, 400);add(e);

        add(p);

        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getSignIn(), school.getAdmin_client());
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getSignInClient(), school.getAdmin_client());
            }
        });
        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getReg(), school.getAdmin_client());
            }
        });
        e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.dispose();
            }
        });

        setVisible(true);
        setSize(800, 600);
        setLayout(null);
    }
}
