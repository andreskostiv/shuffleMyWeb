package shuffleMyWeb;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class AliceImedemaal extends Application{

    @Override
    public void start(Stage Algus) throws Exception {

        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 400, 400);
        Algus.setScene(scene);
        Algus.setTitle("Algus");

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



        Algus.show();


    }
}