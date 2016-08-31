package nyc.c4q;

import java.util.Scanner;

public class Main {

    static Scanner prompt = new Scanner(System.in);

    public static void main(String[] args) {


        boolean notDone = true;

        do {
            Hangman hangman = new Hangman();


            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }



            boolean isValidInput = false;



            do {
                System.out.println("Do you want to play again?");
                String getInput = String.valueOf(prompt.next());
                String userAnswer = getInput;
                userAnswer = userAnswer.toLowerCase();

                if (userAnswer.equals("yes") || userAnswer.equals("y") ) {

                    notDone = true;
                    isValidInput = true;



                } else if (userAnswer.equals("no") || userAnswer.equals("n") ) {

                    notDone = false;
                    isValidInput = true;

                } else {
                    System.out.println("Try Again!");
                }
            } while (isValidInput == false);


        } while (notDone);
    }

}
