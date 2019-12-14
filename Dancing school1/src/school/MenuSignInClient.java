package school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MenuSignInClient extends Container {
    private JLabel llab = null;
    private JLabel plab = null;
    private JTextField lf = null;
    private JPasswordField pf = null;
    private JButton ok = null;
    private JButton ok1 = null;
    private School school = null;
    private String log = "";

    public MenuSignInClient(School school){
        this.school = school;
        
        ImageIcon img = new ImageIcon("D:\\image1.jpg");
        JLabel l1 = new JLabel("", img, JLabel.CENTER);
        l1.setBounds(0, 0, 800, 600);
        
        
         llab = new JLabelStyle("LOGIN: ");
        llab.setBounds(200, 100, 200, 50);
        add(llab);

        plab = new JLabelStyle("PASSWORD: ");       
        plab.setBounds(200, 200, 200, 50);
        add(plab);

        lf = new JTextFieldS();
        lf.setBounds(450, 100, 200, 50);
        add(lf);

        pf = new JPasswordField();
        pf.setEchoChar('#');
        pf.setBounds(450, 200, 200, 50);
        add(pf);

        ok = new ButtonStyle("LOG IN");
        ok.setLocation(200, 300);
        add(ok);
        
        ok1 = new ButtonStyle("CANCEL");
        ok1.setLocation(450, 300);
        add(ok1);
        
        add(l1);
        
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log = lf.getText();
                String p = pf.getText();

                try {
                    ResultSet rs;
                    String pas = null;
                    rs = school.get_stmt().executeQuery("select * from clients where login like '"+log+"'");
                    while (rs.next()) {
                        pas = rs.getString("password");
                    }

                    if (p.equals(pas)) {
                        pf.setText("");
                        p = "";
                        school.switchFrame(school.getClient(), school.getSignInClient());
                        System.out.println("Client with " + school.getLogin()+" login is connected");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        ok1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdmin_client(), school.getSignInClient());
            }
        });
        
        setVisible(false);
        setLayout(null);
        setSize(800, 600);
    }
    public void setLog(String log) {
        this.log = log;
    }
    public String getLog(){return log;}


}
