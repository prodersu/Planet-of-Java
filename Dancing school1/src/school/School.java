package school;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.sql.*;


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
    private MenuSignInClient signInClient = null;
    private Register reg = null;
    
    private EnrollToCourse enr_toCourse = null;
    private LookFor look_for = null;
    
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    String user = "root";
    String pass = "";
    
    
    public School(String s) throws SQLException{
        super(s);
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dance_school?useUnicode=true&serverTimezone=UTC", user, pass);
        stmt = con.createStatement();
        System.out.print("Database connected\n");
        courses = new ArrayList<>();
        Diary = new ArrayList<>();        
        signIn = new MenuSignIn (this);
        signInClient = new MenuSignInClient(this);
        reg = new Register(this);
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
        add(admin_client);add(client);add(enr_toCourse);add(look_for);add(signInClient); add(reg);
        
        setSize(800, 600);

        ImageIcon img = new ImageIcon("D:\\image.jpg");
        JLabel l1 = new JLabel("", img, JLabel.CENTER);
        l1.setBounds(0, 0, 800, 600);
        add(l1);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        

        
        

    }

    School() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


   
    public Connection get_con(){
        return con;
    }
    public Statement get_stmt(){return stmt; }

    public MenuSignInClient getSignInClient() {
        return signInClient;
    }

    public Register getReg() {
        return reg;
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


    public LookFor getLook_for()     {
        return look_for;
    }

    public String getLogin(){return getSignInClient().getLog()+getReg().getLog();}

    
    public void checkDiary() throws SQLException {
        ResultSet rs;
        String diary = "YOU HAVE THESE COURSES : \n";
        rs = stmt.executeQuery("select * from clients where login like '"+getLogin()+"'");
        while (rs.next()){
            diary+=rs.getString("titles")+ " on " + rs.getString("schedule") + "\n Name : " + rs.getString("name");
        }
        JOptionPane.showMessageDialog(School.this, diary);
    }

    
    public void switchFrame(Container x, Container y)
    {
        y.setVisible(false);
        x.setVisible(true);
    }

    

    
    
    
}
