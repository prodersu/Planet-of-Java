package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartphoneAdd extends Container{
    private JLabel lmodel = null;
    private JLabel lprice = null;
    private JLabel lcount = null;
    private JLabel lcpu = null;
    private JLabel lram = null;
    private JLabel lmgpx = null;
    private JLabel lgen = null;
    private Good g = null;
    private String cpu;
    private String gen;
    private String ram;
    private ActionListener l;
    private ActionListener l1;
    private ActionListener l2;

    private JTextField tmodel = null;
    private JTextField tprice = null;
    private JTextField tcount = null;
    private JComboBox<String> tcpu = null;
    private JComboBox<String> tram = null;
    private JTextField tmgpx = null;
    private JComboBox<String> tgen = null;
    

    public SmartphoneAdd(Main_content maincontent) {
        
        lmodel = new JLabel("Enter model:");lmodel.setBounds(10, 50, 100, 30);add(lmodel);
        lprice = new JLabel("Enter price:");lprice.setBounds(10, 100, 100, 30);add(lprice);
        lcount = new JLabel("Enter count:");lcount.setBounds(10, 150, 100, 30);add(lcount);
        lcpu = new JLabel("Choose CPU:");lcpu.setBounds(10, 200, 100, 30);add(lcpu);
        lram = new JLabel("Enter RAM:");lram.setBounds(300, 50, 100, 30);add(lram);
        lmgpx = new JLabel("Enter MGPX:");lmgpx.setBounds(300, 100, 100, 30);add(lmgpx);
        lgen = new JLabel("Choose generation:");lgen.setBounds(300, 150, 100, 30);add(lgen);
        
        tmodel = new JTextField();tmodel.setBounds(110, 50, 100, 30);add(tmodel);
        tprice = new JTextField();tprice.setBounds(110, 100, 100, 30);add(tprice);
        tcount = new JTextField();tcount.setBounds(110, 150, 100, 30);add(tcount);
        tcpu = new JComboBox();tcpu.addItem("Snapdragon 660");tcpu.addItem("Exynos 9820");tcpu.addItem("Kirin 980");tcpu.addItem("MediaTek Helio");tcpu.setBounds(110, 200, 100, 30);add(tcpu);
        tram = new JComboBox();tram.addItem("1");tram.addItem("2");tram.addItem("4");tram.addItem("8");tram.addItem("16");add(tram);
        tmgpx = new JTextField();tmgpx.setBounds(400, 100, 100, 30);add(tmgpx);
        tgen = new JComboBox();tgen.addItem("2G");
        tgen.addItem("3G");tgen.addItem("4G"); tgen.addItem("5G");
        tgen.setBounds(400, 150, 100, 30);add(tgen);
        
        l = (ActionEvent e) -> {
            JComboBox box = (JComboBox)e.getSource();
            cpu = (String)tcpu.getSelectedItem();
            gen = (String)tgen.getSelectedItem();
        };
        tcpu.addActionListener(l);
        l1 = (ActionEvent e) -> {
            JComboBox box = (JComboBox)e.getSource();
            gen = (String)tgen.getSelectedItem();
        };
        l2 = (ActionEvent e) -> {
            JComboBox box = (JComboBox)e.getSource();
            ram = (String)tram.getSelectedItem();
        };
        tram.addActionListener(l2);
        tgen.addActionListener(l1);
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
                int r = Integer.parseInt(ram);
                double mgpx = Integer.parseInt(tmgpx.getText());tmgpx.setText("");
                g = new SmartPhone(mgpx, gen, cpu, r, price, model, count, 0);
                maincontent.addGood(g);
                JOptionPane.showMessageDialog(SmartphoneAdd.this, "The goods were added");
                maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.getAdd().getAddsp());
                maincontent.getAdd().setVisible(false);
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
}
