//JJ Thissell setGameTester
//CS 110
public class setGameTester {

    public static void main(String[] args){

        System.out.println("\n");
        deckForSets deck = new deckForSets();

        deck.shuffle();

        boardForSets jj = new boardForSets(deck);
        System.out.println(jj + "\n");

        System.out.println(jj.getCard(0,0)+ "\n");

        System.out.println(jj);

        if (cardsForSets.isASet(jj.getCard(0,0), jj.getCard(0,1), jj.getCard(0,2)))
            System.out.println("set");
        else
            System.out.println("not a set");

    }
}
