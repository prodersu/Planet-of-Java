package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddComp extends Container {
    private JLabel lmodel = null;
    private JLabel lprice = null;
    private JLabel lcount = null;
    private JLabel lcpu = null;
    private JLabel lram = null;
    private JLabel lssd = null;
    private JLabel lmem = null;
    private Good g = null;
    private String cpu = null;
    private String model = null;
    private String ram = null;
    private ActionListener l;
    private ActionListener l1;
    private ActionListener l2;
    
    private JComboBox<String> tmodel = null;
    private JTextField tprice = null;
    private JTextField tcount = null;
    private JComboBox<String> tcpu = null;
    private JComboBox<String> tram = null;
    private ButtonGroup tssd = null; 
    private JRadioButton yes = null;
    private JRadioButton no = null;
    private JTextField tmem = null;
    public AddComp(Main_content maincontent) {
        
        lmodel = new JLabel("Choose model:");lmodel.setBounds(10, 50, 100, 30);add(lmodel);
        lprice = new JLabel("Enter price:");lprice.setBounds(10, 100, 100, 30);add(lprice);
        lcount = new JLabel("Enter count:");lcount.setBounds(10, 150, 100, 30);add(lcount);
        lcpu = new JLabel("Choose CPU:");lcpu.setBounds(10, 200, 100, 30);add(lcpu);
        lram = new JLabel("Enter RAM:");lram.setBounds(300, 50, 100, 30);add(lram);
        lssd = new JLabel("Has SSD:");lssd.setBounds(300, 100, 100, 30);add(lssd);
        lmem = new JLabel("Enter memory:");lmem.setBounds(300, 150, 100, 30);add(lmem);
        
        tmodel = new JComboBox();tmodel.addItem("Dell");tmodel.addItem("FUJITSU");tmodel.addItem("Samsung");
        tmodel.addItem("ASUS");tmodel.addItem("HP");
        tmodel.setBounds(110,50,100,30);add(tmodel);
        tprice = new JTextField();tprice.setBounds(110, 100, 100, 30);add(tprice);
        tcount = new JTextField();tcount.setBounds(110, 150, 100, 30);add(tcount);
        tcpu = new JComboBox();tcpu.addItem("corei3");tcpu.addItem("corei5");tcpu.addItem("corei7");tcpu.addItem("ATX Radeon");tcpu.setBounds(110, 200, 100, 30);add(tcpu);
        tram = new JComboBox();tram.addItem("1");tram.addItem("2");tram.addItem("4");tram.addItem("8");tram.addItem("16");
        tram.setBounds(400, 50, 100, 30);add(tram);
        tssd = new ButtonGroup();
        yes = new JRadioButton("YES");yes.setBounds(400, 100, 50, 30);add(yes);tssd.add(yes);
        no = new JRadioButton("NO");no.setBounds(450, 100, 50, 30);add(no);tssd.add(no);
        tmem = new JTextField();tmem.setBounds(400, 150, 100, 30);add(tmem);
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

        JButton cancel = new ButtonStyle("Cancel"); cancel.setLocation(350, 300); add(cancel);
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
                boolean ssd;
                ssd = yes.isSelected();
                int memory = Integer.parseInt(tmem.getText());tmem.setText("");
                int r = Integer.parseInt(ram);
                g = new Computer(ssd, memory, cpu, r, price, model, count, 0);
                maincontent.addGood(g);
                JOptionPane.showMessageDialog(AddComp.this, "The goods were added");
                maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.getAdd().getAddc());
                maincontent.getAdd().setVisible(false);
            }
        });
        
        
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
}
