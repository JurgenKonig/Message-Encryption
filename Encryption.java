import java.util.*;
public class Encryption {

	public static void println(String s) {
		System.out.println(s);
	}

	public static void print(String s) {
		System.out.println(s);
	}
	
	// Method that finds the ASCII value of a char
	private static String toASCII(char ch) {
		return String.format("\\u%04x",  (int) ch);
	}
	
	// Does the brunt of the work. Reads in each letter, finds the ASCII value, and then creates the newVal. 
	// Then it saves the new and encrypted letter to an ongoing String.
	public static void encrypt(String s, int key) {
		String msg = s;
		int max = 26;
		int min = 1;
		String encryptedMsg = "";

		for (int i = 0; i < msg.length(); i++) {
			String uValue = toASCII(msg.charAt(i));
			int newVal = msg.charAt(i) + key;
			
			// START
			// Determines if the newVal represents an alphanumeric character on the ASCII table
			if (newVal >= 65 && newVal <= 90) {
				encryptedMsg += (char)newVal;
			}

			else if (newVal >= 97 && newVal <= 122) {
				encryptedMsg += (char)newVal;
			}
			// END
			
			// START
			// If the ASCII value does not correspond to an alphabetical letter, the value automatically
			// shifts to the first number in the range (65 for uppercase letters, 97 for lowercase).
			if (newVal < 65) {
				newVal = 65;
				encryptedMsg += (char)newVal;
			}

			else if (newVal > 90 && newVal < 97) {
				newVal = 65;
				encryptedMsg += (char)newVal;
			}

			else if (newVal > 122) {
				newVal = 97;
				encryptedMsg += (char)newVal;
			}
		}
		println("Your message is now: " + encryptedMsg.toUpperCase());
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);


		println("Please enter a message to encrypt: ");
		String msg = kb.nextLine();

		println("Please enter a numerical value to encrypt by (1 to 26): ");
		int key = kb.nextInt();
		
		// Ensures the key provided stays within the number of letters on the alphabet
		if (key <= 0 || key > 26) {
			println("Invalid value, please enter a valid value");
			key = kb.nextInt();
		}
		encrypt(msg, key);

	}
}
