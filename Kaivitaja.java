package shuffleMyWeb;




import javafx.application.Application;
import javafx.stage.Stage;

/*
Antud rakendus pakub suvalises järjekorras veebilehe URLe. Rakendusse saab lisada ning kustutada lemmik veebilehti.
Rrogramm suhtleb SQLite andmebaasiga shuffle2.db ning kasutab käsurealt kasutajaliidest.
 */

public class Kaivitaja extends Application  {

    public static void main(String[] args) {
        launch(args);
    }
        @Override

        public void start (Stage primaryStage)throws Exception {

            Generaator a = new Generaator(); // lõin uue "a" objekti

            a.Algus();


    }
}

