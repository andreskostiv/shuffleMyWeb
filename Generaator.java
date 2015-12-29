package shuffleMyWeb;

import Katsetamine.AkenMisTeebImesid;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Generaator { // Klass generaator


    private StackPane Stack;
    private Scene Scene;
    private Stage Stage;
    private int AknaSuurus;



    private void start(Stage Aken)throws Exception{

        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 400, 400);
        Aken.setScene(scene);
        Aken.setTitle("Algus");

        VBox reakesed = new VBox();
        reakesed.setAlignment(Pos.CENTER);
        reakesed.setSpacing(50);
        stack.getChildren().add(reakesed);

        AnchorPane paiseNupud = new AnchorPane();
        Button Valja = new Button("Valja");
        paiseNupud.getChildren().add(Valja);
        paiseNupud.setRightAnchor(Valja, 10.0);
        reakesed.getChildren().add(paiseNupud);

        Label tadaa = new Label();
        tadaa.setWrapText(true);
        tadaa.setText("See rakendus pakub sulle suvalises järjekorras sinu lemmikutesse salvestatud veebilehti.");
        reakesed.getChildren().add(tadaa);

        Button Go = new Button("Go");
        reakesed.getChildren().add(Go);

        AnchorPane jaluseNupud = new AnchorPane();
        Button Seaded = new Button("Seaded");
        jaluseNupud.getChildren().add(Seaded);
        jaluseNupud.setLeftAnchor(Seaded, 10.0);
        reakesed.getChildren().add(jaluseNupud);



        Aken.show();




        /*Stage = new Stage();
        Stack = new StackPane();
        Scene = new Scene (Stack, AknaSuurus, AknaSuurus);
        Stage.setScene(Scene);
        Stage.show();
        Stage.setOnCloseRequest(event -> System.exit(0));
        */

    }

    void Algus() {

        ;   //Joonistab akna

        Scanner sc = new Scanner(System.in); //1.	Valik, kas minna lehitsema, settingutesse või välja
        System.out.println();
        System.out.println("Oled alguses");
        System.out.println("palun kirjuta valik:");
        System.out.println("1-lehitsema; 2-settingutesse; 3-välja");
        int valitud = sc.nextInt();
        System.out.printf("Sinu valik on %d", valitud);
        System.out.println();
        switch (valitud){
            case 1:
                rakendus();
                break;
            case 2:
                Settingud();
                break;
            case 3:
                System.out.println("järgmisena väljun programmist");
                break;

        }

    }

    void Settingud() {
        /*  Valik kas kas lisada- või kustutada veebilehti, katkestada
        ja minna algusesse või salvestada ja minna algusesse */


        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Oled settingutes");
        System.out.println("Salvestatud veebilehed");
        System.out.println();
        AndmeKuvamine();
        System.out.println();

        System.out.println("Palun kirjuta valik:");
        System.out.println("1-lisada veebilehti; 2-kustutada veebilehti; 3-katkestada ja minna algusesse");
        int valitud = sc.nextInt();
        System.out.printf("Sinu valik on %d", valitud);
        System.out.println();
        switch (valitud) {
            case 1:
                System.out.println("järgmisena lisan veebilehti");
                System.out.println();
                AndmeKuvamine();
                AndmeSisetus();
                break;
            case 2:
                System.out.println("järgmisena kustutan veebilehti");
                System.out.println();
                AndmeKuvamine();
                AndmeKustutamine();
                break;
            case 3:
                Algus();
                break;

        }
    }

    void rakendus() { // Klassis on Meetod rakendus mille ülesanne on massiivist suvalisi veebilehti väljastada

        System.out.println("Siin kuvatakse sulle suvalises järjekorras veebilehti");
        System.out.println();

        for (int valikRakendus = 0; valikRakendus < 2  ; valikRakendus = valikRakendus ) {

           /* SELECT column FROM table
            ORDER BY RANDOM()
            LIMIT 1*/

            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
                c.setAutoCommit(false);
                System.out.println("Andmebaasiga edukalt ühendus loodud");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT URL FROM DATABASE ORDER BY RANDOM() LIMIT 1;" );


                while ( rs.next() ) {
                    String url = rs.getString("url");

                    System.out.println( "Vaata näiteks seda lehte: " + url );

                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Operation done successfully");


            // küsime valiku
            System.out.println("Valikud: 1-Paku järgmine 2-Mine Algusesse 3-Välju programmist");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            valikRakendus = sc.nextInt();
            //valiku suunamine 3 stsenaariumiga
            switch (valikRakendus) {
                case 1:
                    valikRakendus=1;
                    break;
                case 2:
                    valikRakendus=2;
                    Algus();
                    break;
                case 3:
                    valikRakendus=3;
                    Valju();
                    break;
            }

        }
    }

    void AndmeSisetus() {
        for (int sisestusValik = 0; sisestusValik < 2; sisestusValik = sisestusValik) {

            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Kirjuta veebiaadress kujul: www.neti.ee");
            String inputUrl = sc.nextLine();


            Connection c = null;
            Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
            c.setAutoCommit(false);
            System.out.println("Andmebaasiga edukalt ühendatud");

            stmt = c.createStatement();
            String sql = "INSERT INTO DATABASE (URL) " +
                    "VALUES ("+ "'http://" + inputUrl + "'" + ")";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Veebileht " + inputUrl + " edukalt sisestatud");

            System.out.println();
            System.out.println("Valikud: 1-Lisa järgmine leht 2-Mine tagasi seadetesse"); // küsime valiku
            System.out.println();
            Scanner sc2 = new Scanner(System.in);
            sisestusValik = sc.nextInt(); //valiku suunamine 2 stsenaariumiga
            switch (sisestusValik) {
                case 1:
                    sisestusValik=1;
                    AndmeKuvamine();
                    break;
                case 2:
                    sisestusValik=2;
                    Settingud();
                    break;
            }



        }

    }

    void AndmeKuvamine(){
        {
            System.out.println("Salvestatud veebiaadressid:");

            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT rowid, url FROM DATABASE;" );
                while ( rs.next() ) {

                    String rowid = toString();
                    rowid = rs.getString("rowid");
                    String url = rs.getString("url");
                    System.out.println( "ID = " + rowid );
                    System.out.println( "URL = " + url );

                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Operation done successfully");
        }


    }

    void AndmeKustutamine(){

        for (int kustutusValik = 0; kustutusValik < 2; kustutusValik = kustutusValik) {

            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Kirjuta ID number millist lehte soovid kustustada");
            String whatId = sc.nextLine();

            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:shuffle2.db");
                c.setAutoCommit(false);
                System.out.println("Andmebaasiga edukalt ühendatud");

                stmt = c.createStatement();
                String sql = "DELETE from DATABASE where rowid=" + whatId;
                stmt.executeUpdate(sql);
                c.commit();

                ResultSet rs = stmt.executeQuery("SELECT rowid, url FROM DATABASE;");
                while (rs.next()) {
                    String rowid = toString();
                    rowid = rs.getString("rowid");
                    String url = rs.getString("url");

                    System.out.println("ID = " + rowid);
                    System.out.println("NAME = " + url);

                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println();
            System.out.println("Leht number "+whatId+" edukalt kustutatud");

            System.out.println("Valikud: 1-Kustuta järgmine leht 2-Mine tagasi Settingutesse"); // küsime valiku
            System.out.println();
            Scanner sc3 = new Scanner(System.in);
            kustutusValik = sc.nextInt(); //valiku suunamine 2 stsenaariumiga
            switch (kustutusValik) {
                case 1:
                    kustutusValik=1;
                    AndmeKuvamine();
                    break;
                case 2:
                    kustutusValik=2;
                    Settingud();
                    break;
            }





        }
    }

    void Valju(){
        System.out.println("programmist väljutud");
    }



}
