/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;


class CourseRemove extends Container {
    public CourseRemove(School school){
        JLabel l = new JLabel("Enter course's id");
        l.setBounds(250,50,300,100);add(l);
        JTextField t = new JTextField(); 
        t.setBounds(250, 200, 300, 100); add(t);
        JRadioButton ra = new JRadioButton("adult"); ra.setBounds(250, 350, 50, 50); add(ra);
        JRadioButton rk = new JRadioButton("kids"); rk.setBounds(350, 350, 50, 50); add(rk);
        JButton b = new ButtonStyle("Remove");
        b.setLocation(250, 450); add(b);

        JButton c = new ButtonStyle("CANCEL");
        c.setLocation(250, 530);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdmin(), school.getRem_course());
                int i = Integer.parseInt(t.getText());

                try {
                    if (ra.isSelected()) {
                        PreparedStatement stmt = school.get_con().prepareStatement("DELETE * FROM adult WHERE  id = '" + i + "'");
                    } else if (rk.isSelected()) {
                        PreparedStatement stmt = school.get_con().prepareStatement("DELETE * FROM kids WHERE  id = '" + i + "'");
                    }
                    JOptionPane.showMessageDialog(CourseRemove.this, "The course is removed successfully");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdmin(), school.getRem_course());
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(800, 600);
               
    }
    
    
    
}
