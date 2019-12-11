/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class LookFor extends Container {
    public LookFor(School school){
        JLabel l = new JLabel("Enter course's title: ");l.setBounds(300,50,200,50);add(l);
        JRadioButton ra = new JRadioButton("adult"); ra.setBounds(300,250,100,50);add(ra);
        JRadioButton rk = new JRadioButton("kids"); rk.setBounds(400,250,100,50);add(rk);
        JTextField t = new JTextField();t.setBounds(300, 150, 200, 50);add(t);
        JButton b = new ButtonStyle("Find");b.setLocation(300, 450);add(b);
        JLabel l2 = new JLabel("");l2.setBounds(300, 350, 200, 50);add(l2);
        JButton b2 = new ButtonStyle("Return");b2.setLocation(300, 550);add(b2);
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                ResultSet rs;
                try {
                    if (ra.isSelected()) {
                        rs = school.get_stmt().executeQuery("select * from adult where title like '" + t.getText() + "'");
                        while (rs.next()) {
                            id = rs.getInt("id");
                        }
                    } else if (rk.isSelected()) {
                        rs = school.get_stmt().executeQuery("select * from kids where title like '" + t.getText() + "'");
                        while (rs.next()) {
                            id = rs.getInt("id");
                        }
                    }
                    if (id > 0) l2.setText("We found your query, it's id: " + id);
                    else l2.setText("There is no course with that title");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                if (id > 0) l2.setText("We found your query, it's id: " + id);
                else l2.setText("There is no course with that title");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getClient(), school.getLook_for());
            }
        });
        setVisible(false);
        setSize(800, 600);
        setLayout(null);
    }
    
}
