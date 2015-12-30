package shuffleMyWeb;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Andmebaas{


// SQL Random veebileht Andmebaasist

  Andmebaas(){

      /* SELECT column FROM table
      ORDER BY RANDOM()
      LIMIT 1*/

      String juhuslikUrl;
      Connection c = null;
      Statement stmt = null;
      try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
          c.setAutoCommit(false);
          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT URL FROM DATABASE ORDER BY RANDOM() LIMIT 1;" );

          while ( rs.next() ) {
              String url = rs.getString("url");

              juhuslikUrl = "Vaata näiteks seda lehte: " + url;
              System.out.println(juhuslikUrl);

          }
          rs.close();
          stmt.close();
          c.close();
      } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
      }

  }

    /*
    public String time_to_string(long t) // time in milliseconds
{
    if (t < 0)
    {
        return "-";
    }
    else
    {
        int secs = (int)(t/1000);
        int mins = secs/60;
        secs = secs - (mins * 60);
        return String.format("%d:%02d", mins, secs);
    }
}
     */

// SQL Veebilehe lisamine andmebaasi

// SQL Veebilehtede aruanne andmebaasist, ajutine ID

// SQL veebilehe kustutamine andmebaasiste ajutise ID abil




}
