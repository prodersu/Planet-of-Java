package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddToBasket extends Container {
    public AddToBasket(Main_content maincontent, ArrayList<String> cartGood, ArrayList<Integer> cartCount) {
        JLabel l = new JLabel("Enter good ID:");l.setBounds(10,10,150,30);add(l);
        JLabel l1 = new JLabel("Enter good count:");l1.setBounds(10,50,150,30);add(l1);
        JTextField t = new JTextField();t.setBounds(200, 10, 200, 30);add(t);
        JTextField t1 = new JTextField();t1.setBounds(200, 50, 200, 30);add(t1);
        JButton b = new ButtonStyle("Add to CART");b.setLocation(100,100);add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.menuClient(), maincontent.addToBasket());
                int i = Integer.parseInt(t.getText());
                int c = Integer.parseInt(t1.getText());
                cartGood.add(maincontent.getGood(i-1).getModel());
                cartCount.add(c);
            }
        });
        setVisible(false);
        setSize(600,400);
        setLayout(null);
    }
}
