package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCount extends Container {
    public AddCount(Main_content maincontent) {
        JLabel l = new JLabel("Enter good ID:");l.setBounds(10,10,150,30);add(l);
        JLabel l1 = new JLabel("Enter good count:");l1.setBounds(10,50,150,30);add(l1);
        JTextField t = new JTextField();t.setBounds(200, 10, 200, 30);add(t);
        JTextField t1 = new JTextField();t1.setBounds(200, 50, 200, 30);add(t1);
        JButton cancel = new ButtonStyle("Return"); cancel.setLocation(350, 100); add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.getAddCount());
            }
        });
        JButton b = new ButtonStyle("ADD");b.setLocation(100,100);add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.getAddCount());
                int i = Integer.parseInt(t.getText());
                int x = Integer.parseInt(t1.getText());
                maincontent.getGood(i-1).setCount(x + maincontent.getGood(i-1).getCount());
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
    public void showGoodLst(Main_content maincontent){
        maincontent.getGoodList().getGood(maincontent);
    }
}
