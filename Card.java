//JJ Thissell
//CS 110
//card class
public class Card {

    //public constants for suits
    public final static int SPADES =1;
    public final static int CLUBS =2;
    public final static int HEARTS = 3;
    public final static int DIAMONDS =4;

    //public constants for Face cards/Ace
    public final static  int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    //private instance variables
    private final int rank;
    private final int suit;

    /*Card constructor which takes @param int rank and
    @param int suit and initializes them */
    public Card(int rank , int suit  ){
        this.suit = suit;
        this.rank = rank;
    }


    /*getSuit method returns the suit */
    public int getSuit(){

        return this.suit;
    }

    /*getRank method returns the rank */
    public int getRank(){

        return this.rank;
    }

    /*RanktoString method takes no parameters
    switch statement switches the rank to a string
    returns the rank as a string */
    public String RanktoString() {

        switch (rank) {
            case ACE:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case JACK:
                return "Jack";
            case QUEEN:
                return "Queen";
            case KING:
                return "King";
            default:
                return "Invalid suit";
        }
    }

    /*SuittoString method takes no parameters
    switch statement switches the suit to a string
    returns the suit as a string */
    public String SuittoString(){

        switch(suit) {
            case SPADES:
                return "Spades";

            case CLUBS:
                return "Clubs";

            case HEARTS:
                return "Hearts";

            case DIAMONDS:
                return "Diamonds";

            default:
                return "Invalid rank";
        }

    }
    /*toString method takes no parameters
    returns the RanktoString method and the SuittoString method */
    @Override
    public String toString(){

        return RanktoString() + " of " + SuittoString();
    }

    /*equals method takes @param Card Othercard
    comapares two cards and determines whether they are equal
    if they are it returns true, otherwise false */
    public boolean equals(Card OtherCard){

        boolean isEqual;
        if (rank == OtherCard.rank){
            isEqual = true;
        }
        else{
            isEqual = false;

        }
        return isEqual;

    }
}
