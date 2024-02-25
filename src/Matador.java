import java.util.Random;
import java.util.Scanner;

public class Matador {
    static Scanner scanner = new Scanner(System.in);
    static int playerScore = 0;
    static int computerScore = 0;
    static boolean isComputerTurn = false;
    static Random random = new Random();
    static Die dieOne = new Die();
    static Die dieTwo = new Die();

    public static void main(String[] args) {
        int selectedNumber;
        System.out.println("Welcome to the Metador game!");

        while (playerScore <= 121 || computerScore <= 121) {
            selectedNumber = getNumber();
            dieOne.rollDie();
            dieTwo.rollDie();
            checkOnes(isComputerTurn);
            if (playerScore >= 121 || computerScore >= 121) {
                break;
            }
            if (dieOne.getRolledDie() == selectedNumber || dieTwo.getRolledDie() == selectedNumber && dieOne.getRolledDie() != 1 && dieTwo.getRolledDie() != 1) {
                dieOne.rollDie();
                dieTwo.rollDie();
                checkOnes(isComputerTurn);
            }else if (dieOne.getRolledDie() == selectedNumber && dieTwo.getRolledDie() == selectedNumber && dieOne.getRolledDie() != 1 && dieTwo.getRolledDie() != 1) {
                break;
            }
            System.out.println("Turn swap");
            isComputerTurn = !isComputerTurn;
        }

        isWinner(isComputerTurn);
    }

    public static int getNumber() {
        boolean isNumberValid = false;
        int tempNumber = -1;
        if (!isComputerTurn) {
            while (!isNumberValid) {
                System.out.println("Enter a number:");
                tempNumber = scanner.nextInt();
                if (tempNumber <= 0 || tempNumber > 6) {
                    System.out.println("Please enter a number between 1 and 6");
                    scanner.next();
                    }
                    isNumberValid = true;
                }
            }else {
            tempNumber = random.nextInt(2,6+1);
            System.out.println("The selected number is: " + tempNumber);
            return tempNumber;
        }
        System.out.println("The selected number is: " + tempNumber);
        return tempNumber;
    }

    public static void checkOnes(boolean isComputerTurn) {
        int diceRolledOne = dieOne.getRolledDie();
        int diceRolledTwo = dieTwo.getRolledDie();
        System.out.println("Dice Rolled: " + diceRolledOne + " " + diceRolledTwo);
        if (diceRolledOne == 1 && diceRolledTwo == 1) {
            if (!isComputerTurn) {
                playerScore = 0;
                System.out.println("Score has been set to zero for rolling two 1's.");
            }else {
                computerScore = 0;
                System.out.println("Score has been set to zero for rolling two 1's.");
            }

        }else if (diceRolledOne != 1 && diceRolledTwo != 1) {
            if (!isComputerTurn) {
                playerScore += diceRolledOne + diceRolledTwo;
                System.out.println("Score has been increased to: " + playerScore );
            }else {
                computerScore += diceRolledOne + diceRolledTwo;
                System.out.println("Score has been increased to: " + computerScore);
            }
        }else {
            System.out.println("No changes to score. It is the next players turn.");
        }
    }

    public static void isWinner (boolean isComputerTurn) {
        if (!isComputerTurn) {
            System.out.println("Congratulations!  You have won and beat the computer!");
        }else {
            System.out.println("The computer has won!  Better luck next time");
        }
    }

}
