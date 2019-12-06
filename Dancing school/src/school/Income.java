/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author 28354
 */
public class Income  extends Container{
    public Income(School school){
    JButton b = new ButtonStyle("Return");
    b.setLocation(300, 100);
    add(b);
    b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdmin(), school.getIncome());
            }
    });
    setVisible(false);
    setLayout(null);
    setSize(800, 600);
    
    }
    public void printIncome(School school){
        String inc = "";
        int a=0;
        for (int i = 0; i < school.getCourseSize(); i++) {
            
            a+= school.getCourse(i).getSold()* school.getCourse(i).getPrice();
        }
        inc+="All income is "+a;
        JOptionPane.showMessageDialog(Income.this, inc);
    }
    
}
