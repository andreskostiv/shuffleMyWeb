package shuffleMyWeb;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Kasutajaliides extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public  void start(final Stage primaryStage){
        primaryStage.setTitle("ShuffleMyWeb");

        // UI ruudustikud, samad sõnad jätkuvad alam node'des
        GridPane gridAlgus = new GridPane(); // Avakuva
        GridPane gridSeaded = new GridPane(); // Seaded
        GridPane gridValjutud = new GridPane(); // Väljutud

        // Stseeni suuruse ja UI ruudustiku sidumine
        final Scene sceneAlgus = new Scene (gridAlgus, 600 , 500);
        final Scene sceneSeaded = new Scene (gridSeaded, 600 , 500);
        final Scene sceneValjutud = new Scene (gridValjutud, 600 , 500);



        //VAADE1: ALGUSE JAOKS:
        gridAlgus.setAlignment(Pos.CENTER);
        gridAlgus.setHgap(10);
        gridAlgus.setVgap(10);
        gridAlgus.setPadding(new Insets(25, 25, 25, 25));

        //button Valju
        Button valjuBtn = new Button ("Välju");
        valjuBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {primaryStage.setScene(sceneValjutud);
            }
        });
        HBox valjuHbox = new HBox(10);
        valjuHbox.setAlignment(Pos.TOP_LEFT);
        valjuHbox.getChildren().add(valjuBtn);
        gridAlgus.add(valjuHbox, 1,0);


        //Tekst intro
        Text introText = new Text ( " See rakendus pakub sulle suvalises järjekorras sinu " +
                "lemmikutesse salvestatud veebilehti.");
        gridAlgus.add(introText, 1, 2, 2, 1);


        //Nupp "Paku Lehti" ja all tekst URL
        Button pakuLehtiBtn = new Button ("Paku lehti");
        gridAlgus.add(pakuLehtiBtn, 1,6);
        final Text pakuURL = new Text();
        gridAlgus.add(pakuURL, 1, 5, 2, 1);
        pakuLehtiBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

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
                        pakuURL.setText(juhuslikUrl);
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch ( Exception e ) {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    System.exit(0);
                }

                    }
                });


        //button Seaded
        Button seadedBtn = new Button ("Seaded");
        seadedBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {primaryStage.setScene(sceneSeaded);
            }
        });
        HBox seadedHbox = new HBox(10);
        seadedHbox.setAlignment(Pos.BOTTOM_LEFT);
        seadedHbox.getChildren().add(seadedBtn);
        gridAlgus.add(seadedHbox, 1, 7);





        //VAADE2: SEADETE JAOKS:
        gridSeaded.setAlignment(Pos.CENTER);
        gridSeaded.setHgap(10);
        gridSeaded.setVgap(10);
        gridSeaded.setPadding(new Insets(25, 25, 25, 25));

        //tekst pais "seaded"
        Text seadedText = new Text ("Seaded");
        gridSeaded.add(seadedText, 1, 1, 2, 1) ;

        //tekst andmebaasi lehtedest "Minu veebilehed"
        Text minuVeebilehedText = new Text ("Minu veebilehed");
        gridSeaded.add(minuVeebilehedText, 1, 3, 2, 1);

        //button kustuta
        Button kustutaBtn = new Button ("Kustuta");
        kustutaBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // kustutus tegevus ja uue pildi kuvamine loop?
            }
        });
        HBox kustutaHbox = new HBox(10);
        kustutaHbox.setAlignment(Pos.BOTTOM_RIGHT);
        kustutaHbox.getChildren().add(kustutaBtn);
        gridSeaded.add(kustutaHbox, 1 , 4);

        //veebilehe lisamiseks textbox
        TextField veebiLisamineTextField = new TextField();
        gridSeaded.add(veebiLisamineTextField, 1, 5);

        //veebilehe lisamiseks nupp
        Button lisaVeebilehtBtn = new Button ("Lisa");
        final Text lisatudLehtText = new Text("http://www.loto.ee");
        lisaVeebilehtBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gridSeaded.add(lisatudLehtText, 1, 6, 2, 1);
            }
        });
        gridSeaded.add(lisaVeebilehtBtn, 1,7);

        //button Algusesse
        Button algusesseBtn2 = new Button ("Algusesse");
        algusesseBtn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {primaryStage.setScene(sceneAlgus);
            }
        });
        gridSeaded.add(algusesseBtn2, 1 , 8);



        //VAADE3: Väljutud jaoks
        gridValjutud.setAlignment(Pos.CENTER);
        gridValjutud.setHgap(10);
        gridValjutud.setVgap(10);
        gridValjutud.setPadding(new Insets(25, 25, 25, 25));

        //Kuva tekst "Rakendusest väljutud"
        //tekst pais "seaded"
        Text valjutudText = new Text ("Rakendustest väljutud.");
        gridValjutud.add(valjutudText, 0, 2, 2, 1) ;



        primaryStage.setScene(sceneAlgus);
        primaryStage.show();
    }
}