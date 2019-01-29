//JJ Thissell CS 110
//Game of Set JavaFx

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class JavaFXGame extends Application {

    cardsForSets card;
    int rows;
    int columns;
    Game game;
    GridPane grid;
    private Label remainingCards;
    private Button add3Button;

    // Action Methods
    @Override
    public void start(Stage primaryStage) {


        /******************Main window******************/
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color:Orange");
        Scene scene = new Scene(root, 650, 500);

        /******************Instance of Game class******************/
        game = new Game();
        columns = game.getBoard().numCols();
        rows = game.getBoard().numRows();

        // Setup the Grid
        grid = new GridPane();
        grid.setHgap(6.5);
        grid.setVgap(6.5);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Setup the Root pane
        root.setCenter(grid);

        /******************create the board******************/
        makeBoard();

        /******************Text Label for Cards Remaining******************/
        remainingCards = new Label("Cards Left: ");
        remainingCards.setPrefWidth(100);
        remainingCards.setPrefHeight(25);
        remainingCards.setMaxHeight(25);
        remainingCards.setStyle("-fx-background-color: transparent");
        remainingCards.setFont(Font.font("Verdana", 12));
        remainingCards.textProperty().bind(Bindings.concat("Cards left: ").concat(new SimpleIntegerProperty(game.cardsLeft()).asString()));

        /******************Section for Buttons******************/
        //create a Hbox to hold all buttons
        HBox hbButtons = new HBox();
        hbButtons.setSpacing(5);

        //create Button to exit the game
        Button exitButton = new Button("Exit");
        //action for the button
        exitButton.setOnMouseClicked(event -> Platform.exit());

        /******************Add 3 button*****************/
        //Button for adding 3 cards
        Button add3Button = new Button("Add 3 cards");

        //action for the add3Button
        add3Button.setOnAction(e -> {

            game.add3();

            makeBoard();
            if(game.getBoard().numCols() == 6 || game.cardsLeft() < 3)
            {
                add3Button.setDisable(true);
            }

            remainingCards.textProperty().bind(Bindings.concat("Cards left: ").concat(new SimpleIntegerProperty(game.cardsLeft()).asString()));
        });

        /******************Pane for Buttons/Label(s)******************/
        //create a pane for the GUI Buttons
        Pane theButtons = new Pane();
        root.getChildren().add(theButtons);
        theButtons.getChildren().addAll(exitButton, add3Button, remainingCards);
        hbButtons.getChildren().addAll(exitButton, add3Button, remainingCards);
        root.setBottom(hbButtons);


        /******************Display the game******************/
        // Create Primary Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of Set");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    /**
     * makeBoard method creates a board
     * has a label to display cards remaining
     * contains mouse events for when a "card" is clicked
     * deselect or select cards
     * if a set is formed after selecting three cards
     * the cards are replaced
     */
    public void makeBoard() {

        //get the board
        boardForSets b = game.getBoard();
        for (int r = 0; r < b.numRows(); r++) {
            for (int c = 0; c < b.numCols(); c++) {
                card = game.getBoard().getBoardSquare(r, c).getCard();
                CreateCardPane cardPane = new CreateCardPane(card, r, c);
                grid.add(cardPane, c, r);

                //mouse event
                cardPane.setOnMouseClicked(e -> {

                    if (cardPane.getSelected()) {
                        cardPane.setSelected(false);
                        game.removeSelected(cardPane.getRowNum(), cardPane.getColNum());
                        System.out.println(game.getselected());
                        cardPane.setStyle("-fx-background-color: white");

                    }
                    else {
                        cardPane.setSelected(true);
                        game.addToSelected(cardPane.getRowNum(), cardPane.getColNum());
                        System.out.println(game.getselected());
                        cardPane.setStyle("-fx-background-color:lightgrey");
                    }

                    if (game.getselected().size() == 3) {

                        game.testSelected();
                        game.getselected().clear();
                        System.out.println(game.cardsLeft());

                        remainingCards.textProperty().bind(Bindings.concat("Cards Left: ").concat(new SimpleIntegerProperty(game.cardsLeft()).asString()));

                        makeBoard();
                    }


                });
            }
        }
    }

}
