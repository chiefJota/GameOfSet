import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FXShell extends Application {
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("JJ's window");
        Pane pane = new Pane();

        Circle c  = new Circle(100, 100, 50);
        c.setFill(Color.ORANGE);
        c.setStroke(Color.AZURE);
        pane.getChildren().add(c);
        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String [] args){
        launch(args);
    }
}
