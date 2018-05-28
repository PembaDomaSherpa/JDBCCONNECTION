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
        String conString = JDBC_URL + server + ":" + port + ";databaseName=" + database + ";integratedSecurity=true";
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(conString);
            String sql = "update STUDENT set name=? where rollNo=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"Dolma");
            statement.setInt(2,4);
            statement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e){

        }
    }
}