package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Income extends Container {
    public Income(Main_content maincontent){
        JButton b = new ButtonStyle("Return");
        b.setLocation(20,20);add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.getIncome());
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
    public void printIncome(Main_content maincontent){
        String inc = "Today we sold : \n";
        int a=0;
        for (int i = 0; i < maincontent.getGoodSize(); i++) {
            inc+= maincontent.getGood(i).getModel()+"\n";
            inc+= maincontent.getGood(i).getPrice()* maincontent.getGood(i).getSold()+ "\n";
            a+= maincontent.getGood(i).getSold()* maincontent.getGood(i).getPrice();
        }
        inc+="All income is "+a;
        JOptionPane.showMessageDialog(Income.this, inc);
    }
}