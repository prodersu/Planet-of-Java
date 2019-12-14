package school;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class MenuSignIn extends Container {
    private JLabel llab = null;
    private JLabel plab = null;
    private JTextField lf = null;
    private JPasswordField pf = null;
    private JButton ok = null;
    private JButton ok1 = null;
    private School school = null;
    
    public MenuSignIn(School school){
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
                String l = lf.getText();
                String p = pf.getText();

                try {
                    ResultSet rs;
                    String login = null;
                    String pas = null;
                    rs = school.get_stmt().executeQuery("select * from admin where id>0");
                    while (rs.next()) {
                        login = rs.getString("login");
                        pas = rs.getString("password");
                    }

                    if (l.equals(login) && p.equals(pas)) {
                        lf.setText("");
                        pf.setText("");
                        p = "";
                        school.switchFrame(school.getAdmin(), school.getSignIn());
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        ok1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdmin_client(), school.getSignIn());
            }
        });
        
        setVisible(false);
        setLayout(null);
        setSize(800, 600);
    }
    
}
