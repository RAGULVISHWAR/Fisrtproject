import java.sql.*;
import java.util.Scanner;

public class jdbcdemo {
    public static void main(String[] args) throws Exception {
        insert();
        records();
        }
    public static void records() throws Exception
    {
         String url = "jdbc:mysql://localhost:3306/demo";
         String user = "root";
         String pass = "0000";
         String query = "select * from employee";
         Connection conn = DriverManager.getConnection(url,user,pass);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
         rs.next();
         while (rs.next()) {
              System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
         }
         conn.close();
    }
    public static void insert() throws Exception
    {
         Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String pass = "0000";
        Connection conn = DriverManager.getConnection(url,user,pass);
        PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?)");
        for(int i=0;i<1;i++)
        {
            int a=sc.nextInt();
            String b=sc.next();
            int c=sc.nextInt();
            ps.setInt(1,a);
            ps.setString(2,b);
            ps.setInt(3,c);
            ps.executeUpdate();
        }
        conn.close();
    }
}