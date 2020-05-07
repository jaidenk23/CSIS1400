
//Jaiden Kazemini
//Code is used to create a guessing game to guess a random number with a certain amount of tries chosen by the user. 
//Different methods are used to do certain tasks and then called in the main method. 
import java.util.Scanner;
import java.lang.Math;

public class GuessingGame {

	public void startGame(Scanner scn) {
		int[][] array = new int[2][10];
		int hiddenNumber;
		hiddenNumber = (int) (Math.random() * 49 + 1);
		displayMenu();
		int input = scn.nextInt();
		int guess;
		int count = 0;
		boolean win = false;

		if (input == 2 || input == 4 || input == 6 || input == 8) {

		} else
			displayError();

		while (win == false) {

			System.out.print("Enter a guess between 1 and 50: ");
			guess = scn.nextInt();

			array[1][count] = guess;
			count++;

			for (int i = 0; i < array[0].length; i++)
				array[0][i] = i + 1;

			// "if else if" shown below is used to show a winner and whether or not the user
			// is higher or lower than the number they need to guess
			// I chose this structure because it was easy to organize and understand how the
			// code works

			if (guess == hiddenNumber)
				win = true;

			else if (guess < hiddenNumber)
				System.out.println("Your guess is smaller than the hidden number.");

			else if (guess > hiddenNumber)
				System.out.println("Your guess is larger than the hidden number.");

		}

		summaryReport(array);
	}

	private static void displayMenu() {
		System.out.println("--------------------------------------------------\r\n"
				+ "Please choose how many guesses you'd like. \r\n"
				+ "--------------------------------------------------\r\n");
		System.out.print("Enter 2, 4, 6 or 8: ");
	}

	private static void displayError() {
		System.out.println("Error: Your minimum value must be less than your maximum value.");
		System.out.println("Please try again.");
	}

	private static void summaryReport(int[][] array) {
		int numOfGuesses;
		int count = 0;

		for (int i = 0; i < array[0].length; i++)
			if (array[1][i] != 0)
				count++;

		numOfGuesses = count;

		System.out.println("Congratulations, you win!");
		System.out.println("------------------------------------------------------\r\n" + "Guessing Game Summary");
		System.out.println("------------------------------------------------------");
		System.out.println("Player\t" + " Numbers Guessed\t" + "Number of Guesses");
		System.out.println("------------------------------------------------------");
		System.out.println("1: \t" + printRow(array, 1, count) + "\t\t" + numOfGuesses + "\t");
		System.out.println("------------------------------------------------------\r\n");
	}

	public static String printRow(int[][] array, int row, int count) {
		String s = "";
		for (int i = 0; i < count; i++) {
			s += array[row][i];
			s += " ";
		}
		return s;
	}
}
