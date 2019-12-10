
package school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class KidsAdd extends Container {
    private JLabel ltitle = null;       private JTextField ttitle = null;
    private JLabel lage = null;         private JTextField tage = null;
    private JLabel lmaster = null;      private JTextField tmaster = null;
    private JLabel lschedule = null;    private JComboBox<String> tschedule = null;
    private JLabel lprice = null;       private JTextField tprice = null;
    private JLabel ltour = null;        private JRadioButton yes = null;
    private ButtonGroup gtour = null;   private JRadioButton no = null;
    private String schedule = null;     private ActionListener l2;
    private Courses c = null;

    public KidsAdd(School school)
    {
        ltitle = new JLabel("ENTER TITLE:");ltitle.setBounds(20, 100, 150, 50);add(ltitle);
        lage = new JLabel("Enter Age:");lage.setBounds(20, 200, 150, 50);add(lage);
        lmaster= new JLabel("ENTER MASTER:");lmaster.setBounds(20, 300, 150, 50);add(lmaster);
        lschedule = new JLabel("ENTER SCHEDULE:");lschedule.setBounds(20, 400, 150, 50); add(lschedule);
        lprice = new JLabel("ENTER PRICE:");lprice.setBounds(420, 100, 150, 50);add(lprice);
        ltour = new JLabel("WITH TOURS?"); ltour.setBounds(420, 200, 150, 50); add(ltour);


        ttitle = new JTextField(); ttitle.setBounds(220, 100, 150, 50);add(ttitle);
        tage = new JTextField(); tage.setBounds(220, 200, 150, 50); add(tage);
        tmaster = new JTextField(); tmaster.setBounds(220,300,150,50); add(tmaster);
        tschedule = new JComboBox(); tschedule.setBounds(220, 400, 150, 50);
        tschedule.addItem("Monday"); tschedule.addItem("Tuesday"); tschedule.addItem("Wednesday");
        tschedule.addItem("Thursday"); tschedule.addItem("Friday");
        tschedule.addItem("Saturday"); add(tschedule);
        tprice = new JTextField(); tprice.setBounds(620, 100, 150, 50); add(tprice);
        gtour = new ButtonGroup();
        yes = new JRadioButton("YES");yes.setBounds(620, 200, 50, 30); add(yes); gtour.add(yes);
        no = new JRadioButton("NO"); no.setBounds(670, 200, 50, 30);add(no); gtour.add(no);

        l2 = (ActionEvent e) ->{
            JComboBox box = (JComboBox)e.getSource();
            schedule = (String)tschedule.getSelectedItem();
        };
        tschedule.addActionListener(l2);

        JButton cancel = new ButtonStyle("CANCEL"); cancel.setLocation(300, 480);add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                school.switchFrame(school.getAdmin(), school.getAdmin_add());
            }
        });
        JButton add = new ButtonStyle("ADD"); add.setLocation(300, 530); add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = ttitle.getText();ttitle.setText("");
                String master = tmaster.getText(); tmaster.setText("");
                boolean tour;
                String tour_s;                
                tour = yes.isSelected();
                if(tour)tour_s = "yes";
                else{tour_s = "no";}
                int price = Integer.parseInt(tprice.getText()); tprice.setText("");
                int age = Integer.parseInt(tage.getText()); tage.setText("");
                c = new Kids(title, master, schedule, price, 0, 1, age, tour);
                school.addCourse(c);
                try {
                    school.insert_kids(school.get_con(), title, master, schedule, price, age, tour_s);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                school.switchFrame(school.getAdmin(), school.getAdmin_add());
            }
        });
        setVisible(false);
        setLayout(null);
        setSize(800, 600);
    }
}
