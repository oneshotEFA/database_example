import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class rowset {
    public static void main(String[] args) throws SQLException {
        JdbcRowSet jrs = RowSetProvider.newFactory().createJdbcRowSet();
        jrs.setUrl("jdbc:mysql://localhost:3306/first");
        jrs.setUsername("root");
        jrs.setPassword("1221");
        jrs.setCommand("select * from banking");
        jrs.execute();
    }
}
