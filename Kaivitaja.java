package shuffleMyWeb;

// See käivitab programmi

import javafx.application.Application;
import javafx.stage.Stage;

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

/*
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Ristmik extends Application {

    public static void main(String[] args) {
        launch(args);
    }

        @Override
        public void start (Stage primaryStage)throws Exception {
            Foor foor = new Foor();
        }
    }

 */