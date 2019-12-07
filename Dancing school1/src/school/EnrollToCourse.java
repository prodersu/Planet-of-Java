/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EnrollToCourse extends Container {
    public EnrollToCourse(School school, ArrayList<String> Diary){
        JLabel l = new JLabel("Enter course ID:");l.setBounds(300,50,200,50);add(l);        
        JTextField t = new JTextField();t.setBounds(300,150, 200, 50);add(t);        
        JButton b = new ButtonStyle("Enroll");b.setLocation(300,250);add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getClient(), school.getEnr_toCourse());                
                int j = Integer.parseInt(t.getText());
                String diary = "";
                for (int i = 0; i<Diary.size(); i++)
                {
                diary+= (i+1) + "." +Diary.get(i) + " ";
                }
                if(diary.contains(school.getCourse(j-1).getSchedule()))
                {
                    JOptionPane.showMessageDialog(EnrollToCourse.this, "You have already one course on " + school.getCourse(j-1).getSchedule());
                }
                else{
                Diary.add(school.getCourse(j-1).getTitle() + " on " + school.getCourse(j-1).getSchedule());
                }
            }
        });
        setVisible(false);
        setSize(600,400);
        setLayout(null);
    }
    
}
