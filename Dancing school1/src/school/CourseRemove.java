/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class CourseRemove extends Container {
    public CourseRemove(School school){
        JLabel l = new JLabel("Enter course's id");
        l.setBounds(150,50,300,100);add(l);
        JTextField t = new JTextField(); 
        t.setBounds(150,200, 300, 100); add(t);
        JButton b = new ButtonStyle("Remove");
        b.setLocation(150, 350); add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdmin(),school.getRem_course());
                int i = Integer.parseInt(t.getText());
                school.getCourses().remove(i-1);
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(800, 600);
               
    }
    
    
    
}
