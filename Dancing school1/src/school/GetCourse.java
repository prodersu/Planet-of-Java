
package school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

class GetCourse extends Container {
    public GetCourse(School school) throws SQLException{
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
        l2.setBounds(50,260,200,50);f.add(l2);

        JButton c = new ButtonStyle("cancel");
        JButton r = new ButtonStyle("Refresh");
        r.setLocation(350, 0); f.add(r);
        String Courses = "";        
        ResultSet rs;
        ResultSet rs1;
        rs = school.get_stmt().executeQuery("select * from adult");
        while (rs.next()) {
            Courses = rs.getInt("id") + ". " +rs.getString("title") + " (" + rs.getString("style") + ") master: "+rs.getString("master")+
                    " on " + rs.getString("schedule") + " price: " + rs.getInt("price") + " for "+  rs.getString("gender") + " in "+  rs.getString("indiv_group");
            lm1.addElement(Courses);
        }      

        rs1 = school.get_stmt().executeQuery("select * from kids");
        while (rs1.next()) {
            Courses = rs1.getInt("id") + ". " +rs1.getString("title") + " master: "+rs1.getString("master")+
                    " on " + rs1.getString("schedule") +" price: "
                    + rs1.getInt("price") + ", age: "+  rs1.getString("age") + " tours: "+  rs1.getString("tour");
            lm2.addElement(Courses);
        }

        JList s1 = new JList(lm1); s1.setBounds(50,50,680,200);
        Font font = new Font("Segoe print", Font.PLAIN, 14);
        s1.setFont(font);
        JList s2 = new JList(lm2); s2.setBounds(50, 320, 680,200);
        s2.setFont(font);
        f.add(s1);
        f.add(s2);
        f.add(c);
        f.setLocation(500,200);
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(800, 600);

        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    f.dispose();
                    getCourse(school);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });



            }
    
    
}
