package shuffleMyWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//http://www.tutorialspoint.com/sqlite/sqlite_java.htm

public class DbCreateTable

{
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:shuffle.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE DATABASE " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " URL           TEXT    NOT NULL)";



            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}