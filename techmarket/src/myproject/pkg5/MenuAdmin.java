package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuAdmin extends Container {
    private Main_content maincontent = null;

    public MenuAdmin(Main_content maincontent) {
        this.maincontent = maincontent;
        
        JButton b1 = new ButtonStyle("Add  new good");b1.setLocation(150, 10);add(b1);
        JButton b2 = new ButtonStyle("Add count of good");b2.setLocation(150, 60);add(b2);
        JButton b3 = new ButtonStyle("Remove Good");b3.setLocation(150, 110);add(b3);
        JButton b4 = new ButtonStyle("Income");b4.setLocation(150, 160);add(b4);
        JButton b5 = new ButtonStyle("Log out");b5.setLocation(150, 210);add(b5);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getAdd(), maincontent.getAdminMenu());
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getAddCount(), maincontent.getAdminMenu());
                maincontent.getAddCount().showGoodLst(maincontent);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.RemGood(), maincontent.getAdminMenu());
                maincontent.RemGood().showGoodLst(maincontent);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getIncome(), maincontent.getAdminMenu());
                maincontent.getIncome().printIncome(maincontent);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getSignIn(), maincontent.getAdminMenu());
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
    
}
