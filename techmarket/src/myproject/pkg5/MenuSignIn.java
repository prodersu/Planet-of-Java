package myproject.pkg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSignIn extends Container {
    private JLabel llab = null;
    private JLabel plab = null;
    private JTextField lf = null;
    private JPasswordField pf = null;
    private JButton ok = null;
    private JButton ok1 = null;
    private Main_content maincontent = null;
    
    public MenuSignIn(Main_content maincontent) {
        this.maincontent = maincontent;
        
        llab = new JLabel("LOGIN: ");
        llab.setBounds(50, 50, 200, 40);
        add(llab);

        plab = new JLabel("PASSWORD: ");
        plab.setBounds(50, 100, 200, 40);
        add(plab);

        lf = new JTextField();
        lf.setBounds(200, 50, 200, 40);
        add(lf);

        pf = new JPasswordField();
        pf.setBounds(200, 100, 200, 40);
        add(pf);

        ok = new ButtonStyle("LOG IN");
        ok.setLocation(50, 180);
        add(ok);
        
        ok1 = new ButtonStyle("CANCEL");
        ok1.setLocation(290, 180);
        add(ok1);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String l = lf.getText();
                String p = pf.getText();
                if(l.equals("admin") && p.equals("admin")){
                    pf.setText("");
                    p = "";
                    maincontent.switchFrame(maincontent.getAdminMenu(), maincontent.getSignIn());
                }
            }
        });
        ok1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maincontent.switchFrame(maincontent.getAdm_or_Client(), maincontent.getSignIn());
            }
        });
        
        setVisible(false);
        setLayout(null);
        setSize(500, 400);
    }
    
}
