//JJ Thissell
//CS110
//This program tests the card class
//testing each method:getRank,getSuit,
// and the equals method

public class cardTester {

    public static void main(String[] args){

        //card objects created
        Card c1 =  new Card (Card.ACE, Card.CLUBS);
        Card c2 = new Card(Card.ACE , Card.SPADES);

        //prints the cards out by toString method in card class
        System.out.println(c1);
        System.out.println(c2);

        //prints out getRank method
        System.out.println(c1.getRank());
        System.out.println(c2.getRank());

        //prints out getSuit method
        System.out.println(c1.getSuit());
        System.out.println(c2.getSuit());


        //boolean variable equals uses equals method
        boolean equals = c1.equals(c2);
        //prints out the result of them being equal
        System.out.println(equals);


    }
}
