import java.sql.*;

public class Updatee  {
    connector instanceconnector = new connector();

    public Updatee() throws SQLException, ClassNotFoundException {
    }
    void insert(int id,String fname,String lname) throws SQLException, ClassNotFoundException
    {
        Connection con=instanceconnector.databaseconnector();
        System.out.println("connected");
        PreparedStatement pst=con.prepareStatement("insert into customer values(?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, fname);
        pst.setString(3, lname);
        pst.executeUpdate();
        System.out.println("insert completed");
        con.close();
    }
    void read(String tablename) throws SQLException, ClassNotFoundException {
        Connection con=instanceconnector.databaseconnector();
        String sql="select * from "+tablename;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt(1);
            String fname = rs.getString(2);
            String lname = rs.getString(3);
            String email = rs.getString(4);
            System.out.println(id+"  "+fname+"  "+lname + email);
        }
        con.close();
    }
    void metadata(String tablename) throws SQLException, ClassNotFoundException {
        Connection con=instanceconnector.databaseconnector();
        Statement st =con.createStatement();
        ResultSet rs = st.executeQuery("select * from "+tablename);
       DatabaseMetaData meta = con.getMetaData();
       ResultSetMetaData meta1 = rs.getMetaData();
        //ResultSet rs = meta.getColumns(null+,null,tablename,null);
        System.out.println(meta1.getColumnName(0));
//        while (rs.next()) {
//            int cout=1;
//            System.out.println("Attribuites of tabel: "+cout+"  "+rs.getString("COLUMN_NAME"));
//        }
    }
    void deletedata(int id,String tablename) throws SQLException, ClassNotFoundException {
        Connection con=instanceconnector.databaseconnector();
        String sql = "delete from "+tablename+" where cusomerid="+id;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        con.close();
    }
    void addAttribut(String tablename,String colname,String type) throws SQLException, ClassNotFoundException {
        Connection con = instanceconnector.databaseconnector();
        String sql ="alter table "+tablename+" add column "+colname+" "+type;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        con.close();
        System.out.println("attribute added");
    }
    void updatedata(String tablename,String colname,String newCol,int id) throws SQLException, ClassNotFoundException {
        Connection con = instanceconnector.databaseconnector();
        //String sql1 ="update customer set customerfname= 'tesfalem' where cusomerid = '3'";
        String sql="update "+tablename+" set "+colname+" = "+ newCol +" where cusomerid="+id;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        con.close();
        System.out.println("attribute updated");
    }
    void procuders(String tablename) throws SQLException, ClassNotFoundException {
        Connection con=instanceconnector.databaseconnector();
        CallableStatement cstmt = con.prepareCall("{call add_val(?,?,?,?)}");
        cstmt.setInt(1,20);
        cstmt.setString(2,"procuder");
        cstmt.setString(3,"lname");
        cstmt.setString(4,"email");
        cstmt.execute();
        System.out.println("procuder added");
    }
}
