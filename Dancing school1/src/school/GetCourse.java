
package school;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

class GetCourse extends Container {
    public GetCourse (School school){
    setVisible(false);
    setLayout(null);
    setSize(800, 600);
    }
    public void getCourse(School school) throws SQLException {

        String Courses = "ADULT COURSES: \n";
        ResultSet rs;
        rs = school.get_stmt().executeQuery("select * from adult");
        while (rs.next()) {
            Courses+= rs.getInt("id") + ". " +rs.getString("title") + " " + rs.getString("style") + " master: "+rs.getString("master")+
                    " on " + rs.getString("schedule") + " price: "
                    + rs.getInt("price") + " for "+  rs.getString("gender") + " in "+  rs.getString("indiv_group" ) + "\n";
        }
        Courses+="FOR KIDS: \n";
        rs = school.get_stmt().executeQuery("select * from kids");
        while (rs.next()) {
            Courses+= rs.getInt("id") + ". " +rs.getString("title") + " master: "+rs.getString("master")+
                    " on " + rs.getString("schedule") + "price: "
                    + rs.getInt("price") + " for "+  rs.getString("age") + " tours?: "+  rs.getString("tour");
        }
            
            JOptionPane.showMessageDialog(GetCourse.this, Courses);

            }
    
    
}
