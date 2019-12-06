package myproject.pkg5;

import javax.swing.*;
import java.awt.*;

public class Good_get_list extends Container {
    public Good_get_list(Main_content maincontent) {
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
    
    public void getGood(Main_content maincontent){
        if(maincontent.getGoodSize()==0) {
        JOptionPane.showMessageDialog(Good_get_list.this, "There aren't any goods in maincontent..");
        }
        else {
            String Goods = "There are ";
            Goods += maincontent.getGoodSize() + "goods in the maincontent\n";
            for (int i = 0; i < maincontent.getGoodSize(); i++) {
                Goods += (i + 1) + maincontent.getGood(i).showDetails() + "\n";
            }
            JOptionPane.showMessageDialog(Good_get_list.this, Goods);
        }
    }
}
