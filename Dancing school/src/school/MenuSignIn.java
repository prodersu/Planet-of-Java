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

        ok = new JButton("LOG IN");
        ok.setLocation(50, 180);
        add(ok);
        
        ok1 = new JButton("CANCEL");
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
                    school.switchFrame(school.getAdmin(), school.getSignIn());
                }
            }
        });
        ok1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdm_client(), school.getSignIn());
            }
        });
        
        setVisible(false);
        setLayout(null);
        setSize(800, 600);
    }
    
}
