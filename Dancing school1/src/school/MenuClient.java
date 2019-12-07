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
class MenuClient extends Container{
    public MenuClient(School school){
        JButton b1 = new ButtonStyle("Courses' List");b1.setLocation(300,50);add(b1);
        JButton b2 = new ButtonStyle("Add to Diary"); b2.setLocation(300,150);add(b2);
        JButton b3 = new ButtonStyle("Search course");b3.setLocation(300,250);add(b3);
        JButton b4 = new ButtonStyle("My Diary");b4.setLocation(300,350);add(b4);
        JButton b5 = new ButtonStyle("Pay for course");b5.setLocation(300,450);add(b5);
        JButton b6 = new ButtonStyle("Log out");b6.setLocation(300,550);add(b6);
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                school.getGetcourse().getCourse(school);
            }
        });
         b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getEnr_toCourse(), school.getClient());
                school.getGetcourse().getCourse(school);
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
                school.checkDiary();
            }
        });
         b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = JOptionPane.showConfirmDialog(null, "Are you sure?", "Buy goods from Basket", JOptionPane.OK_CANCEL_OPTION);
                if(k == JOptionPane.OK_OPTION){
                    for (int i = 0; i < school.getDiary().size(); i++) {
                        for (int j = 0; j < school.getCourseSize(); j++) {
                            if(school.getDiary().get(i).equals(school.getCourse(j).getTitle())){
                                school.getCourse(j).setSold(school.getCourse(j).getSold());
                                break;
                            }
                        }
                    }
                   school.getDiary().clear(); 
                    JOptionPane.showMessageDialog(MenuClient.this, "GOOD LUCK");
                }
            }
        });
         b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(800,600);
        }
    }
    

