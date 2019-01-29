//JJ Thissell CS 110
//CreateCardPane class

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;


public class CreateCardPane extends Pane
{
    private int row;
    private int col;
    private boolean selected;
    private Pane pane;

    public int getRowNum()
    {
        return row;
    }

    public int getColNum()
    {
        return col;
    }

    public boolean getSelected()
    {
        return selected;
    }

    public void setSelected(boolean select)
    {
        this.selected = select;
    }


    /**
     * CreateCardPane method takes a card object, row, column
     * and
     * @param card
     * @param row
     * @param col
     */
    public CreateCardPane(cardsForSets card, int row, int col)
    {
        this.row = row;
        this.col = col;
        selected = false;
        pane = this;

        pane.setPrefSize(100, 150);
        pane.setStyle("-fx-background-color:white");

        if (card.getrank() == cardsForSets.rank.OVALS)
        {
            if (card.getNumber() == cardsForSets.number.ONE)
            {
                drawEllipse(pane, 50, 75, 40, 15, card.getFill(), card.getColor());

            }
            else if (card.getNumber() == cardsForSets.number.TWO)
            {
                drawEllipse(pane,50,50,40,15, card.getFill(), card.getColor());
                drawEllipse(pane,50,100,40,15, card.getFill(), card.getColor());
            }
            else if (card.getNumber() == cardsForSets.number.THREE)
            {
                drawEllipse(pane,50,35,40,15, card.getFill(), card.getColor());
                drawEllipse(pane,50,75,40,15, card.getFill(), card.getColor());
                drawEllipse(pane,50,115,40,15,card.getFill(), card.getColor());
            }
        }
        if (card.getrank() == cardsForSets.rank.SQUIGGLES)
        {
            if (card.getNumber() == cardsForSets.number.ONE)
            {
                drawSquare(pane, 30,55,40,40, card.getFill(),card.getColor());
            }
            if (card.getNumber() == cardsForSets.number.TWO)
            {
                drawSquare(pane,30,30,35,35, card.getFill(), card.getColor());
                drawSquare(pane,30,80,35,35, card.getFill(), card.getColor());
            }
            if (card.getNumber() == cardsForSets.number.THREE)
            {
                drawSquare(pane,30,20,33,33, card.getFill(), card.getColor());
                drawSquare(pane,30,60,33,33, card.getFill(), card.getColor());
                drawSquare(pane,30,100,33,33, card.getFill(), card.getColor());
            }
        }
        if (card.getrank() == cardsForSets.rank.DIAMONDS)
        {
            if (card.getNumber() == cardsForSets.number.ONE)
            {
                drawDiamond(pane, 30,50,40,40, card.getFill(), card.getColor());
            }
            if (card.getNumber() == cardsForSets.number.TWO)
            {
                drawDiamond(pane,30,25,35,35, card.getFill(), card.getColor());
                drawDiamond(pane,30,85,35,35, card.getFill(), card.getColor());
            }
            if (card.getNumber() == cardsForSets.number.THREE)
            {
                drawDiamond(pane,40,25,20,20, card.getFill(), card.getColor());
                drawDiamond(pane,40,65,20,20, card.getFill(), card.getColor());
                drawDiamond(pane,40,105,20,20, card.getFill(), card.getColor());
            }
        }


    }

    /**
     * drawDiamond method creates all
     * instances of a diamond "card"
     * @param pane
     * @param heightX
     * @param heightY
     * @param widthX
     * @param widthY
     * @param fill
     * @param color
     */
    public void drawDiamond(Pane pane, int heightX, int heightY, int widthX, int widthY, cardsForSets.fill fill, cardsForSets.color color)
    {
        ImagePattern hatchfill = new ImagePattern(new Image("hatch.png"));
        Rectangle diamond = new Rectangle(heightX,heightY,widthX,widthY);
        diamond.setRotate(45);

        if (fill == cardsForSets.fill.SOLID)
        {
            if (color == cardsForSets.color.GREEN)
            {
                diamond.setFill(Color.GREEN);
                pane.getChildren().add(diamond);

            }
            else if (color == cardsForSets.color.PURPLE)
            {
                diamond.setFill(Color.PURPLE);
                pane.getChildren().add(diamond);


            }
            else if (color == cardsForSets.color.RED)
            {
                diamond.setFill(Color.RED);
                pane.getChildren().add(diamond);

            }
        }
        if (fill == cardsForSets.fill.OUTLINE)
        {
            if (color == cardsForSets.color.GREEN)
            {
                diamond.setStroke(Color.GREEN);
                diamond.setFill(Color.TRANSPARENT);
                pane.getChildren().add(diamond);

            }
            else if (color == cardsForSets.color.PURPLE)
            {
                diamond.setStroke(Color.PURPLE);
                diamond.setFill(Color.TRANSPARENT);
                pane.getChildren().add(diamond);

            }
            else if (color == cardsForSets.color.RED)
            {
                diamond.setStroke(Color.RED);
                diamond.setFill(Color.TRANSPARENT);
                pane.getChildren().add(diamond);

            }
        }
        else if (fill == cardsForSets.fill.HATCHED)
        {
            if (color == cardsForSets.color.GREEN)
            {
                diamond.setFill(hatchfill);
                diamond.setStroke(Color.GREEN);
                pane.getChildren().add(diamond);

            }
            if (color == cardsForSets.color.RED)
            {
                diamond.setFill(hatchfill);
                diamond.setStroke(Color.RED);
                pane.getChildren().add(diamond);

            }
            if (color == cardsForSets.color.PURPLE)
            {
                diamond.setFill(hatchfill);
                diamond.setStroke(Color.PURPLE);
                pane.getChildren().add(diamond);

            }
        }

    }

