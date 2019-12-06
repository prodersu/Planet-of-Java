package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuClient extends Container {
     public MenuClient(Main_content maincontent) {
        JButton b1 = new ButtonStyle("GoodsList");b1.setLocation(150, 10);add(b1);
        JButton b2 = new ButtonStyle("Add to Basket");b2.setLocation(150, 60);add(b2);
        JButton b3 = new ButtonStyle("Price filter");b3.setLocation(150, 110);add(b3);
        JButton b4 = new ButtonStyle("Search Model");b4.setLocation(150, 160);add(b4);
        JButton b5 = new ButtonStyle("Your Basket");b5.setLocation(150, 210);add(b5);
        JButton b6 = new ButtonStyle("Buy goods from Basket");b6.setLocation(150, 260);add(b6);
        JButton b7 = new ButtonStyle("Log out");b7.setLocation(150, 310);add(b7);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.goodList(), maincontent.menuClient());
                maincontent.getGoodList().getGood(maincontent);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.addToBasket(), maincontent.menuClient());
                maincontent.getGoodList().getGood(maincontent);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Good a1;
                Good a2;
                for (int i = 0; i < maincontent.getGoodSize()- 1; i++) {
                    for (int j = i + 1; j < maincontent.getGoodSize(); j++) {
                        if(maincontent.getGood(i).getPrice()> maincontent.getGood(j).getPrice()){
                            a1 = maincontent.getGood(i);
                            a2 = maincontent.getGood(j);
                            maincontent.removeGood(j); maincontent.addGood(j, a1);
                            maincontent.removeGood(i); maincontent.addGood(i, a2);
                        }
                    }
                }
                JOptionPane.showMessageDialog(MenuClient.this, "ALL GOODS WERE FILTERED BY PRICE");
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.LookFor(), maincontent.menuClient());
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.checkBasket();
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = JOptionPane.showConfirmDialog(null, "Are you sure?", "Buy goods from Basket", JOptionPane.OK_CANCEL_OPTION);
                if(k == JOptionPane.OK_OPTION){
                    for (int i = 0; i < maincontent.getBasket().size(); i++) {
                        for (int j = 0; j < maincontent.getGoodSize(); j++) {
                            if(maincontent.getBasket().get(i).equals(maincontent.getGood(j).getModel())){
                                maincontent.getGood(j).setSold(maincontent.getGood(j).getSold() + maincontent.getBasketCount().get(i));
                                break;
                            }
                        }
                    }
                    maincontent.getBasket().clear(); maincontent.getBasketCount().clear();
                    JOptionPane.showMessageDialog(MenuClient.this, "GOOD DEAL");
                }
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getAdm_or_Client(), maincontent.menuClient());
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(600,400);

    }
}
