package shuffleMyWeb;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Generaator { // Klass generaator


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

    void Algus() {
        //1.	Valik, kas minna lehitsema, settingutesse või välja
        Scanner sc = new Scanner(System.in);
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

    void Valju(){
        System.out.println("programmist väljutud");

    }


}
