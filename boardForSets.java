//JJ Thissell Board class
//CS 110
import java.util.*;
public class boardForSets {

    /***
     * Instance variables
     */
    private ArrayList<ArrayList<BoardSquare>> board  =  new ArrayList<>();
    private int rows = 3;
    private int columns = 4;
    private deckForSets deck;

    /**
     * boardForSets constructor takes
     * @param deck and creates a 2d
     * ArrayList and populates the board with
     * boardsquares w/ the top 12 cards of the deck
     */
    public boardForSets(deckForSets deck){

        this.deck = deck;

        for(int i=0; i < rows; i++){

            ArrayList<BoardSquare> newRow =  new ArrayList<>();

            for(int k =0; k < columns;k++){

                newRow.add(new BoardSquare(i,k,this.deck.getTopCard()));
            }
            board.add(newRow);
        }
    }

    /** toString method uses Stringbuilder method
     * found on StackOverFlow and creates an empty string
     * loops through the array list Board and
     * then loops through boardsquares and appends all the
     * boardquares in the board to the variable result
     * @return result.toString()
     */
   @Override
    public String toString(){

        StringBuilder result = new StringBuilder();

        for(ArrayList<BoardSquare> b: board){

            for(BoardSquare s: b){
                result.append(s.getCard().toString()+" \t ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * replaceCard method takes
     * @param cards
     * @param row
     * @param column
     * creates a new boardsquare object and the board
     * gets the row specified and sets the card in the row, column pairing
     */
     public void replaceCard(cardsForSets cards, int row, int column ){
         BoardSquare newCard = new BoardSquare(row,column,cards);
         board.get(row).set(column, newCard);

    }

    /**
     * getBoardSquare method takes
     * @param row
     * @param column
     * and @return the row and column of the board using the get() method
     */
     public BoardSquare getBoardSquare(int row, int column){
         return board.get(row).get(column);
   }

    /**
     * add3 method takes
     * @param deck
     * loops through the ArrayList of BoardSquares
     * and creates a boardsquare object and draws from the top of the deck
     * and adds the cards to the end of the 3 rows
     */
     public void add3(deckForSets deck){
         int i = 0;
         for(ArrayList<BoardSquare> addCard: board){
             BoardSquare newCard =  new BoardSquare(i,addCard.size(),deck.getTopCard());
             addCard.add(newCard);
             i++;
         }
     }

    /**
     * numRows method
     * @return board.size()
     * size represents the number of rows
     * in this case
     */
     public int numRows() {

         return board.size();
     }

    /**
     * numCols method
     * @return board.get(o).size()
     * the board gets the index 0 and gets
     * the size of the first row
     */
     public int numCols(){
         return board.get(0).size();
     }


    /**
     * getCard method returns the card specified at the row and column
     * and takes
     * @param row
     * @param column
     * @return board.get(row).get(column).getCard() method from the
     * BoardSquare class
     */
     public cardsForSets getCard(int row, int column){

         return board.get(row).get(column).getCard();
     }

     public deckForSets getDeck(){
         return deck;
     }
}
