//JJ Thissell BoardSquare Class
//CS 110

public class BoardSquare {

    /**instance variables**/
    private int row;
    private int col;
    private cardsForSets card;
    private boolean isSquareSelected;

    /**
     * BoardSquare constructor takes a row, column, and card object
     * @param row
     * @param col
     * @param card
     */
    public BoardSquare(int row, int col, cardsForSets card){
        this.row = row;
        this.col = col;
        this.card = card;
        this.isSquareSelected = false;
    }

    /**------------GETTERS--------------**/
    /**
     * getRow method returns a row
     * @return row
     */
    public int getRow(){

        return row;
    }

    /**
     * getCol method returns a column
     * @return col
     */
    public int getCol() {

        return col;
    }

    /**
     * getCard method returns a card
     * @return card
     */
    public cardsForSets getCard(){

        return card;
    }
    /**
     * isSquareSelected method returns
     * whether or not the square has been selected
     *
     * @param b
     */
    public boolean isSquareSelected(boolean b){
        return b;
    }

    /**------------SETTERS--------------**/
    /**
     * setRow method sets the row so it cannot be changed
     * does not return anything
     */
    public void setRow(){

        this.row = row;
    }

    /**
     * setColumn method sets the column so it cannot be changed
     * does not return anything
     */
    public void setCol(){
        this.col = col;

    }
    /**
     * setCard method sets the card so it cannot be changed
     * does not return anything
     */
    public void setCard(){

        this.card = card;
    }

    /**
     * setSquareSelected method sets the boardsquare once it is selected
     * does not return anything
     */
    public void setSquareSelected(){
        this.isSquareSelected = isSquareSelected;
    }

    @Override
    public String toString(){
        return card.toString();
    }

}

