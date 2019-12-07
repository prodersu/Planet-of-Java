package school;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuAdmin extends Container {
    private School school = null;
    
    public MenuAdmin(School school){
        this.school = school;
        
        JButton b1 = new JButton("Add new course"); b1.setBounds(300, 50, 200, 50); add(b1);  
        JButton b2 = new JButton("Courses' List"); b2.setBounds(300, 150,200, 50); add(b2);
        JButton b3 = new JButton("Remove course"); b3.setBounds(300, 250, 200, 50); add(b3);
        JButton b4 = new JButton("Income"); b4.setBounds(300, 350, 200, 50); add(b4);
        JButton b5 = new JButton("Log out"); b5.setBounds(300, 450, 200, 50); add(b5);
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdmin_add(), school.getAdmin());
            }
        });        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.getGetcourse().getCourse(school);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getRem_course(), school.getAdmin());                
            }
        });
        
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getIncome(), school.getAdmin());                
            }
        });
        
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getSignIn(), school.getAdmin());                
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(800,600);
    }
    
}
