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

class LookFor extends Container {
    public LookFor(School school){
        JLabel l = new JLabel("Enter course's title: ");l.setBounds(300,50,200,50);add(l);
        JTextField t = new JTextField();t.setBounds(300, 150, 200, 50);add(t);
        JLabel l2 = new JLabel("");l2.setBounds(300, 350, 200, 50);add(l2);
        JButton b = new ButtonStyle("Find");b.setLocation(300, 250);add(b);
        JButton b2 = new ButtonStyle("Return");b2.setLocation(300,450);add(b2);
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean q = false;
                for (int i = 0; i < school.getCourseSize(); i++) {
                    if(school.getCourse(i).getTitle().equals(t.getText())){
                        l2.setText("Its ID is: " + Integer.toString(i+1));
                        q = true;
                    }
                }
                if(!q) l2.setText("There is no course with that title");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getClient(), school.getLook_for());
            }
        });
        setVisible(false);
        setSize(600,400);
        setLayout(null);
    }
    
}