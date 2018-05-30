import java.sql.*;

public class PSDemo {
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String JDBC_URL = "jdbc:sqlserver:";
    static final String server = "//localhost\\Student";
    static final String database = "pemba";
    static final int port = 1433;

    public static void main(String[] args) {
        Connection connection;
        PreparedStatement statement;
        Statement statement1;
        String conString = JDBC_URL + server + ":" + port + ";databaseName=" + database + ";integratedSecurity=true";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Loaded");

            String server="//localhost\\Student";
            String database="pemba";
            int port= 1433;

            String jdbcUrl="jdbc:sqlserver:" + server + ":" + port + ";databaseName=" + database + ";integratedSecurity=true";

            Connection con = DriverManager.getConnection(jdbcUrl);
            System.out.println("Connection Obtained");
            System.out.println("Statement is created");
            //Updating Data
           /* String updateString="update student "+"set name =? "+" where rollno=?";
            statement=con.prepareStatement(updateString);
            statement.setString(1,"Pemba");
            statement.setInt(2,1);
            statement.executeUpdate();
            System.out.println("Record Updated");*/

            //Deleting Data
            String deleteString="Delete student "+" where rollno=?";
            statement=con.prepareStatement(deleteString);
            statement.setInt(1,1);
            statement.executeUpdate();
            System.out.println("Record Deleted");


            //Inserting Data
        /* String insertString="Insert into Student "+" values "+" (?,?)";
            statement= con.prepareStatement(insertString);
            statement.setString(1,"Sarbagya");
            statement.setInt(2,1);
            statement.executeUpdate();
            System.out.println("Record Inserted");
*/
          statement1= con.createStatement();
          String selectData="SELECT * from student";
          ResultSet resultSet= statement1.executeQuery("SELECT * from student;");

            while(resultSet.next()){
                System.out.println("The name of the student is " + resultSet.getString("name")
                        + " whose roll number is " + resultSet.getInt("rollno") + ".");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e){

        }
    }
}