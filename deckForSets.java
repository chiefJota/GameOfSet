//JJ Thissell Deck Class
//CS 110

import java.util.*;
public class deckForSets {

    /**Instance Variables**/
    private final int CARDS_IN_DECK = 81;

    private ArrayList<cardsForSets> deck;

    /**no arg
     * DeckForSets constructor
     * creates arraylist of cards
     * using 4 for loops and creates a new card
     * object with the enumerated types and adds the card objects
     * to the deck
     **/
    public deckForSets(){

        deck = new ArrayList<>(CARDS_IN_DECK);

        for(cardsForSets.rank r: cardsForSets.rank.values()){
            for(cardsForSets.fill f: cardsForSets.fill.values()){
                for(cardsForSets.number n: cardsForSets.number.values()){
                    for(cardsForSets.color c: cardsForSets.color.values()){
                            deck.add(new cardsForSets(r, f, n, c));
                        }
                    }
                }
            }

        }

    /**
     * shuffle method takes no arguements
     * uses the random library and runs through
     * the deck and assigns the randNum variable to
     * generate a random int from the deck
     * then sets the deck to get randNum and has
     * the deck set randNum to be the newly shuffled deck
     *
     */
    public void shuffle(){

        int randNum;
        cardsForSets temp;
        Random rand = new Random();
        for(int i = 0; i<deck.size(); i++){
            randNum = rand.nextInt(deck.size());
            temp = deck.get(i);
            deck.set(i,deck.get(randNum));
            deck.set(randNum,temp);
        }
    }

    /**
     * getTopCard method takes the deck and uses
     * the remove method with the cards remaining()-1
     * and then returns
     * @return "c" as the top card of the deck
     */
    public cardsForSets getTopCard(){
        cardsForSets c = deck.remove(cardsRemaining()-1);
        return c;
    }

    /**
     * returns the current state of the deck
     * regarding how many cards are left
     * @return deck.size()
     */
    public int cardsRemaining(){

        return deck.size();
    }

    /**
     * boolean isEmpty method determines whether
     * the deck is finished or cards are left in
     * the deck...true if no cards remain..false otherwise
     * @return deck.size() ==0
     */
    public boolean isEmpty(){

        return (deck.size() ==0);
    }

    /**
     * toString method converts the deck
     * to a string
     * @return deck.toString()
     */
    @Override
    public String toString() {

        return deck.toString();
    }
}
