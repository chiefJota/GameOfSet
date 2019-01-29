//JJ Thissell Card class
// CS 110

public class cardsForSets {

    /**
     * enumerated types fill, shape, color, number
     */
    //fill
    public enum fill {
        OUTLINE, SOLID, HATCHED
    }
    //shape
    public enum rank {
        OVALS, SQUIGGLES, DIAMONDS
    }
    //color
    public enum color {
        RED, GREEN, PURPLE
    }
    //number
    public enum number {
        ONE, TWO, THREE
    }

    /**instance variables shape, color, number, shading**/
    private rank rank;
    private color color;
    private number number;
    private fill fill;

    /**
     * cardForSets constructor takes the enumerated types:
     * rank, fill, number and color as
     * @param r
     * @param f
     * @param num
     * @param c
     */
    public cardsForSets(rank r, fill f, number num, color c) {
        this.fill = f;
        this.color = c;
        this.number = num;
        this.rank = r;
    }

    /**
     * toString method takes the number, color, rank and fill
     * and returns them as a string
     */
    @Override
    public String toString() {

        return number + "_" + color + "_" + rank + "_" + fill;
    }

    public rank getrank(){
        return rank;
    }

    public fill getFill(){
        return fill;
    }

    public number getNumber(){
        return number;
    }

    public color getColor(){
        return color;
    }

    /**
     * isASet method is a boolean method which takes three cards and determines whether
     * the three cards form a set based on whether each individual feature is the same or different
     * on three cards.
     * @param card
     * @param card2
     * @param card3
     * @return either true of false based on whether it is a set or not
     */
    public static boolean isASet(cardsForSets card, cardsForSets card2, cardsForSets card3) {
//
//
       if(!((card.color == card2.color) && (card2.color == card3.color) || (card.color != card2.color) && (card.color != card3.color) && (card2.color != card3.color))){
            return false;
        }
        if(!((card.fill == card2.fill) && (card2.fill == card3.fill) || (card.fill != card2.fill) && (card.fill != card3.fill) && (card2.fill != card3.fill))) {
            return false;
        }
        if(!((card.rank == card2.rank) && (card2.rank == card3.rank) || (card.rank != card2.rank) && (card.rank != card3.rank) && (card2.rank != card3.rank))){
            return false;
        }
       if(!((card.number == card2.number) && (card2.number == card3.number) || (card.number != card2.number) && (card.number != card3.number) && (card2.number != card3.number))){
            return false;
        }
        return true;
        }

}

