package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TshirtsAdd extends Container {
    private JLabel lmodel = null;
    private JLabel lprice = null;
    private JLabel lcount = null;
    private JLabel lsize = null;
    private JLabel lcolor = null;
    private JLabel lmaterial = null;
    private Good g = null;
    private String material = null;
    private String size = null;
    private ActionListener l;
    private ActionListener l1;
    
    private JTextField tmodel = null;
    private JTextField tprice = null;
    private JTextField tcount = null;
    private JComboBox<String> tmaterial = null;
    private JTextField tcolor = null;
    private JComboBox<String> tsize = null;
    
    public TshirtsAdd(Main_content maincontent) {
        
        lmodel = new JLabel("Enter model:");lmodel.setBounds(10,50,100,30);add(lmodel);
        lprice = new JLabel("Enter price:");lprice.setBounds(10, 100, 100, 30);add(lprice);
        lcount = new JLabel("Enter count:");lcount.setBounds(10, 150, 100, 30);add(lcount);
        lcolor = new JLabel("Enter color:");lcolor.setBounds(300, 50, 100, 30);add(lcolor);
        lmaterial = new JLabel("Enter material:");lmaterial.setBounds(300, 100, 100, 30);add(lmaterial);
        lsize = new JLabel("Choose size:");lsize.setBounds(300, 150, 100, 30);add(lsize);
        
        tmodel = new JTextField();tmodel.setBounds(110, 50, 100, 30);add(tmodel);
        tprice = new JTextField();tprice.setBounds(110, 100, 100, 30);add(tprice);
        tcount = new JTextField();tcount.setBounds(110, 150, 100, 30);add(tcount);
        tsize = new JComboBox();tsize.addItem("XS");tsize.addItem("S");tsize.addItem("M");tsize.addItem("L");tsize.addItem("XL");
        tsize.addItem("XXL");tsize.addItem("XXXL");tsize.addItem("4XL");tsize.setBounds(400, 150, 100, 30);add(tsize);
        tmaterial = new JComboBox();tmaterial.addItem("Cotton"); tmaterial.addItem("Polyster");tmaterial.addItem("Wool");tmaterial.addItem("Synthetics");
        tmaterial.setBounds(400, 100, 100, 30);add(tmaterial);
        tcolor = new JTextField();tcolor.setBounds(400, 50, 100, 30);add(tcolor);
        
        l = (ActionEvent e) -> {
            JComboBox box = (JComboBox)e.getSource();
            size = (String)tsize.getSelectedItem();
        };
        tsize.addActionListener(l);
        l1 = (ActionEvent e) -> {
            JComboBox box = (JComboBox)e.getSource();
            material = (String)tmaterial.getSelectedItem();
        };
        tmaterial.addActionListener(l1);
        JButton cancel = new ButtonStyle("Return"); cancel.setLocation(350, 300); add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.getAdd());
            }
        });
        JButton acc = new ButtonStyle("ADD");acc.setLocation(350, 250);add(acc);
        acc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String model = tmodel.getText();tmodel.setText("");
                double price = Integer.parseInt(tprice.getText());tprice.setText("");
                int count = Integer.parseInt(tcount.getText());tcount.setText("");
                String color = tcolor.getText();tcolor.setText("");
                g = new Tshirt(material, size, color, price, model, count, 0);
                maincontent.addGood(g);
                JOptionPane.showMessageDialog(TshirtsAdd.this, "The goods were added");
                maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.getAdd().getAddsp());
                maincontent.getAdd().setVisible(false);
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
}