    /**
     * drawSquare method creates all instances
     * of a "Squiggle" card
     * @param pane
     * @param heightX
     * @param heightY
     * @param widthX
     * @param widthY
     * @param fill
     * @param color
     */
    public void drawSquare(Pane pane, int heightX, int heightY, int widthX, int widthY, cardsForSets.fill fill, cardsForSets.color color)
    {
        ImagePattern hatchfill = new ImagePattern(new Image("hatch.png"));
        Rectangle square = new Rectangle(heightX, heightY, widthX, widthY);

        if (fill == cardsForSets.fill.SOLID)
        {
            if (color == cardsForSets.color.GREEN)
            {
                square.setFill(Color.GREEN);
                pane.getChildren().add(square);

            }
            else if (color == cardsForSets.color.PURPLE)
            {
                square.setFill(Color.PURPLE);
                pane.getChildren().add(square);

            }
            else if (color == cardsForSets.color.RED)
            {
                square.setFill(Color.RED);
                pane.getChildren().add(square);

            }
        }
        if (fill == cardsForSets.fill.OUTLINE)
        {
            if (color == cardsForSets.color.GREEN)
            {
                square.setStroke(Color.GREEN);
                square.setFill(Color.TRANSPARENT);
                pane.getChildren().add(square);

            }
            else if (color == cardsForSets.color.PURPLE)
            {
                square.setStroke(Color.PURPLE);
                square.setFill(Color.TRANSPARENT);
                pane.getChildren().add(square);

            }
            else if (color == cardsForSets.color.RED)
            {
                square.setStroke(Color.RED);
                square.setFill(Color.TRANSPARENT);
                pane.getChildren().add(square);

            }
        }
        else if (fill == cardsForSets.fill.HATCHED)
        {
            if (color == cardsForSets.color.GREEN)
            {
                square.setFill(hatchfill);
                square.setStroke(Color.GREEN);
                pane.getChildren().add(square);

            }
            if (color == cardsForSets.color.RED)
            {
                square.setFill(hatchfill);
                square.setStroke(Color.RED);
                pane.getChildren().add(square);

            }
            if (color == cardsForSets.color.PURPLE)
            {
                square.setFill(hatchfill);
                square.setStroke(Color.PURPLE);
                pane.getChildren().add(square);

            }
        }
    }

    /**
     * DrawEllipse method creates all
     * instances of ellipse "cards"
     * @param pane
     * @param centerX
     * @param centerY
     * @param radX
     * @param radY
     * @param fill
     * @param color
     */
    public void drawEllipse (Pane pane, int centerX, int centerY, int radX, int radY, cardsForSets.fill fill, cardsForSets.color color)
    {
        ImagePattern hatchfill = new ImagePattern(new Image("hatch.png"));

        Ellipse ellipse = new Ellipse(centerX,centerY,radX,radY);

        if (fill == cardsForSets.fill.SOLID)
        {
            if (color == cardsForSets.color.GREEN)
            {
                ellipse.setFill(Color.GREEN);
                pane.getChildren().add(ellipse);
            }
            else if (color == cardsForSets.color.PURPLE)
            {
                ellipse.setFill(Color.PURPLE);
                pane.getChildren().add(ellipse);
            }
            else if (color == cardsForSets.color.RED)
            {
                ellipse.setFill(Color.RED);
                pane.getChildren().add(ellipse);
            }
        }

        else if (fill == cardsForSets.fill.OUTLINE)
        {
            if (color == cardsForSets.color.GREEN)
            {
                ellipse.setStroke(Color.GREEN);
                ellipse.setFill(Color.TRANSPARENT);
                pane.getChildren().add(ellipse);
            }
            else if (color == cardsForSets.color.PURPLE)
            {
                ellipse.setStroke(Color.PURPLE);
                ellipse.setFill(Color.TRANSPARENT);
                pane.getChildren().add(ellipse);

            }
            else if (color == cardsForSets.color.RED)
            {
                ellipse.setStroke(Color.RED);
                ellipse.setFill(Color.TRANSPARENT);
                pane.getChildren().add(ellipse);

            }
        }
        else if (fill == cardsForSets.fill.HATCHED)
        {
            if (color == cardsForSets.color.GREEN)
            {
                ellipse.setFill(hatchfill);
                ellipse.setStroke(Color.GREEN);
                pane.getChildren().add(ellipse);
            }
            if (color == cardsForSets.color.RED)
            {
                ellipse.setFill(hatchfill);
                ellipse.setStroke(Color.RED);
                pane.getChildren().add(ellipse);
            }
            if (color == cardsForSets.color.PURPLE)
            {
                ellipse.setFill(hatchfill);
                ellipse.setStroke(Color.PURPLE);
                pane.getChildren().add(ellipse);
            }
        }

    }
}