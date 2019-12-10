package school;
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
    private School school = null;
    
    public MenuSignIn(School school){
        this.school = school;
        
         llab = new JLabel("LOGIN: ");
        llab.setBounds(200, 100, 200, 50);
        add(llab);

        plab = new JLabel("PASSWORD: ");
        plab.setBounds(200, 200, 200, 50);
        add(plab);

        lf = new JTextField();
        lf.setBounds(450, 100, 200, 50);
        add(lf);

        pf = new JPasswordField();
        pf.setBounds(450, 200, 200, 50);
        add(pf);

        ok = new ButtonStyle("LOG IN");
        ok.setLocation(100, 300);
        add(ok);
        
        ok1 = new ButtonStyle("CANCEL");
        ok1.setLocation(350, 300);
        add(ok1);
        
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String l = lf.getText();
                String p = pf.getText();
                school.get_rs() = school.get_stmt().executeQuery("select * from admin");
                String login = school.get_rs().getString("login");
                String pass = school.get_rs().getstring("password");               
                if(l.equals(login) && p.equals(pass)){
                    pf.setText("");
                    p = "";
                    school.switchFrame(school.getAdmin(), school.getSignIn());
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
