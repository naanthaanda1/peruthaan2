import java.sql.*;
import java.util.Scanner;
public class selectqueary {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("inset data into table");
        System.out.println("enter the c_id ");
       int c_id = sc.nextInt();
        System.out.println("enter the c_name ");
      String c_name=sc.nextLine() ;
        System.out.println("enter the  b_id");
        int b_id = sc.nextInt();
        System.out.println("enter the b_name");
       String b_name=sc.nextLine();
        System.out.println("enter the cont_number");
        int cont_number = sc.nextInt();
        System.out.println("enter the c_pan");
        String c_pan=sc.nextLine();
        System.out.println("enter the c_adher");
        String c_adher=sc.nextLine();
        System.out.println("enter the  a_number");
        int a_number=sc.nextInt();
        System.out.println("enter the a_balance");
        int a_balance = sc.nextInt();
        System.out.println("enter the a_pin");
        int a_pin = sc.nextInt();
        System.out.println("enter the a_type");
        String a_type=sc.nextLine();
        System.out.println("enter the c_age");
        int    c_age = sc.nextInt();
        insertquery(c_id, c_name, b_id, b_name, cont_number, c_pan, c_adher, a_number, a_balance, a_pin, a_type, c_age);
        selectquery();
        System.out.println("update name into the table");
        System.out.println("enter customer id");
        int C_id = sc.nextInt();
        System.out.println("enter the new name");
        String C_name=sc.nextLine() ;
         updatename(C_id,C_name);
          selectquery();
        System.out.println("delet element in the table");
        System.out.println("enter the id");
        int C_ID = sc.nextInt();
         deletquery(C_ID);
          selectquery();
        System.out.println("check balance");

        checkbalance();
        System.out.println("update pin");
        int ID=sc.nextInt();
        int new_pin=sc.nextInt();
        updatpin(ID,new_pin);
        selectquery();
        System.out.println("update contnumber");
        int c_ID=sc.nextInt();
        int new_number=sc.nextInt();
        updatcont_number(c_ID,new_number);
        selectquery();

    }


    public static void selectquery() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("Select * from customer");
        while (rs.next()) {
            System.out.println(rs.getInt("c_id") + " " + rs.getString("c_name") + " " + rs.getInt("b_id") + " " + rs.getString("b_name") + " " + rs.getInt("cont_number") + " " + rs.getString("c_pan") + " " + rs.getString("c_adher") + " " + rs.getInt("a_number") + " " + rs.getInt("a_balance") + " " + rs.getInt("a_pin") + " " + rs.getString("a_type") + " " + rs.getInt("c_age") + " ");
        }
    }

    public static void insertquery(int c_id, String c_name, int b_id, String b_name, int cont_number, String c_pan, String c_adher, int a_number, int a_balance, int a_pin, String a_type, int c_age) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        PreparedStatement ps = con.prepareStatement("insert into bank.customer values(?,?,?,?,?,?,?,?,?,?,?,?)");

        ps.setInt(1, c_id);
        ps.setString(2, c_name);
        ps.setInt(3, b_id);
        ps.setString(4, b_name);
        ps.setInt(5, cont_number);
        ps.setString(6, c_pan);
        ps.setString(7, c_adher);
        ps.setInt(8, a_number);
        ps.setInt(9, a_balance);
        ps.setInt(10, a_pin);
        ps.setString(11, a_type);
        ps.setInt(12, c_age);
        int row = ps.executeUpdate();
        if (row > 0) {
            System.out.println("inserted sucessfuly");
        } else {
            System.out.println("not inserted");
        }


    }

    public static void updatename(int C_id, String C_name) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        PreparedStatement ps = con.prepareStatement("update bank.customer set c_name=? where c_id=?");
        ps.setString(1, C_name);
        ps.setInt(2, C_id);


        int row = ps.executeUpdate();
        if (row > 0) {
            System.out.println("updated sucessfuly");
        } else {
            System.out.println("not updated");
        }

    }

    public static void deletquery(int c_id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        PreparedStatement ps = con.prepareStatement("delete from bank.customer where c_id=?");

        ps.setInt(1, c_id);


        int row = ps.executeUpdate();
        if (row > 0) {
            System.out.println("deleted sucessfuly");
        } else {
            System.out.println("not delete");
        }

    }

    public static void checkbalance() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("Select * from customer  ");
        while (rs.next()) {
            System.out.println(rs.getInt("c_id") + " " +rs.getInt("a_balance"));
        }
    }
    public static void updatpin(int c_id, int a_pin) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        PreparedStatement ps = con.prepareStatement("update bank.customer set a_pin=? where c_id=?");
        ps.setInt(1, a_pin);
        ps.setInt(2, c_id);


        int row = ps.executeUpdate();
        if (row > 0) {
            System.out.println("updated sucessfuly");
        } else {
            System.out.println("not updated");
        }

    }
    public static void updatcont_number(int c_ID, int new_number ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        PreparedStatement ps = con.prepareStatement("update bank.customer set cont_number =? where c_id=?");
        ps.setInt(1, new_number);
        ps.setInt(2, c_ID);


        int row = ps.executeUpdate();
        if (row > 0) {
            System.out.println("updated sucessfuly");
        } else {
            System.out.println("not updated");
        }

    }
}