import javax.xml.transform.Result;
import java.sql.*;

class Jdbc_Connection {
    public static void main(String[] args) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Loaded");

            String server="//localhost\\Student";
            String database="pemba";
            int port= 1433;

            String jdbcUrl="jdbc:sqlserver:" + server + ":" + port + ";databaseName=" + database + ";integratedSecurity=true";

            Connection con = DriverManager.getConnection(jdbcUrl);
            System.out.println("Connection Obtained");
            Statement statement= con. createStatement();
            System.out.println("Statement is created");
            ResultSet resultSet= statement.executeQuery("SELECT * from student;");

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