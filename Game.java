//JJ Thissell Game class
//CS 110
import java.util.*;
public class Game{

    /**
     * Instance Variables
     **/
    private ArrayList<BoardSquare> selected = new ArrayList<>();
    private boardForSets board;
    private deckForSets deck;

    /**
     * Game constructor creates a deck
     * shuffles the deck
     * and then creates a board
     * and initializes the board for
     * the game
     **/
    public Game() {

        deck = new deckForSets();
        deck.shuffle();
        board = new boardForSets(deck);
        deck.cardsRemaining();
    }

    /**
     * toString method displays the board
     * as a string.Calls the toString method
     * in the board class
     * @return board.toString()
     **/
    public String toString(){
          return board.toString();
    }

    /**
     * outOfCards method determines when the
     * deck is out of cards and
     * @return deck.isEmpty(), a boolean,
     * so either true or false.
     **/
    public boolean outOfCards(){
        return deck.isEmpty();
    }

    /**
     * add3 method adds three
     * cards to the end of each row
     * on the board.
     **/
    public void add3(){
        board.add3(deck);
    }

    /**
     * the addToSelected method populates
     * the selected Arraylist with the boardsquare's
     * that are selected by the user
     */
    public void addToSelected(int row, int column){
        BoardSquare select = board.getBoardSquare(row, column);
        selected.add(select);
        select.isSquareSelected(true);
    }

    /**
     * the numSelected method
     * determines the size of the
     * selected array
     * @return
     */
    public int numSelected(){
        return selected.size();
    }

    /**
     * getSelected method gets the contents of what
     * the user has selected and returns what the
     * @return
     */
    public ArrayList<BoardSquare> getselected(){
        return selected;
    }

    public boardForSets getBoard(){
        return board;
    }

    public int cardsLeft(){
        return deck.cardsRemaining();
    }


    /**
     * removeSelected method creates a BoardSquare which
     * uses the getBoardSquare method and removes the boardsquare
     * based on the row and column entered by the
     * user from the selected arrayList
     * @param row
     * @param column
     * @return selected...the arraylist
     */
    public ArrayList<BoardSquare> removeSelected(int row, int column) {
        BoardSquare remove = board.getBoardSquare(row, column);
        selected.remove(remove);
        remove.isSquareSelected(false);

        return selected;
    }

    /**
     * testSelected method is a void method
     * which tests the 3 boardsquares which are in
     * the selected ArrayList and determines whether they form
     * a set or not.
     * If the chosen cards form a set, a message saying "Set!:" is displayed
     * as well as the cards which form the set and are removed and replaced
     * from the selected BoardSquares on the board.
     * Otherwise if they do not form a set, a message is displayed "Not a set!"
     * as well as the cards and the cards stay on the board.
     * The selected arrayList is cleared after the cards are tested.
     */
    public void testSelected(){

         cardsForSets c1 = selected.get(0).getCard();
         cardsForSets c2 = selected.get(1).getCard();
         cardsForSets c3 = selected.get(2).getCard();

         if(cardsForSets.isASet(c1,c2,c3)) {

             System.out.println("Set!: " + selected.get(0) + " " + selected.get(1) + " " + selected.get(2) + "\n");

             for (BoardSquare b : selected) {
                 int replaceRow = b.getRow();
                 int replaceCol = b.getCol();
                 board.replaceCard(deck.getTopCard(), replaceRow, replaceCol);
             }
         }
             else{
             System.out.println("Not a Set! " + selected.get(0) + " " + selected.get(1) + " " + selected.get(2) + "\n");
             }

        /*for(BoardSquare replace: selected)
            replace.isSquareSelected(false);*/
         selected.clear();

    }

    public deckForSets getDeck(){
        return deck;
    }
}
