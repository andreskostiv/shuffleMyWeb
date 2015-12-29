package shuffleMyWeb;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Kasutajaliides extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public  void start(final Stage primaryStage){
        primaryStage.setTitle("ShuffleMyWeb");

        Group groupAlgus = new Group(); //Algus
        Group groupSeaded = new Group(); //Seaded
        Group groupValjutud = new Group(); //Väljutud

        final Scene sceneAlgus = new Scene (groupAlgus, 600 , 500);
        final Scene sceneSeaded = new Scene (groupSeaded, 600 , 500);
        final Scene sceneValjutud = new Scene (groupValjutud, 600 , 500);


        //VAADE1: ALGUSE JAOKS:
        GridPane gridAlgus = new GridPane();
        gridAlgus.setAlignment(Pos.CENTER);
        gridAlgus.setHgap(10);
        gridAlgus.setVgap(10);
        gridAlgus.setPadding(new Insets(25, 25, 25, 25));
        groupAlgus.getChildren().addAll(gridAlgus);

        //button Valju
        Button valjuBtn = new Button ("Välju");
        valjuBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {primaryStage.setScene(sceneValjutud);
            }
        });
        HBox valjuHbox = new HBox(10);
        valjuHbox.setAlignment(Pos.TOP_RIGHT);
        valjuHbox.getChildren().add(valjuBtn);
        gridAlgus.add(valjuHbox, 1,0);

        //tekst intro
        Text introText = new Text ( " See rakendus pakub sulle suvalises järjekorras sinu " +
                "lemmikutesse salvestatud veebilehti.");
        gridAlgus.add(introText, 0, 2, 2, 1);

        //veebiaadress ning nupp "Paku veel"
        Button pakuVeelBtn = new Button ("Paku veel");
        final Text pakutudLehtText = new Text("http://www.delfi.ee");
        pakuVeelBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gridAlgus.add(pakutudLehtText, 1, 2, 2, 1);
            }
        });
        HBox pakuVeelHbox = new HBox(10);
        pakuVeelHbox.setAlignment(Pos.CENTER);
        pakuVeelHbox.getChildren().add(pakuVeelBtn);
        gridAlgus.add(pakuVeelHbox, 1,3);


        //button Seaded
        Button seadedBtn = new Button ("Seaded");
        seadedBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {primaryStage.setScene(sceneSeaded);
            }
        });
        HBox seadedHbox = new HBox(10);
        seadedHbox.setAlignment(Pos.BOTTOM_LEFT);
        seadedHbox.getChildren().add(seadedBtn);
        gridAlgus.add(seadedHbox, 1,5);



        //VAADE3: SEADETE JAOKS:
        GridPane gridSeaded = new GridPane();
        gridSeaded.setAlignment(Pos.CENTER);
        gridSeaded.setHgap(10);
        gridSeaded.setVgap(10);
        gridSeaded.setPadding(new Insets(25, 25, 25, 25));
        groupSeaded.getChildren().addAll(gridSeaded);

        //tekst pais "seaded"
        Text seadedText = new Text ("Seaded");
        gridSeaded.add(seadedText, 0, 2, 2, 1) ;

        //tekst andmebaasi lehtedest "Minu veebilehed"
        Text minuVeebilehedText = new Text ("Minu veebilehed");
        gridSeaded.add(minuVeebilehedText, 0, 3, 2, 1);

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
        gridSeaded.add(kustutaHbox, 4 , 4);

        //veebilehe lisamiseks textbox
        TextField veebiLisamineTextField = new TextField();
        gridSeaded.add(veebiLisamineTextField, 1, 5);

        //veebilehe lisamiseks nupp
        Button lisaVeebilehtBtn = new Button ("Lisa");
        final Text lisatudLehtText = new Text("http://www.delfi.ee");
        pakuVeelBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gridAlgus.add(lisatudLehtText, 1, 6, 2, 1);
            }
        });
        HBox lisaVeebilehtHbox = new HBox(10);
        lisaVeebilehtHbox.setAlignment(Pos.CENTER);
        lisaVeebilehtHbox.getChildren().add(lisaVeebilehtBtn);
        gridSeaded.add(lisaVeebilehtHbox, 1,3);

        //button Algusesse
        Button algusesseBtn2 = new Button ("Algusesse");
        algusesseBtn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {primaryStage.setScene(sceneAlgus);
            }
        });
        HBox algusesse2Hbox = new HBox(10);
        algusesse2Hbox.setAlignment(Pos.BOTTOM_RIGHT);
        algusesse2Hbox.getChildren().add(algusesseBtn2);
        gridSeaded.add(algusesse2Hbox, 4 , 5);


        //VAADE4: Väljutud jaoks
        GridPane gridValjutud = new GridPane();
        gridValjutud.setAlignment(Pos.CENTER);
        gridValjutud.setHgap(10);
        gridValjutud.setVgap(10);
        gridValjutud.setPadding(new Insets(25, 25, 25, 25));
        groupValjutud.getChildren().addAll(gridValjutud);

        //Kuva tekst "Rakendusest väljutud"
        //tekst pais "seaded"
        Text valjutudText = new Text ("Rakendustest väljutud.");
        gridValjutud.add(valjutudText, 0, 2, 2, 1) ;



        primaryStage.setScene(sceneAlgus);
        primaryStage.show();
    }
}