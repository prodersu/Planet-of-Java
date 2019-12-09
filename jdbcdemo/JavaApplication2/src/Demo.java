import java.sql.*;

public class Demo {
    public static void main (String []args) throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        String user = "student";
        String pass = "student";
        String erlan = "erlan";
        int i = 6;
        
        try{
            //demo is database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", user, pass);
            myStmt = myConn.createStatement();
            insert(myConn,"alikhan", "alikhan");
            myRs = myStmt.executeQuery("select * from players");
            
            //players is table
            //PreparedStatement ins = myConn.prepareStatement("INSERT INTO players (name, surname) VALUES('"+erlan+"','"+erlan+"')");
            while(myRs.next()){
                System.out.println(myRs.getString("surname") + ", " + myRs.getString("name"));
                //surname and name is columns
        }
            
        }catch(Exception exc){
            exc.printStackTrace();
        }finally{
            if(myRs!=null){
            myRs.close();}
            if(myStmt!= null){
            myStmt.close();}
            if(myConn!=null){
            myConn.close();
           }
        }
        
    
    }
    private static void insert(Connection con, String name, String surname) throws SQLException {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO players (name, surname) VALUES (?, ?)");
            
            stmt.setString(1, name);
            stmt.setString(2, surname);
        
            stmt.executeUpdate();
            stmt.close();
    }
    //private static void insert_ad(Connection con, String title, String master, String schedule,
                                  //int price, String style, String gender, String indiv_group)
}

