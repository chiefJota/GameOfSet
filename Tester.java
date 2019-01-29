import java.util.*;
import java.io.*;
public class Tester {
    //CS110

    //program class is hangman

        //main method
        public static void main(String[] args){
            //setup scanner
            Scanner input = new Scanner(System.in);
            //get a random word in char form from selectWord()
            char[] word = selectWord();

            // Display each letter in the word as an asterisk.
            char[] asterisks = new char[word.length];
            fillAsterisks(asterisks);
            //set missed guesses at zero as well as the guessCount accumulator
            int missed = 0;
            int guessCount = 0;
            //use while loop that ends when correct word is guessed or accumulator reaches 10
            while (!isWordFinish(asterisks) && guessCount != 10){
                //get input guess from user
                char guess = getGuess(asterisks, missed);
                //see if the guess was correct, if not add to the missed accumulator
                if (!isCorrectGuess(word, asterisks, guess))
                    missed++;
                //add to accumulator
                guessCount++;
            }

            //print the results
            if (isWordFinish(asterisks))
                victory(word, missed, asterisks);
            else
                defeat(word, missed, asterisks);
        }

        //method generates a random word from the array
        public static char[] selectWord(){
            //setup word char
            char[] word = new char[0];
            //read file from "hangman.txt"
            try{
                String filename = "dict.txt";
                //setup scanner for file
                Scanner sc = new Scanner(new File(filename));
                //setup string list
                List<String> lines = new ArrayList<String>();
                //set array length to zero
                int arrayLength = 0;
                //use scanner to see if there is a next line, if there is add it
                //to the array and advance the accumulator
                while (sc.hasNextLine()){
                    lines.add(sc.nextLine());
                    arrayLength++;
                }
                //put the words in the string list into the array
                String[] words = lines.toArray(new String[0]);

                //setup a random selector for the whole array list, based on arrayLength accumulator
                Random rand = new Random();
                int value = rand.nextInt(arrayLength);
                //use that random int to select a word from array in string form
                String pick = words[value];
                word = new char[pick.length()];
                //return the word as chars
                for (int i = 0; i < word.length; i++){
                    word[i] = pick.charAt(i);
                }
                return word;
            }
            //paired with try to read file
            catch(Exception e){
            }
            //return the word as chars
            return word;
        }

        //make a list of asterisks with this method
        public static void fillAsterisks(char[] list){
            for (int i = 0; i < list.length; i++){
                list[i] = '*';
            }
        }

        //check if users guess is correct
        public static boolean isCorrectGuess(char[] word, char[] blanks, char guess){
            boolean correct = false;
            int message = 2;
            for (int i = 0; i < word.length; i++){
                if (word[i] == guess){
                    correct = true;
                    if (blanks[i] == guess)
                        message = 1;
                    else{
                        blanks[i] = guess;
                        message = 0;
                    }
                }
            }

            return correct;
        }

        //method that returns true if the word has been completed
        public static boolean isWordFinish(char[] blanks){
            for (char e: blanks){
                if (e == '*')
                    return false;
            }
            return true;
        }

        //final print method that comes if the user is unable to guess the word in 10 tries
        public static void defeat(char[] word, int missed, char[] asterisks){
            System.out.print(asterisks);
            System.out.print(", ");
            System.out.println("Incorrect guesses: " + missed);
            System.out.print("Out of tries! Word was ");
            System.out.print(word);
        }

        //final print method that comes if the user is unable to guess the word in 10 tries
        public static void victory(char[] word, int missed, char[] asterisks){
            System.out.print(asterisks);
            System.out.print(", ");
            System.out.println("Incorrect guesses: " + missed);
            System.out.println("Congratulations, you guessed it!");
        }


        //method that counts the number of incorrect guesses
        public static void print(int wrongCounter){

            System.out.print("Incorrect Guesses: " + wrongCounter);
        }

        //method that prompts user to enter one letter to be tested for the selected word
        public static char getGuess(char[] asterisks, int wrongCounter){
            Scanner input = new Scanner(System.in);
            //order output as shown in examples
            System.out.print(asterisks);
            System.out.print(", ");
            print(wrongCounter);
            //get user input
            System.out.print("\nEnter a letter: ");
            String inLetter = input.next();
            inLetter = inLetter.toLowerCase();
            return inLetter.charAt(0);
        }
    }

