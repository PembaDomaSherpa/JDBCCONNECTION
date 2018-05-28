import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DDL_DML {
    public static void main(String[] args) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Loaded");

            String server="//localhost\\Student";
            String database="pemba";
            int port= 1433;

            String jdbcUrl="jdbc:sqlserver:" + server + ":" + port + ";databaseName=" + database + ";integratedSecurity=true";

            Connection con = DriverManager.getConnection(jdbcUrl);
            Statement statement= con. createStatement();

            //Creating new table
            String createString="Create table mbmc"+"(Name varchar(20),"+"Rollno integer)";
            statement.executeUpdate(createString);
            System.out.println("Table Created");

            //1. INSERTING INTO TABLE
            String insertdata= "INSERT into mbmc values('Rinju Manandhar',4)";
            statement.executeUpdate(insertdata);
            System.out.println("Record Inserted");

            //2.UPDATING INTO TABLE
            String updateString="UPDATE mbmc SET rollno=7 WHERE Name='Rinju Manandhar'";
            statement.executeUpdate(updateString);
            System.out.println("Record Updated");

            //3.DELETING FROM TABLE
            String deleteString="DELETE FROM mbmc WHERE name='Rinju Manandhar'";
            statement.executeUpdate(deleteString);
            System.out.println("Records Deleted");
            //4.Getting Data from database
            ResultSet resultSet= statement.executeQuery("SELECT * from mbmc;");

            while(resultSet.next()) {
                System.err.println("The name of the student is " + resultSet.getString("name")
                        + " whose roll number is " + String.valueOf(resultSet.getInt("rollno")) + ".");
            }
            resultSet.close();
            statement.close();
            con.close();
            System.out.println("Resources released");
        }catch(Exception ex) {
            System.out.println("Exception is:" + ex);
        }
    }
}