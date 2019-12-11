package school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Register extends Container {
    private JLabel llog = null;
    private JLabel lpas = null;
    private JLabel lname = null;

    private JTextField tlog = null;
    private JPasswordField tpas = null;
    private JTextField tname = null;
    private String log = "";

    private JButton reg = null;
    private JButton cancel = null;

    public Register(School school){
        llog = new JLabel("LOGIN"); llog.setBounds(200, 100, 200, 50);add(llog);
        lpas = new JLabel("PASSWORD"); lpas.setBounds(200, 200, 200, 50);add(lpas);
        lname = new JLabel("NAME"); lname.setBounds(200, 300, 200, 50);add(lname);

        tlog = new JTextField(); tlog.setBounds(450, 100,200,50);add(tlog);
        tpas = new JPasswordField(); tpas.setBounds(450, 200, 200,50); add(tpas);
        tname = new JTextField(); tname.setBounds(450,300,200,50); add(tname);

        reg = new ButtonStyle("REGISTER");
        reg.setLocation(200, 500); add(reg);

        cancel = new ButtonStyle("CANCEL");
        cancel.setLocation(450,500); add(cancel);

        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log = tlog.getText();
                String p = tpas.getText();
                String n = tname.getText();

                try {
                    PreparedStatement stmt = school.get_con().prepareStatement("INSERT INTO clients (login, name, password) VALUES(?, ?, ?)");
                    stmt.setString(1, log);
                    stmt.setString(2, n);
                    stmt.setString(3, p);

                    stmt.executeUpdate();
                    stmt.close();

                    JOptionPane.showMessageDialog(Register.this, "Client registered!");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                school.switchFrame(school.getClient(), school.getReg());
                System.out.println("Client with " + school.getLogin() + " login is connected");
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdmin_client(), school.getReg());
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
