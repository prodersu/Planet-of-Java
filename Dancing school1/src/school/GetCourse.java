
package school;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

class GetCourse extends Container {
    public GetCourse (School school) throws SQLException{
    setVisible(false);
    setLayout(null);
    setSize(800, 600);    
    }
    public void getCourse(School school) throws SQLException {
        JFrame f = new JFrame("List");
        DefaultListModel lm1 = new DefaultListModel();
        DefaultListModel lm2 = new DefaultListModel();    
        JLabel l1 = new JLabelStyle("Adult Courses");
        l1.setBounds(50,0,200,50);f.add(l1);
        JLabel l2 = new JLabelStyle("Kid's Courses");
        l2.setBounds(50,210,200,50);f.add(l2);
        
        JButton c = new ButtonStyle("Cancel");
        c.setLocation(300, 470);f.add(c);
        String Courses = "";        
        ResultSet rs;
        rs = school.get_stmt().executeQuery("select * from adult");
        while (rs.next()) {
            Courses = rs.getInt("id") + ". " +rs.getString("title") + " " + rs.getString("style") + " master: "+rs.getString("master")+
                    " on " + rs.getString("schedule");
            lm1.addElement(Courses);
            Courses = "price: " + rs.getInt("price") + " for "+  rs.getString("gender") + " in "+  rs.getString("indiv_group");
            lm1.addElement(Courses);
        }      
        
        rs = school.get_stmt().executeQuery("select * from kids");
        while (rs.next()) {
            Courses = rs.getInt("id") + ". " +rs.getString("title") + " master: "+rs.getString("master")+
                    " on " + rs.getString("schedule") + " price: "
                    + rs.getInt("price") + ", age: "+  rs.getString("age") + " tours: "+  rs.getString("tour");
            lm2.addElement(Courses);
        }
        
        JList s1 = new JList(lm1); s1.setBounds(50,50,650,150);
        Font font = new Font("Segoe print", Font.PLAIN, 16);
        s1.setFont(font);
        f.add(s1);
        JList s2 = new JList(lm2); s2.setBounds(50, 270, 650,150);        
        s2.setFont(font);
        f.add(s2);
        ImageIcon img = new ImageIcon("D:\\image3.jpg");
        JLabel l6 = new JLabel("", img, JLabel.CENTER);
        l6.setBounds(0, 0, 800, 600);               
        f.setLocation(500,200);
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(800, 600);
        
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }

            
        });

            }
    
    
}
