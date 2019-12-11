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
import java.sql.SQLException;

class MenuClient extends Container{
    public MenuClient(School school){
        JButton b1 = new ButtonStyle("Courses' List");b1.setLocation(300,50);add(b1);
        JButton b2 = new ButtonStyle("Enroll to course"); b2.setLocation(300,150);add(b2);
        JButton b3 = new ButtonStyle("Search course");b3.setLocation(300,250);add(b3);
        JButton b4 = new ButtonStyle("My Diary");b4.setLocation(300,350);add(b4);
        JButton b5 = new ButtonStyle("Log out");b5.setLocation(300, 450);add(b5);
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    school.getGetcourse().getCourse(school);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
         b2.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 school.switchFrame(school.getEnr_toCourse(), school.getClient());
                 try {
                     school.getGetcourse().getCourse(school);
                 } catch (SQLException e1) {
                     e1.printStackTrace();
                 }
             }
         });
         b3.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 school.switchFrame(school.getLook_for(), school.getClient());
             }
         });
         b4.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     school.checkDiary();
                 } catch (SQLException e1) {
                     e1.printStackTrace();
                 }
             }
         });
         b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdmin_client(), school.getClient());
                school.getReg().setLog(null);
                school.getSignInClient().setLog(null);
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(800, 600);
        }
    }
    

