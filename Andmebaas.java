package shuffleMyWeb;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import javax.swing.text.TableView;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Andmebaas{


// SQL Random veebileht Andmebaasist

  public Andmebaas(){

      /* SELECT column FROM table
      ORDER BY RANDOM()


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
      }*/
  }


}
