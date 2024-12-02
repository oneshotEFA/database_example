import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Updatee ins = new Updatee();
        //ins.insert(4,"sykebd","siyayel");
       // ins.updatedata("customer","customerFname","'tesfalemmm'",3);
        //ins.deletedata(2,"customer");
        //ins.addAttribut("customer","email","varchar(30)");
        //ins.metadata("banking");
        /*Transaction tr = new Transaction();
        tr.banking("banking",2000,1);*/
     //ins.procuders("customer");s
        ins.read("customer");
        System.out.println("heloo");
        }
    }
