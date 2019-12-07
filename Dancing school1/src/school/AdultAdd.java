package school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Created by 28354 on 27.11.2019.
 */
public class AdultAdd extends Container {

    private JLabel ltitle = null;       private JTextField ttitle = null;
    private JLabel lstyle = null;       private JComboBox<String> tstyle = null;
    private JLabel lmaster = null;      private JTextField tmaster = null;
    private JLabel lschedule = null;    private JComboBox<String> tschedule = null;
    private JLabel lprice = null;       private JTextField tprice = null;
    private JLabel lgender = null;      private JComboBox<String> tgender = null;
    private JLabel lindiv = null;       private JComboBox<String> tindiv = null;
    private Courses c = null;
    private String style = null;        private ActionListener l1;
    private String schedule = null;     private ActionListener l2;
    private String gender = null;       private ActionListener l3;
    private String indiv = null;        private ActionListener l4;

    public AdultAdd(School school){

        ltitle = new JLabel("ENTER TITLE:");ltitle.setBounds(20,100,150,50);add(ltitle);
        lstyle = new JLabel("ENTER STYLE:");lstyle.setBounds(20,200,150,50);add(lstyle);
        lmaster= new JLabel("ENTER MASTER:");lmaster.setBounds(20,300,150,50);add(lmaster);
        lschedule = new JLabel("ENTER SCHEDULE:");lschedule.setBounds(20,400,150,50); add(lschedule);
        lprice = new JLabel("ENTER PRICE:");lprice.setBounds(420, 100, 150, 50);add(lprice);
        lgender = new JLabel("MAN OR WOMAN");lgender.setBounds(420,200,150,50); add(lgender);
        lindiv = new JLabel("INDIVIDUAL OR GROUP");lindiv.setBounds(420,300,150,50); add(lindiv);
        
        ttitle = new JTextField(); ttitle.setBounds(220,100,150,50);add(ttitle);
        tstyle = new JComboBox(); tstyle.setBounds(220,200,150,50);
        tstyle.addItem("National dance"); tstyle.addItem("Ballroom dance"); tstyle.addItem("Club Latine"); 
        tstyle.addItem("Fitness Yoga"); tstyle.addItem("Tango dance"); tstyle.addItem("Lady's style"); tstyle.addItem("Zumba");add(tstyle);
        tmaster = new JTextField(); tmaster.setBounds(220,300,150,50); add(tmaster);
        tschedule = new JComboBox(); tschedule.setBounds(220, 400, 150, 50); 
        tschedule.addItem("Monday"); tschedule.addItem("Tuesday"); tschedule.addItem("Wednesday");
        tschedule.addItem("Thursday"); tschedule.addItem("Friday"); 
        tschedule.addItem("Saturday"); add(tschedule);
        tprice = new JTextField(); tprice.setBounds(620, 100, 150, 50); add(tprice);
        tgender = new JComboBox(); tgender.setBounds(620, 200, 150, 50); 
        tgender.addItem("Man"); tgender.addItem("Woman"); add(tgender);
        tindiv = new JComboBox(); tindiv.setBounds(620, 300, 150, 50);
        tindiv.addItem("Individual"); tindiv.addItem("Group");add(tindiv);
        
        l1 = (ActionEvent e) ->{
            JComboBox box = (JComboBox)e.getSource();
            style = (String)tstyle.getSelectedItem();
        };
        tstyle.addActionListener(l1);
        l2 = (ActionEvent e) ->{
            JComboBox box = (JComboBox)e.getSource();
            schedule = (String)tschedule.getSelectedItem();
        };
        tschedule.addActionListener(l2);
        l3 = (ActionEvent e) ->{
            JComboBox box = (JComboBox)e.getSource();
            gender = (String)tgender.getSelectedItem();
        };
        tgender.addActionListener(l3);
        l4 = (ActionEvent e) ->{
            JComboBox box = (JComboBox)e.getSource();
            indiv = (String)tindiv.getSelectedItem();
        };
        tindiv.addActionListener(l4);
        
        JButton cancel = new ButtonStyle("CANCEL"); cancel.setLocation(300,480);add(cancel);
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            school.switchFrame(school.getAdmin(),school.getAdmin_add() );
            }
        });
        JButton add = new ButtonStyle("ADD"); add.setLocation(300, 530);add(add);
        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            String title = ttitle.getText();ttitle.setText("");
            String master = tmaster.getText(); tmaster.setText("");
            int price = Integer.parseInt(tprice.getText()); tprice.setText("");
            c = new Adult(title, master, schedule, price, 0, 1, style, gender, indiv);
            school.addCourse(c);
            JOptionPane.showMessageDialog(AdultAdd.this, "The course is added!");
            school.switchFrame(school.getAdmin(), school.getAdmin_add());
            }
        });
        
        setVisible(false);
        setLayout(null);
        setSize(800,600);
    }

}
