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
        p.setBackground(Color.decode("#00BFFF"));
        TitledBorder title = new TitledBorder(null, "Welcome to Dancing School!!!");
        title.setTitleJustification(TitledBorder.CENTER);
        title.setTitleColor(Color.decode("#C71585"));
        Font font = new Font("Playbill", Font.ROMAN_BASELINE, 40);
        title.setTitleFont(font);
        p.setBorder(title);p.setBounds(100, 100, 570, 120);
        JButton a = new ButtonStyle("Admin");a.setLocation(150,150);add(a);
        JButton c = new ButtonStyle("Client");c.setLocation(400,150);add(c);
        JButton r = new ButtonStyle("Register"); r.setLocation(270, 300); add(r);
        JButton e = new ButtonStyle("Exit");e.setLocation(270, 400);add(e);

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
