import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
    connector jcon =new connector();
    Connection con = jcon.databaseconnector();
    public Transaction() throws ClassNotFoundException, SQLException {
    }
    void banking(String tablename,int bal,int id) throws SQLException {
        try {
            con.setAutoCommit(false);
            String sql="update "+tablename+" set salary =salary+"+bal+" where id="+id;
            //update stud set balance = balance-500 where id =1;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            con.commit();
            System.out.println("success");
            con.close();
        }catch(SQLException e){
            if(con!=null){
                try{
                    con.rollback();
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }

        }
    }

}
