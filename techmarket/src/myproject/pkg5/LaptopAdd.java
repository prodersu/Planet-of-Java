package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaptopAdd extends Container {
    private JLabel lmodel = null;
    private JLabel lprice = null;
    private JLabel lcount = null;
    private JLabel lcpu = null;
    private JLabel lram = null;
    private JLabel lssd = null;
    private JLabel lmem = null;
    private JLabel lweigth = null;
    private JLabel ltouch = null;
    private Good g = null;
    private String cpu = null;
    private String ram = null;
    private String model = null;
    private ActionListener l;
    private ActionListener l1;
    
    private JComboBox<String> tmodel = null;
    private JTextField tprice = null;
    private JTextField tcount = null;
    private JComboBox<String> tcpu = null;
    private JComboBox<String> tram = null;
    private ButtonGroup tssd = null; 
    private JRadioButton yes = null;
    private JRadioButton no = null;
    private JTextField tmem = null;
    private JTextField tweigth = null;
    private ButtonGroup ttouch = null;
    private JRadioButton yes1 = null;
    private JRadioButton no1 = null;
    private ActionListener l2;

    private ArrayList<String> cpus = null;
    public LaptopAdd(Main_content maincontent) {
        
        lmodel = new JLabel("Enter model:");lmodel.setBounds(10, 50, 100, 30);add(lmodel);
        lprice = new JLabel("Enter price:");lprice.setBounds(10, 100, 100, 30);add(lprice);
        lcount = new JLabel("Enter count:");lcount.setBounds(10, 150, 100, 30);add(lcount);
        lcpu = new JLabel("Chose CPU:");lcpu.setBounds(10, 200, 100, 30);add(lcpu);
        lram = new JLabel("Enter RAM:");lram.setBounds(300, 50, 100, 30);add(lram);
        lssd = new JLabel("Has SSD:");lssd.setBounds(300, 100, 100, 30);add(lssd);
        lmem = new JLabel("Enter memory:");lmem.setBounds(300, 150, 100, 30);add(lmem);
        lweigth = new JLabel("Enter weight:");lweigth.setBounds(300, 200, 100, 30);add(lweigth);
        ltouch = new JLabel("Has touch sensor:");ltouch.setBounds(10, 250, 100, 30);add(ltouch);
        
        tmodel = new JComboBox();tmodel.addItem("HP");tmodel.addItem("ASUS");
        tmodel.addItem("Mac Pro");tmodel.addItem("Acer"); tmodel.addItem("Lenovo");
        tmodel.setBounds(110, 50, 100, 30);add(tmodel);
        tprice = new JTextField();tprice.setBounds(110,100,100,30);add(tprice);
        tcount = new JTextField();tcount.setBounds(110,150,100,30);add(tcount);
        tcpu = new JComboBox();tcpu.addItem("corei5");tcpu.addItem("corei7");tcpu.addItem("core DUO");tcpu.addItem("ATX Radeon");tcpu.setBounds(110, 200, 100, 30);add(tcpu);
        tram = new JComboBox();tram.addItem("1");tram.addItem("2");tram.addItem("4");tram.addItem("8");tram.addItem("16");add(tram);
        tssd = new ButtonGroup();
        yes = new JRadioButton("YES");yes.setBounds(400, 100, 50, 30);add(yes);tssd.add(yes);
        no = new JRadioButton("NO");no.setBounds(450, 100, 50, 30);add(no);tssd.add(no);
        tmem = new JTextField();tmem.setBounds(400,150,100,30);add(tmem);
        ttouch = new ButtonGroup();
        yes1 = new JRadioButton("YES");yes1.setBounds(100, 250, 50, 30);add(yes1);ttouch.add(yes1);
        no1 = new JRadioButton("NO");no1.setBounds(150, 250, 50, 30);add(no1);ttouch.add(no1);
        tweigth = new JTextField();tweigth.setBounds(400, 200, 100, 30);add(tweigth);
        
        l = (ActionEvent e) -> {
            JComboBox box = (JComboBox)e.getSource();
            cpu = (String)tcpu.getSelectedItem();
        };
        tcpu.addActionListener(l);

        l1 = (ActionEvent e) -> {
            JComboBox box = (JComboBox)e.getSource();
            model = (String)tmodel.getSelectedItem();
        };
        tmodel.addActionListener(l1);
        l2 = (ActionEvent e) -> {
            JComboBox box = (JComboBox)e.getSource();
            ram = (String)tram.getSelectedItem();
        };
        tram.addActionListener(l2);
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
                double price = Integer.parseInt(tprice.getText());tprice.setText("");
                int count = Integer.parseInt(tcount.getText());tcount.setText("");
                int r = Integer.parseInt(ram);
                boolean ssd;
                ssd = yes.isSelected();
                int memory = Integer.parseInt(tmem.getText());tmem.setText("");
                double weigth = Double.parseDouble(tweigth.getText());
                boolean touch;
                touch = yes1.isSelected();
                g = new Laptop(weigth, touch, ssd, memory, cpu, r, price, model, count, 0);
                maincontent.addGood(g);
                JOptionPane.showMessageDialog(LaptopAdd.this, "The goods were added");
                maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.getAdd().getAddl());
                maincontent.getAdd().setVisible(false);
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
}