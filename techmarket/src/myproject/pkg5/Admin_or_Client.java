package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;

public class Admin_or_Client extends Container {
    public Admin_or_Client(Main_content maincontent){
        JPanel p = new JPanel();p.setLayout(null);
        p.setBorder(new TitledBorder(null,"<html><h3>Welcome to Tech-Shop!!!</h3>"));p.setBounds(5, 100, 570,100);
        JButton a = new ButtonStyle("Admin");a.setLocation(50,140);add(a);
        JButton c = new ButtonStyle("Client");c.setLocation(350,140);add(c);
        JButton e = new ButtonStyle("Exit");e.setLocation(200, 210);add(e);
        add(p);
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getSignIn(), maincontent.getAdm_or_Client());
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.menuClient(), maincontent.getAdm_or_Client());
            }
        });
        e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.dispose();
            }
        });
        
        
        setVisible(true);
        setSize(600,450);
        setLayout(null);

    }
}
