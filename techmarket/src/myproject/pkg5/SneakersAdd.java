package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SneakersAdd extends Container {
    private JLabel lmodel = null;
    private JLabel lprice = null;
    private JLabel lcount = null;
    private JLabel lsize = null;
    private JLabel lcolor = null;
    private JLabel lseason = null;
    private Good g = null;
    private String season = null;
    private ActionListener l;
    
    private JTextField tmodel = null;
    private JTextField tprice = null;
    private JTextField tcount = null;
    private JTextField tsize = null;
    private JTextField tcolor = null;
    private JComboBox<String> tseason = null;
    
    public SneakersAdd(Main_content maincontent) {
        
        lmodel = new JLabel("Enter model:");lmodel.setBounds(10,50,100,30);add(lmodel);
        lprice = new JLabel("Enter price:");lprice.setBounds(10,100,100,30);add(lprice);
        lcount = new JLabel("Enter count:");lcount.setBounds(10, 150, 100, 30);add(lcount);
        lcolor = new JLabel("Enter color:");lcolor.setBounds(300, 50, 100, 30);add(lcolor);
        lsize = new JLabel("Enter size:");lsize.setBounds(300, 100, 100, 30);add(lsize);
        lseason = new JLabel("Choose season:");lseason.setBounds(300, 150, 100, 30);add(lseason);
        
        tmodel = new JTextField();tmodel.setBounds(110, 50, 100, 30);add(tmodel);
        tprice = new JTextField();tprice.setBounds(110, 100, 100, 30);add(tprice);
        tcount = new JTextField();tcount.setBounds(110, 150, 100, 30);add(tcount);
        tseason = new JComboBox();tseason.addItem("summer");tseason.addItem("winter");tseason.addItem("autumn-spring");tseason.setBounds(400, 150, 100, 30);add(tseason);
        tsize = new JTextField();tsize.setBounds(400, 50, 100, 30);add(tsize);
        tcolor = new JTextField();tcolor.setBounds(400, 100, 100, 30);add(tcolor);
        
        l = (ActionEvent e) -> {
            JComboBox box = (JComboBox)e.getSource();
            season = (String)tseason.getSelectedItem();
        };
        tseason.addActionListener(l);

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
                String size = tsize.getText();tsize.setText("");
                g = new Sneakers(season, size, color, price, model, count, 0);
                maincontent.addGood(g);
                JOptionPane.showMessageDialog(SneakersAdd.this, "The goods were added");
                maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.getAdd().getAdds());
                maincontent.getAdd().setVisible(false);
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
}
