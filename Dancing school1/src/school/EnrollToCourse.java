/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EnrollToCourse extends Container {
    public EnrollToCourse(School school, ArrayList<String> Diary){
        JLabel l = new JLabel("Enter course ID:");l.setBounds(300, 50, 200, 50);add(l);
        JTextField t = new JTextField();t.setBounds(300, 150, 200, 50);add(t);
        JRadioButton ra = new JRadioButton("adult"); ra.setBounds(300, 250, 100, 50); add(ra);
        JRadioButton rk = new JRadioButton("kids"); rk.setBounds(410, 250, 100, 50); add(rk);
        JButton b = new ButtonStyle("Enroll");b.setLocation(300, 350);add(b);
        JButton cancel = new ButtonStyle("CANCEL"); cancel.setLocation(300, 450); add(cancel);


        b.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    school.switchFrame(school.getClient(), school.getEnr_toCourse());
                                    int j = Integer.parseInt(t.getText());
                                    String diary = "";
                                    String diary1 = "";
                                    String title1 = "";
                                    String title = "";
                                    int sold = 0;
                                    ResultSet rs;
                                    ResultSet rs2;

                                    try {
                                        rs = school.get_stmt().executeQuery("select * from clients where login like '" + school.getSignInClient().getLog()+ "'");
                                        while (rs.next()) {
                                            diary1 = rs.getString("schedule");
                                            title1 = rs.getString("titles");
                                        }

                                        if (ra.isSelected()) {
                                            rs2 = school.get_stmt().executeQuery("select * from adult where id like '" + j + "'");
                                            while (rs2.next()) {
                                                diary = rs2.getString("schedule");
                                                title = rs2.getString("title");
                                                sold = rs2.getInt("sold");

                                            }
                                        } else if (rk.isSelected()) {
                                            rs2 = school.get_stmt().executeQuery("select * from kids where id like '" + j + "'");
                                            while (rs2.next()) {
                                                diary = rs2.getString("schedule");
                                                title = rs2.getString("title");
                                                sold = rs2.getInt("sold");

                                            }
                                        }
                                        sold++;


                                        if (diary1.contains(diary)) {
                                            JOptionPane.showMessageDialog(EnrollToCourse.this, "You have already one course on " + diary);
                                        } else {
                                            CallableStatement stmt = school.get_con().prepareCall("UPDATE clients SET titles = '"+title + "\n"+ title1+"' WHERE login = '" + school.getLogin() + "'");
                                                                                        

                                            stmt.executeUpdate();
                                            stmt.close();
                                            
                                            CallableStatement stmt2 = school.get_con().prepareCall("UPDATE clients SET schedule = '"+diary + "\n"+ diary1+"' WHERE login = '" + school.getLogin() + "'");
                                            stmt2.executeUpdate();
                                            stmt2.close();
                                            CallableStatement stmt1;
                                            if (ra.isSelected()) {
                                                stmt1 = school.get_con().prepareCall("UPDATE adult SET sold = '"+sold+"' WHERE title = '"+title+"'");                                               

                                                stmt1.executeUpdate();
                                                stmt1.close();
                                            }
                                            else if (rk.isSelected()) {
                                                stmt1 = school.get_con().prepareCall("UPDATE kids SET sold = '"+sold+"' WHERE title = '"+title+"'");
                                                

                                                stmt1.executeUpdate();
                                                stmt1.close();
                                            }
                                            JOptionPane.showMessageDialog(EnrollToCourse.this, "THANKS FOR ENROLLING, SEE YOU SOON ON "+ diary);
                                        }
                                    } catch (SQLException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                            }

        );
        cancel.addActionListener(new

                                         ActionListener() {
                                             @Override
                                             public void actionPerformed(ActionEvent e) {
                                                 school.switchFrame(school.getClient(), school.getEnr_toCourse());
                                             }
                                         });

            setVisible(false);

            setSize(600, 400);

            setLayout(null);
        }

    }
