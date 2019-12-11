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
import java.sql.*;

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
        String inc = "Income from Adult-courses: ";
        int a=0;
        int k =0;

        try {
            ResultSet rs;
            rs = school.get_stmt().executeQuery("select * from adult where id>0");
            while (rs.next()){
                a+= rs.getInt("price")*rs.getInt("sold");
            }
            inc += a + "\n Income from Kids-courses: ";
            rs = school.get_stmt().executeQuery("select * from kids where id>0");
            while (rs.next()){
                k+= rs.getInt("price")*rs.getInt("sold");
            }
            int i = a + k;
            inc+= k+ "\n All income is: " + i;

            JOptionPane.showMessageDialog(Income.this, inc);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
    
}
