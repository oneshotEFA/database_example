import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {
    Connection databaseconnector() throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/datastore";
        Connection con = DriverManager.getConnection(url,"root","1221");
        return con;
    }
}
