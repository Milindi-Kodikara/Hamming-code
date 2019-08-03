
import java.util.Scanner;

public class HammingCode {

	// Initialising variables
	String studNumber;
	String actualBinaryNumber = "";
	int binaryNumber = 0;
	int numberOfDataBits = 0;
	int numberOfParityBits = 0;
	String[] studNumberString = new String[11];
	String[] actualBinaryNumberArray = new String[11];
	String[] correctArray = new String[11];
	Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		// Call the menu
		HammingCode hammingCode = new HammingCode();
		hammingCode.menu();

	}

	boolean menuRunning = true;
	String input;

	public void menu() {

		while (menuRunning) {

			String line = "\n____________________________________\n";
			String title = "*** Hamming Code!! ***\n";

			String menu1 = String.format("%-30s%s\n", "Convert Number to Binary", "A ");
			String menu2 = String.format("%-30s%s\n", "Generate Hamming Code", "B ");
			String menu3 = String.format("%-30s%s\n", "Error Detection", "C ");
			String menu4 = String.format("%-30s%s\n", "Exit Program", "X ");

			String choice = String.format("%-30s\n", "Enter Selection:");

			String menu = line + title + menu1 + menu2 + menu3 + menu4 + choice + line;

			System.out.println(menu);

			input = keyboard.nextLine();

			if ((input.compareToIgnoreCase("A") == 0) || (input.compareToIgnoreCase("A") == 0)) {
				input = "A";
				this.numberToBinary();
				
			} else if ((input.compareToIgnoreCase("B") == 0) || (input.compareToIgnoreCase("b") == 0)) {
				input = "B";
				this.hammingCode();
				
			} else if ((input.compareToIgnoreCase("C") == 0) || (input.compareToIgnoreCase("c") == 0)) {
				input = "C";
				this.getError();
				
			} else if ((input.compareToIgnoreCase("X") == 0) || (input.compareToIgnoreCase("x") == 0)) {
				input = "X";
				System.exit(0);

			} else if (input.equals("")) {
				menu();
				menuRunning = false;

			}
		}
	}

	public void numberToBinary() {

		// Get student number from the user
		System.out.print("Enter the student number:");
		studNumber = keyboard.nextLine();
		// Create a string array of the student number
		int count = 0;
		for (int i = 0; i < studNumberString.length; i++) {

			if (i < 4) {
				studNumberString[i] = "0";
			} else {
				char tempString;
				tempString = studNumber.charAt(count);
				studNumberString[i] = Character.toString(tempString);
				count++;
			}

		}

		// Convert the student number to binary
		// If the number is odd then the binary value is 1 else 0
		for (int i = 0; i < 11; i++) {
			int studNumberInt;
			studNumberInt = Integer.parseInt(studNumberString[i]);
			if ((studNumberInt % 2) == 1) {
				binaryNumber = 1;
			} else if ((studNumberInt % 2) == 0) {
				binaryNumber = 0;
			}

			actualBinaryNumber = actualBinaryNumber + binaryNumber;
			numberOfDataBits++;
		}
		System.out.println("Your student number in Binary: " + actualBinaryNumber);
	}

	public void hammingCode() {

		// Calculate parity bits for the binary number
		while ((Math.pow(2, numberOfParityBits) < (numberOfDataBits + numberOfParityBits + 1))) {
			numberOfParityBits++;
			if (Math.pow(2, numberOfParityBits) >= (numberOfDataBits + numberOfParityBits + 1)) {
				numberOfParityBits = numberOfParityBits;
				System.out.println("The number of parity bits:" + numberOfParityBits);
			}
		}

		// Convert binary number to an array
		for (int i = 0; i < 11; i++) {
			char tempString;
			tempString = actualBinaryNumber.charAt(i);
			actualBinaryNumberArray[i] = Character.toString(tempString);
		}

		// Add the letter x to the parity bit positions
		for (int x = actualBinaryNumberArray.length - 1; 0 <= x; x--) {

			if (x == 10) {
				for (int i = 0; i < x; i++) {
					actualBinaryNumberArray[i] = actualBinaryNumberArray[i + 1];

				}
				actualBinaryNumberArray[x] = "x";
				numberOfParityBits--;
			}

			if (x == 9) {
				for (int i = 0; i < x; i++) {
					actualBinaryNumberArray[i] = actualBinaryNumberArray[i + 1];

				}
				actualBinaryNumberArray[x] = "x";
				numberOfParityBits--;
			}

			if (x == 7) {
				for (int i = 0; i < x; i++) {
					actualBinaryNumberArray[i] = actualBinaryNumberArray[i + 1];

				}
				actualBinaryNumberArray[x] = "x";
				numberOfParityBits--;
			}
			if (x == 3) {
				for (int i = 0; i < x; i++) {
					actualBinaryNumberArray[i] = actualBinaryNumberArray[i + 1];

				}
				actualBinaryNumberArray[x] = "x";
				numberOfParityBits--;
			}

		}
		System.out.print("\nGenerating Hamming Code  . . . ");
		for (int i = 0; i < actualBinaryNumberArray.length; i++) {
			System.out.print(actualBinaryNumberArray[i]);
		}

		int checkOddOrEven;
		// Fill out the parity bits
		for (int x = actualBinaryNumberArray.length - 1; 0 <= x; x--) {

			if (x == 10) {
				// Convert string in to int to calculate if the sum of the data bits covered by
				// a single parity bit is odd or even
				checkOddOrEven = Integer.parseInt(actualBinaryNumberArray[0])
						+ Integer.parseInt(actualBinaryNumberArray[2]) + Integer.parseInt(actualBinaryNumberArray[4])
						+ Integer.parseInt(actualBinaryNumberArray[6]) + Integer.parseInt(actualBinaryNumberArray[8]);
				if ((checkOddOrEven % 2) == 1) {
					actualBinaryNumberArray[x] = "1";
				} else {
					actualBinaryNumberArray[x] = "0";
				}
			}

			if (x == 9) {
				checkOddOrEven = Integer.parseInt(actualBinaryNumberArray[0])
						+ Integer.parseInt(actualBinaryNumberArray[1]) + Integer.parseInt(actualBinaryNumberArray[4])
						+ Integer.parseInt(actualBinaryNumberArray[5]) + Integer.parseInt(actualBinaryNumberArray[8]);
				if ((checkOddOrEven % 2) == 1) {
					actualBinaryNumberArray[x] = "1";
				} else {
					actualBinaryNumberArray[x] = "0";
				}
			}

			if (x == 7) {
				checkOddOrEven = Integer.parseInt(actualBinaryNumberArray[4])
						+ Integer.parseInt(actualBinaryNumberArray[5]) + Integer.parseInt(actualBinaryNumberArray[6]);
				if ((checkOddOrEven % 2) == 1) {
					actualBinaryNumberArray[x] = "1";
				} else {
					actualBinaryNumberArray[x] = "0";
				}
			}
			if (x == 3) {
				checkOddOrEven = Integer.parseInt(actualBinaryNumberArray[0])
						+ Integer.parseInt(actualBinaryNumberArray[1]) + Integer.parseInt(actualBinaryNumberArray[2]);
				if ((checkOddOrEven % 2) == 1) {
					actualBinaryNumberArray[x] = "1";
				} else {
					actualBinaryNumberArray[x] = "0";
				}
			}
		}
		// The correct hamming code is generated
		System.out.print("\nThe Hamming Code:");
		for (int i = 0; i < actualBinaryNumberArray.length; i++) {
			correctArray[i] = actualBinaryNumberArray[i];
			System.out.print(actualBinaryNumberArray[i]);
		}
	}

	public void getError() {
		// Get error
		System.out.print("\nEnter the bit position to alter:");
		String[] incorrectArray = new String[11];
		int bitPosition = keyboard.nextInt();
		int actualPosition = actualBinaryNumberArray.length - (bitPosition);

		// Generating hamming code with error
		System.out.print("\nHamming code with error:");
		for (int i = 0; i <= actualBinaryNumberArray.length - 1; i++) {
			if (i == actualPosition) {
				if (actualBinaryNumberArray[i].equals("1")) {
					actualBinaryNumberArray[i] = "0";
				} else if (actualBinaryNumberArray[i].equals("0")) {
					actualBinaryNumberArray[i] = "1";
				}
			}
			incorrectArray[i] = actualBinaryNumberArray[i];
			System.out.print(actualBinaryNumberArray[i]);
		}

		// Correct the error
		for (int x = 0; x < incorrectArray.length; x++) {

			if (incorrectArray[x].equals(correctArray[x])) {
				continue;
			} else {
				if (incorrectArray[x].equals("1")) {
					incorrectArray[x] = "0";
				} else if (incorrectArray[x].equals("0")) {
					incorrectArray[x] = "1";
				}
			}
		}
		System.out.print("\nCorrected Hamming Code:");
		for (int i = 0; i < incorrectArray.length; i++) {
			System.out.print(incorrectArray[i]);

		}

	}

}
