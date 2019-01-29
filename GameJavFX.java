import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class GameJavFX extends Application {

    // Action Methods
    @Override
    public void start(Stage primaryStage) {
        // Prepare the Window
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,500,400);

        // Setup the Grid
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setHgap(5);
        grid.setVgap(5);

     /*   //create an instance of the game
        Game game = new Game();

        //want to loop through and place all the cards
        //on the board in GUI
        for(int i =0; i < game.getBoard().numRows(); i++){
            for(int j=0; j < game.getBoard().numCols(); j++){

            }

        }*/


        // DEBUG STUFF - Creates some example panes
        // THIS IS AN EXAMPLE
        Pane pane = createCardPane(new cardsForSets(cardsForSets.rank.SQUIGGLES,cardsForSets.fill.HATCHED, cardsForSets.number.THREE, cardsForSets.color.RED));
        Pane pane2 = createCardPane(new cardsForSets(cardsForSets.rank.OVALS, cardsForSets.fill.SOLID, cardsForSets.number.ONE, cardsForSets.color.PURPLE ));

        // Fill the Grid
        grid.add(pane, 0,0);
        grid.add(pane2, 1,0);


        // Setup the Root pane
        root.setCenter(grid);

        // Create Primary Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of Set");
        primaryStage.show();
    }

    public static void main(String [] args) {
        launch(args);
    }

    // Functional Methods
    /**
     * Creates a card pane using the data grafted from a given Card
     * @param card The card to graft data from
     * @return A pane with the card's data made into a GUI element
     */
    public Pane createCardPane(cardsForSets card) {
        // Create the outPane
        VBox outPane = new VBox();
        outPane.setAlignment(Pos.CENTER);
        outPane.setPrefWidth(75);
        outPane.setPrefHeight(100);
        outPane.setMaxHeight(100);
        outPane.setFillWidth(true);

        // Build the Shapes
        switch(card.getrank()) {
            case SQUIGGLES:
                // Set the proper spacing
                outPane.setSpacing(5);

                // Build the shapes
                ArrayList<Rectangle> squiggles = createSquigglesElements(card);

                // Add the Shapes to the outPane
                outPane.getChildren().addAll(squiggles);
                break;

            case DIAMONDS:
                // Set the proper spacing
                outPane.setSpacing(10);

                // Build the shapes
                ArrayList<Rectangle> diamonds = createDiamondsElements(card);

                // Add the Shapes to the outPane
                outPane.getChildren().addAll(diamonds);
                break;

            case OVALS:
                // Set the proper spacing
                outPane.setSpacing(-17);

                // Build the shapes
                ArrayList<Ellipse> ellipses = createEllipseElements(card);

                // Add the Shapes to the outPane
                outPane.getChildren().addAll(ellipses);
                break;
        }

        // Return the outPane
        return outPane;
    }

    /**
     * Creates an ArrayList of Ellipses to represent the Oval elements
     * @param card Card to pull data from
     * @return ArrayList of Ellipses
     */
    public ArrayList<Ellipse> createEllipseElements(cardsForSets card) {
        // Create out list
        ArrayList<Ellipse> ellipses = new ArrayList<>();

        int elli = -1;
        switch(card.getNumber()) {
            case ONE:
                elli = 1;
                break;

            case TWO:
                elli = 2;
                break;

            case THREE:
                elli = 3;
                break;
        }

        // Create the number
        for(int i = 0; i < elli; i++) {
            // Build the ellipse
            Ellipse ellipse = new Ellipse(10,20);
            ellipse.setRotate(90);

            // Find the stroke color
            switch(card.getColor()) {
                case PURPLE:
                    ellipse.setStroke(Color.PURPLE);
                    break;

                case GREEN:
                    ellipse.setStroke(Color.GREEN);
                    break;

                case RED:
                    ellipse.setStroke(Color.RED);
                    break;
            }

            // Find the fill color
            switch(card.getFill()) {
                case SOLID:
                    // Gets the color from the stroke color
                    ellipse.setFill(ellipse.getStroke());
                    break;

                case HATCHED:
                    // Loads the hash
                    ellipse.setFill(new ImagePattern(new Image("hatch.png",-50,-50,true,true,false)));
                    break;

                case OUTLINE:
                    ellipse.setFill(Color.TRANSPARENT);
                    break;
            }

            // Add to the List of Shapes
            ellipses.add(ellipse);
        }

        // Send out the list
        return ellipses;
    }

    /**
     * Creates an ArrayList of Rectangles to represent the diamond elements
     * @param card Card to get data from
     * @return Arraylist of Rectangles
     */
    public ArrayList<Rectangle> createDiamondsElements(cardsForSets card) {
        // Create out list
        ArrayList<Rectangle> diamonds = new ArrayList<>();

        // Find number
        int shapes = -1;
        switch(card.getNumber()) {
            case ONE:
                shapes = 1;
                break;

            case TWO:
                shapes = 2;
                break;

            case THREE:
                shapes = 3;
                break;
        }

        // Create the number
        for(int i = 0; i < shapes; i++) {
            // Build the ellipse
            Rectangle diamond = new Rectangle(20, 20);
            diamond.setRotate(45);

            // Find the stroke color
            switch(card.getColor()) {
                case PURPLE:
                    diamond.setStroke(Color.PURPLE);
                    break;

                case GREEN:
                    diamond.setStroke(Color.GREEN);
                    break;

                case RED:
                    diamond.setStroke(Color.RED);
                    break;
            }

            // Find the fill color
            switch(card.getFill()) {
                case SOLID:
                    // Gets the color from the stroke color
                    diamond.setFill(diamond.getStroke());
                    break;

                case HATCHED:
                    // Loads the hash
                    diamond.setFill(new ImagePattern(new Image("hatch.png",-50,-50,true,true,false)));
                    break;

                case OUTLINE:
                    diamond.setFill(Color.TRANSPARENT);
                    break;
            }

            // Add to the List of Shapes
            diamonds.add(diamond);
        }

        // Send out the list
        return diamonds;
    }

    /**
     * Creates an ArrayList of Rectangles to represent the squiggle elements
     * @param card Card to get data from
     * @return Arraylist of Rectangles
     */
    public ArrayList<Rectangle> createSquigglesElements(cardsForSets card) {
        // Create out list
        ArrayList<Rectangle> squiggles = new ArrayList<>();

        int ranks = -1;
        switch(card.getNumber()) {
            case ONE:
                ranks = 1;
                break;

            case TWO:
                ranks = 2;
                break;

            case THREE:
                ranks = 3;
                break;
        }

        // Create the number
        for(int i = 0; i < ranks; i++) {
            // Build the ellipse
            Rectangle squiggle = new Rectangle(20, 20);

            // Find the stroke color
            switch(card.getColor()) {
                case PURPLE:
                    squiggle.setStroke(Color.PURPLE);
                    break;

                case GREEN:
                    squiggle.setStroke(Color.GREEN);
                    break;

                case RED:
                    squiggle.setStroke(Color.RED);
                    break;
            }

            // Find the fill color
            switch(card.getFill()) {
                case SOLID:
                    // Gets the color from the stroke color
                    squiggle.setFill(squiggle.getStroke());
                    break;

                case HATCHED:
                    // Loads the hash
                    squiggle.setFill(new ImagePattern(new Image("hatch.png",-50,-50,true,true,false)));
                    break;

                case OUTLINE:
                    squiggle.setFill(Color.TRANSPARENT);
                    break;
            }

            // Add to the List of Shapes
            squiggles.add(squiggle);
        }

        // Send out the list
        return squiggles;
    }
}
