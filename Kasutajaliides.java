package shuffleMyWeb;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
Antud rakendus pakub suvalises järjekorras veebilehe URLe. Rakendusse saab lisada ning kustutada lemmik veebilehti.
Rrogramm suhtleb SQLite andmebaasiga shuffle2.db ning kasutab JavaFX kasutajaliidest.
 */

public class Kasutajaliides extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("ShuffleMyWeb");

        // UI ruudustikud, samad sõnad jätkuvad alam node'des
        GridPane gridAlgus = new GridPane(); // Avakuva
        GridPane gridSeaded = new GridPane(); // Seaded
        GridPane gridValjutud = new GridPane(); // Väljutud

        // Stseeni suuruse ja UI ruudustiku sidumine
        final Scene sceneAlgus = new Scene(gridAlgus, 700, 600);
        final Scene sceneSeaded = new Scene(gridSeaded, 700, 600);
        final Scene sceneValjutud = new Scene(gridValjutud, 700, 600);


        //VAADE1: ALGUSE JAOKS:
        gridAlgus.setAlignment(Pos.CENTER);
        gridAlgus.setHgap(10);
        gridAlgus.setVgap(10);
        gridAlgus.setPadding(new Insets(25, 25, 25, 25));

        //button Valju
        Button valjuBtn = new Button("Välju");
        valjuBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(sceneValjutud);
            }
        });
        gridAlgus.add(valjuBtn, 9, 0);


        //Tekst intro
        Text introText = new Text(" See rakendus pakub sulle suvalises järjekorras sinu " +
                "salvestatud veebilehti.");
        gridAlgus.add(introText, 1, 2, 2, 1);


        //Nupp "Paku Lehti" ja all tekst URL
        Button pakuLehtiBtn = new Button("Paku lehti");
        gridAlgus.add(pakuLehtiBtn, 1, 6);

        final Hyperlink pakuURL = new Hyperlink();
        gridAlgus.add(pakuURL, 1, 5, 2, 1);
        // kood mudetud, kuid templiit on siit: //http://www.tutorialspoint.com/sqlite/sqlite_java.html
        String juhuslikUrl;
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT URL FROM DATABASE ORDER BY RANDOM() LIMIT 1;");

            while (rs.next()) {
                String url = rs.getString("url");

                juhuslikUrl = url;
                pakuURL.setText(juhuslikUrl);

                pakuURL.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        getHostServices().showDocument(url);
                    }
                });

                pakuLehtiBtn.setText("Paku veel lehti");

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }



        pakuLehtiBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                String juhuslikUrl;
                // kood mudetud, kuid templiit on siit: //http://www.tutorialspoint.com/sqlite/sqlite_java.html
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
                    c.setAutoCommit(false);
                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT URL FROM DATABASE ORDER BY RANDOM() LIMIT 1;");

                    while (rs.next()) {
                        String url = rs.getString("url");

                        juhuslikUrl = url;
                        pakuURL.setText(juhuslikUrl);

                        pakuURL.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent t) {
                                getHostServices().showDocument(url);
                            }
                        });

                        pakuLehtiBtn.setText("Paku veel lehti");

                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }

            }
        });


        //button Seaded
        Button seadedBtn = new Button("Seaded");
        seadedBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(sceneSeaded);
            }
        });
        gridAlgus.add(seadedBtn, 1, 13);


        //VAADE2: SEADETE JAOKS:
        gridSeaded.setAlignment(Pos.CENTER);
        gridSeaded.setHgap(10);
        gridSeaded.setVgap(10);
        gridSeaded.setPadding(new Insets(25, 25, 25, 25));

        //tekst pais "seaded"
        Text seadedText = new Text("Seaded");
        gridSeaded.add(seadedText, 1, 1, 2, 1);

        //tekst sisetamise juhend
        Text sisetamineText = new Text("Sisesta siia veeb kujul www..");
        gridSeaded.add(sisetamineText, 0, 3, 2, 1);

        //veebilehe lisamiseks textbox
        TextField lisaURLTextField = new TextField();
        gridSeaded.add(lisaURLTextField,0,4,2,1);

        //veebilehe lisamiseks nupp ja tekst edukalt sisestatud
        Button lisaVeebilehtBtn = new Button("Lisa andmebaasi");
        gridSeaded.add(lisaVeebilehtBtn,0,5);

        Text edukaltSisestatud = new Text();
        gridSeaded.add(edukaltSisestatud, 0, 6);

        // Tabel, et kuvada lehti SQL baasist
        TableView tabel = new TableView();

        gridSeaded.add(tabel, 2, 4, 1, 10);

        ObservableList<ObservableList> data;
        data = FXCollections.observableArrayList();

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT rowid, url FROM DATABASE;" );

            // Kood lisatud ja ise muudetudsiit:
            // http://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/comment-page-2/
            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){

                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {

                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tabel.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();

                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

                //FINALLY ADDED TO TableView
                tabel.setItems(data);


            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        // Lisa veebileht nupule vajutamise tegevus
        lisaVeebilehtBtn.setOnAction(new EventHandler<ActionEvent>()

             {
                 public void handle(ActionEvent event) {
                     String urlBaasi = lisaURLTextField.getText();
                     // kood mudetud, kuid templiit on siit: //http://www.tutorialspoint.com/sqlite/sqlite_java.html
                     Connection c = null;
                     Statement stmt = null;
                     try {
                         Class.forName("org.sqlite.JDBC");
                         c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
                         c.setAutoCommit(false);

                         stmt = c.createStatement();
                         String sql = "INSERT INTO DATABASE (URL) " +
                                 "VALUES (" + "'http://" + urlBaasi + "'" + ")";
                         stmt.executeUpdate(sql);

                         stmt.close();
                         c.commit();
                         c.close();
                     } catch (Exception e) {
                         System.err.println(e.getClass().getName() + ": " + e.getMessage());
                         System.exit(0);
                     }
                     edukaltSisestatud.setText(urlBaasi + " lisatud");

                     gridSeaded.getChildren().remove(tabel);
                     TableView tabel = new TableView();
                     gridSeaded.add(tabel, 2, 4, 1, 10);


                     ObservableList<ObservableList> data;
                     data = FXCollections.observableArrayList();

                     try {
                         Class.forName("org.sqlite.JDBC");
                         c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
                         c.setAutoCommit(false);

                         stmt = c.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT rowid, url FROM DATABASE;");

                         // Kood lisatud ja ise muudetudsiit:
                         // http://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/comment-page-2/
                         /**********************************
                          * TABLE COLUMN ADDED DYNAMICALLY *
                          **********************************/

                         for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                             //We are using non property style for making dynamic table
                             final int j = i;
                             TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                             col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {

                                 public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {

                                     return new SimpleStringProperty(param.getValue().get(j).toString());
                                 }
                             });

                             tabel.getColumns().addAll(col);
                             System.out.println("Column [" + i + "] ");
                         }

                         /********************************
                          * Data added to ObservableList *
                          ********************************/
                         while (rs.next()) {
                             //Iterate Row
                             ObservableList<String> row = FXCollections.observableArrayList();

                             for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                                 //Iterate Column
                                 row.add(rs.getString(i));
                             }
                             data.add(row);

                             //FINALLY ADDED TO TableView
                             tabel.setItems(data);


                         }

                         rs.close();
                         stmt.close();
                         c.close();
                     } catch (Exception e) {
                         System.err.println(e.getClass().getName() + ": " + e.getMessage());
                         System.exit(0);
                     }


                 }
             }

        );


        //tekst kustutamise juhend
        Text kustutamiseText = new Text("Kustutamiseks kirjuta rowid number:");
        gridSeaded.add(kustutamiseText, 0, 8, 2, 1);

        //veebilehe lisamiseks textbox
        TextField kustutaURLTextField = new TextField();
        gridSeaded.add(kustutaURLTextField,0,9,1,1);

        //button kustuta ja tagasisidetekst edukast kustutamisest
        Button kustutaBtn = new Button("Kustuta");
        gridSeaded.add(kustutaBtn,0,10,1,1);

        Text kustutatudText = new Text();
        gridSeaded.add(kustutatudText, 0, 11, 1, 1);


        kustutaBtn.setOnAction(new EventHandler<ActionEvent>()

           {
               public void handle(ActionEvent event) {
                   String idKustuta = kustutaURLTextField.getText();
                   // kood muudetud, kuid templiit on siit: //http://www.tutorialspoint.com/sqlite/sqlite_java.html
                   Connection c = null;
                   Statement stmt = null;
                   try {
                       Class.forName("org.sqlite.JDBC");
                       c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
                       c.setAutoCommit(false);
                       System.out.println("Andmebaasiga edukalt ühendatud");

                       stmt = c.createStatement();
                       String sql = "DELETE from DATABASE where rowid=" + idKustuta;
                       stmt.executeUpdate(sql);
                       c.commit();

                   } catch (Exception e) {
                       System.err.println(e.getClass().getName() + ": " + e.getMessage());
                       System.exit(0);
                   }
                   kustutatudText.setText("rowid "+ idKustuta + " kustutatud");

                   // värskendab andmebaasi tabelit
                   gridSeaded.getChildren().remove(tabel);
                   TableView tabel = new TableView();
                   gridSeaded.add(tabel, 2, 4, 1, 10);


                   ObservableList<ObservableList> data;
                   data = FXCollections.observableArrayList();

                   try {
                       Class.forName("org.sqlite.JDBC");
                       c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
                       c.setAutoCommit(false);

                       stmt = c.createStatement();
                       ResultSet rs = stmt.executeQuery("SELECT rowid, url FROM DATABASE;");

                       // Kood lisatud ja ise muudetud siit:
                       // http://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/comment-page-2/
                       /**********************************
                        * TABLE COLUMN ADDED DYNAMICALLY *
                        **********************************/

                       for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                           //We are using non property style for making dynamic table
                           final int j = i;
                           TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                           col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {

                               public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {

                                   return new SimpleStringProperty(param.getValue().get(j).toString());
                               }
                           });

                           tabel.getColumns().addAll(col);
                           System.out.println("Column [" + i + "] ");
                       }

                       /********************************
                        * Data added to ObservableList *
                        ********************************/
                       while (rs.next()) {
                           //Iterate Row
                           ObservableList<String> row = FXCollections.observableArrayList();

                           for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                               //Iterate Column
                               row.add(rs.getString(i));
                           }
                           System.out.println("Row [1] added " + row);
                           data.add(row);

                           //FINALLY ADDED TO TableView
                           tabel.setItems(data);


                       }

                       rs.close();
                       stmt.close();
                       c.close();
                   } catch (Exception e) {
                       System.err.println(e.getClass().getName() + ": " + e.getMessage());
                       //System.exit(0);

                   }

               }
           }

        );



        //button Algusesse
        Button algusesseBtn2 = new Button("Algusesse");
        algusesseBtn2.setOnAction(new EventHandler<ActionEvent>()

          {
              public void handle (ActionEvent event){
                  primaryStage.setScene(sceneAlgus);
              }
          }

        );
        gridSeaded.add(algusesseBtn2,0,13);


        //VAADE3: Väljutud jaoks
        gridValjutud.setAlignment(Pos.CENTER);
        gridValjutud.setHgap(10);
        gridValjutud.setVgap(10);
        gridValjutud.setPadding(new

                        Insets(25,25,25,25)

        );

        //Kuva tekst "Rakendusest väljutud"
        //tekst pais "seaded"


        Text valjutudText = new Text("Rakendustest väljutud.");
        gridValjutud.add(valjutudText,0,2,2,1);


        primaryStage.setScene(sceneAlgus);
        primaryStage.show();
    }
}
