
package school;

import java.awt.*;
import javax.swing.*;

class GetCourse extends Container {
    public GetCourse (School school){
    setVisible(false);
    setLayout(null);
    setSize(800, 600);
    }
    public void getCourse(School school){
    if(school.getCourseSize()==0){
        JOptionPane.showMessageDialog(GetCourse.this, "There aren't any courses in school..");
        }
    else{
        String Courses = "There are ";
            Courses += school.getCourseSize() + "courses in school\n";
            for (int i = 0; i < school.getCourseSize(); i++) {
                Courses += (i + 1) + school.getCourse(i).showDetails()+ "\n";
            }
            JOptionPane.showMessageDialog(GetCourse.this, Courses);
    }
            }
    
    
}
