package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAdd extends Container{
    private Container now = null;
    private SmartphoneAdd addsp = null;
    private LaptopAdd addl = null;
    private AddComp addc = null;
    private SneakersAdd adds = null;
    private TshirtsAdd addt = null;

    public SmartphoneAdd getAddsp() {
        return addsp;
    }

    public LaptopAdd getAddl() {
        return addl;
    }

    public AddComp getAddc() {
        return addc;
    }

    public SneakersAdd getAdds() {
        return adds;
    }

    public TshirtsAdd getAddt() {
        return addt;
    }
    
    public AdminAdd(Main_content maincontent) {
        addsp = new SmartphoneAdd(maincontent);
        addl = new LaptopAdd(maincontent);
        addc = new AddComp(maincontent);
        adds = new SneakersAdd(maincontent);
        addt = new TshirtsAdd(maincontent);
        now = addsp;
        ButtonGroup bg = new ButtonGroup();
        JToggleButton sp = new JToggleButton("Smartphone");sp.setBounds(10, 10, 100, 30);bg.add(sp);add(sp);
        JToggleButton l = new JToggleButton("Laptop");l.setBounds(120, 10, 100, 30);bg.add(l);add(l);
        JToggleButton c = new JToggleButton("Computer");c.setBounds(230, 10, 100, 30);bg.add(c);add(c);
        JToggleButton s = new JToggleButton("Sneakers");s.setBounds(340, 10, 100, 30);bg.add(s);add(s);
        JToggleButton t = new JToggleButton("T-shirt");t.setBounds(450, 10, 100, 30);bg.add(t);add(t);
        add(addsp);add(addl);add(addc);add(adds);add(addt);
        
        sp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(addsp, now);
                now = addsp;
            }
        });
        l.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(addl, now);
                now = addl;
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(addc, now);
                now = addc;
            }
        });
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(adds, now);
                now = adds;
            }
        });
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(addt, now);
                now = addt;
            }
        });
        
        setVisible(false);
        setLayout(null);
        setSize(600,400);
    }
}
