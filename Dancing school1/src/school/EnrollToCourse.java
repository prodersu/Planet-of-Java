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
        JRadioButton ra = new JRadioButton("adult"); ra.setLocation(300, 250); add(ra);
        JRadioButton rk = new JRadioButton("kids"); rk.setLocation(350, 250); add(rk);
        JButton b = new ButtonStyle("Enroll");b.setLocation(300, 350);add(b);
        JButton cancel = new ButtonStyle("CANCEL"); cancel.setLocation(300, 450); add(cancel);

        b.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    school.switchFrame(school.getClient(), school.getEnr_toCourse());
                                    int j = Integer.parseInt(t.getText());
                                    String diary = "";
                                    String diary1 = "";
                                    String title = "";
                                    ResultSet rs;
                                    ResultSet rs2;
                                    try {
                                        rs = school.get_stmt().executeQuery("select * from client where login like '" + school.getLogin() + "'");
                                        if (ra.isSelected()) {
                                            rs2 = school.get_stmt().executeQuery("select * from adult where id like '" + j + "'");
                                            while (rs2.next()) {
                                                diary = rs2.getString("schedule");
                                                title = rs2.getString("title");

                                            }
                                        } else if (rk.isSelected()) {
                                            rs2 = school.get_stmt().executeQuery("select * from kids where id like '" + j + "'");
                                            while (rs2.next()) {
                                                diary = rs2.getString("schedule");
                                                title = rs2.getString("title");

                                            }
                                        }
                                        while (rs.next()) {
                                            diary1 = rs.getString("schedule");
                                        }
                                        if (diary == diary1) {
                                            JOptionPane.showMessageDialog(EnrollToCourse.this, "You have already one course on " + diary);
                                        } else {
                                            PreparedStatement stmt = school.get_con().prepareStatement("INSERT INTO clients (titles in diary, schedule) VALUES (?,?)");
                                            stmt.setString(1, title);
                                            stmt.setString(2, diary);

                                            stmt.executeUpdate();
                                            stmt.close();
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
