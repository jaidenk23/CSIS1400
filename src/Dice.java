
//Jaiden Kazemini
//This code was used to create a dice rolling game which prompts the user to choose a specific dice and then will calculate the results of the rolls at the end of the game. 
import java.util.Random;
import java.util.Scanner;

public class Dice {

	public void startGame(Scanner scn) {
		int[][] array = new int[3][10];

		displayMenu();
		int input = scn.nextInt();

		if (input == 2 || input == 4 || input == 6 || input == 8) {
			for (int i = 0; i < array.length; i++)
				for (int j = 0; j < array[i].length; j++)
					array[i][j] = rollDice(input);
		} else
			displayError();

		displaySummary(array);
	}

	public static void displayMenu() {
		System.out.println("-------------------------\r\n" + "Select a Dice Size\r\n" + "-------------------------\r\n"
				+ "    2-sided\r\n" + "    4-sided\r\n" + "    6-sided\r\n" + "    8-sided\r\n"
				+ "-------------------------\r\n");
		System.out.print("Enter 2, 4, 6 or 8: ");
	}

	// The method below is called in the main method to display an error if the user
	// inputs an incorrect value
	// I chose this structure because it was easier to understand the logic behind
	// what the code is doing
	public static void displayError() {
		System.out.println("Error: Your minimum value must be less than your maximum value.");
		System.out.println("Please try again.");
	}

	public static int rollDice(int input) {
		Random r = new Random();

		int value = r.nextInt((input - 1) + 1) + 1;

		return value;
	}

	public static void displaySummary(int[][] array) {
		int sumOne = 0, sumTwo = 0, sumThree = 0;
		String winner = "";

		for (int i = 0; i < array[0].length; i++) {
			sumOne += array[0][i];
			sumTwo += array[1][i];
			sumThree += array[2][i];
		}

		double averageOne = (double) sumOne / 10;
		double averageTwo = (double) sumTwo / 10;
		double averageThree = (double) sumThree / 10;
		// "if else if" shown below calculates the winner of the game based off the
		// highest sum from their rolls
		// I chose this structure because it is easy to understand the logic behind
		// calculating the winner
		if (sumOne > sumTwo)
			winner = "Player One";
		else
			winner = "Player Two";

		if (sumThree > sumOne && sumThree > sumTwo)
			winner = "Player Three";

		System.out
				.println("----------------------------------------------------------------\r\n" + "Dice Roll Summary");
		System.out.println("----------------------------------------------------------------");
		System.out.println("Player\t" + "Rolls\t\t\t\t" + "Total\t" + "Average");
		System.out.println("----------------------------------------------------------------");
		System.out.println("1: \t" + printRow(array, 0) + " \t\t" + sumOne + "\t" + averageOne);
		System.out.println("2: \t" + printRow(array, 1) + "\t\t" + sumTwo + "\t" + averageTwo);
		System.out.println("3: \t" + printRow(array, 2) + "\t\t" + sumThree + "\t" + averageThree);
		System.out.println("----------------------------------------------------------------\r\n" + "Winner: " + winner
				+ "\r\n" + "----------------------------------------------------------------\r\n");

	}

	public static String printRow(int[][] array, int row) {
		String s = "";
		for (int i = 0; i < array[row].length; i++) {
			s += array[row][i];
			s += " ";
		}
		return s;
	}

}
