package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoodRemove extends Container{

    public GoodRemove(Main_content maincontent) {
        JLabel l = new JLabel("Enter good ID:");l.setBounds(10,10,150,30);add(l);
        JTextField t = new JTextField();t.setBounds(200, 10, 200, 30);add(t);
        JButton b = new ButtonStyle("Remove");b.setLocation(50,100);add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.RemGood());
                int i = Integer.parseInt(t.getText());
                maincontent.removeGood(i-1);
                JOptionPane.showMessageDialog(GoodRemove.this, "<html><i>Successfully removed</i>");
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
