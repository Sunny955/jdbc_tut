import java.sql.*;
public class jdbc1 {
    public static void main(String args[]) {
        try{
            // load the driver
            Class.forName("com.mysql.jdbc.Driver");

            // creating connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","");

            if(con.isClosed()){
                System.out.println("Connection is closed!!");
            }else {
                System.out.println("Connection created!");
            }

            // SQL queries
            String q = "select * from employees limit 50";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);

            // process the data
            while(rs.next()) {
                int emp_no = rs.getInt(1);
                String first_name = rs.getString(3);
                String last_name = rs.getString(4);

                System.out.println("Employee number "+emp_no+" First Name "+first_name+" Last Name "+last_name);
            }
            //closing connection
            con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}