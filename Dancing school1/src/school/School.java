package school;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class School extends JFrame {
    private ArrayList<Courses> courses = null;
    private ArrayList<String> Diary = null;    
    private MenuSignIn signIn = null;
    private MenuAdmin admin = null;
    private AdminAdd admin_add = null;    
    private GetCourse getcourse = null;
    private CourseRemove rem_course = null;
    private Income income = null;
    private Admin_or_Client admin_client = null;
    private MenuClient client = null;
    
    private EnrollToCourse enr_toCourse = null;
    private LookFor look_for = null;
    
    public School(String s){
        super(s);
        courses = new ArrayList<>();
        Diary = new ArrayList<>();        
        signIn = new MenuSignIn (this);
        admin = new MenuAdmin(this);
        admin_add = new AdminAdd(this);
        getcourse = new GetCourse(this);
        rem_course = new CourseRemove(this);
        income = new Income(this);
        admin_client = new Admin_or_Client(this);
        client = new MenuClient(this);
        enr_toCourse = new EnrollToCourse(this, Diary);
        
        look_for = new LookFor(this);
        
        add(signIn);add(admin);add(admin_add);add(getcourse);add(rem_course);add(income);
        add(admin_client);add(client);add(enr_toCourse);add(look_for);
        
        setSize(800,600);
        
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);      
    }

    public ArrayList<Courses> getCourses() {
        return courses;
    }
    public Courses getCourse(int i){
        return courses.get(i);
    }
    
    public void addCourse(Courses c){
        courses.add(c);
    }

    public ArrayList<String> getDiary() {
        return Diary;
    }    

    public MenuSignIn getSignIn() {
        return signIn;
    }

    public MenuAdmin getAdmin() {
        return admin;
    }

    public AdminAdd getAdmin_add() {
        return admin_add;
    }   
    

    public GetCourse getGetcourse() {
        return getcourse;
    }
    public int getCourseSize(){
        return courses.size();
    }

    public CourseRemove getRem_course() {
        return rem_course;
    }

    public Income getIncome() {
        return income;
    }

    public Admin_or_Client getAdmin_client() {
        return admin_client;
    }

    public MenuClient getClient() {
        return client;
    }


    public EnrollToCourse getEnr_toCourse() {
        return enr_toCourse;
    }

    public LookFor getLook_for() {
        return look_for;
    }

    
    public void checkDiary(){
        if(Diary.size()==0)
        {
            JOptionPane.showMessageDialog(School.this, "YOU DIDN'T ENROLL IN ANY COURSES");
        }
        else
        {
            String diary = "You have " + (Diary.size()) + " courses in your Diary. \n";
            int s = 0;
            for (int i = 0; i<Diary.size(); i++)
            {
                diary+= (i+1) + "." +Diary.get(i) + " \n";
            JOptionPane.showMessageDialog(School.this, diary);
                
            }
        }
    }
    
    public void switchFrame(Container x, Container y)
    {
        y.setVisible(false);
        x.setVisible(true);
    }
    
}
