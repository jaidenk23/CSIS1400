
//Jaiden Kazemini 
//In this code it compiles a menu where the user will select the option of two games and also can type their name in option 1. 
import java.util.Scanner;

public class FinalProject {
//The main method shown below calls the displayMenu method in order to display a menu for the user to choose an option
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean quit = false;
		int choice;
		do {
			displayMenu();
			choice = input.nextInt();
			switch (choice) {

			case 1:
				hello(input);
				break;
			case 2:
				guessingGame(input);
				break;
			case 3:
				diceCompetition(input);
				break;
			case 4:
				quit = true;
				break;
			default:
				System.out.println("Invalid Choice");
			}
			System.out.print("\n\n\n");
		} while (!quit);

		System.out.println("\n\nGoodbye!");
	}

	private static void hello(Scanner scn) {
		String name = "";
		System.out.print("\n\nEnter your name: ");
		name = scn.next();
		System.out.println("\nHello " + name);
	}

	// The two methods shown below call two separate classes where the separate game
	// codes are compiled in order for the user to play the game from this class
	// I chose to do separate .java files in order to get extra credit and challenge
	// myself(it ended up giving quite a few errors)
	private static void guessingGame(Scanner scn) {
		GuessingGame game = new GuessingGame();
		game.startGame(scn);
	}

	private static void diceCompetition(Scanner scn) {
		Dice dice = new Dice();
		dice.startGame(scn);
	}

	private static void displayMenu() {
		printLine(35);
		System.out.println("1. Hello");
		System.out.println("2. Number Guessing Game");
		System.out.println("3. Dice Roll Competition");
		System.out.println("4. Exit");
		printLine(35);
		System.out.print("Enter Menu Choice (1, 2, 3, or 4): ");
	}

	private static void printLine(int dashes) {
		for (int i = 1; i <= dashes; i++) {
			System.out.print("-");
		}

		System.out.println();
	}

}
