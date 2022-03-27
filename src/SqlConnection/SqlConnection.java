package SqlConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnection {
    private Connection connection=null;
    private Statement statement=null;
    private String url = "//localhost:5432/TESTS";

    public SqlConnection() {

    }

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            connection= DriverManager.getConnection
                    ("jdbc:postgresql:"+url,"postgres","rannrann4545");
            //System.out.println("Done!!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.connection;
    }

    public Statement getStatement() {
        try {
            statement=this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
