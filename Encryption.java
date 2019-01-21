/*
 * Name: Zach Elmer
 * Date Started: January 19, 2019
 * Last Updated: January 21, 2019
 * Purpose: To create a program capable of encrypting and decrypting messages. 
 */

import java.util.*;
public class Encryption {

	public static void println(String s) {
		System.out.println(s);
	}

	public static void print(String s) {
		System.out.println(s);
	}
	
	// Method for encrypting a message. It reads in the user's message, and then works over 
	// every letter of the message and adds the key onto each letter to shift it forwards.
	// So if the message is "Zach", and the key is four (4), then it will encrypt the message to "EEGL".
	public static void encrypt(String s, int key) {
		String msg = s;;
		String encryptedMsg = "";

		for (int i = 0; i < msg.length(); i++) {
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
				newVal = 65 + key;
				encryptedMsg += (char)newVal;
			}

			else if (newVal > 90 && newVal < 97) {
				if (newVal - key == 90) { // Parameter to set "boundaries" for the encryption (i.e., if the character is 'A', then it needs to start at 'Z' and shift forwards. 
					newVal = 65 + key;
					encryptedMsg += (char)newVal;
				}
				else {
					newVal = newVal - 90;
					int keyDiff = key - newVal;
					newVal = 65 + keyDiff;
					encryptedMsg += (char)newVal;	
				}
			}

			else if (newVal > 122) {
				newVal = newVal - 122;
				int keyDiff = key - newVal;
				newVal = 97 + keyDiff;
				encryptedMsg += (char)newVal;
			}
		}
		println("Your message is now: " + encryptedMsg.toUpperCase());
	}
	
	// Method for decrypting a message. It reads in the user's message, and then works over 
	// every letter of the message and subtracts the key from each letter to shift it backwards.
	// So if the message is "EEGL", and the key is four (4), then it will decrypt the message to "Zach".
	public static void decrypt(String s, int key) {
		String msg = s;
		String decryptedMsg = "";
		
		for (int i = 0; i < msg.length(); i++) {
			int newVal = msg.charAt(i) - key;
			
			// START
			// Determines if the newVal represents an alphanumeric character on the ASCII table
			if (newVal >= 65 && newVal <= 90) {
				decryptedMsg += (char)newVal;
			}

			else if (newVal >= 97 && newVal <= 122) {
				decryptedMsg += (char)newVal;
			}
			// END
			
			// START
			// If the ASCII value does not correspond to an alphabetical letter, the value automatically
			// shifts to the first number in the range (65 for uppercase letters, 97 for lowercase).
			if (newVal < 65) {
				newVal = 90 - key;
				decryptedMsg += (char)newVal;
			}

			else if (newVal > 90 && newVal < 97) {
				newVal = newVal - 90;
				int keyDiff = key + newVal;
				newVal = 90 - keyDiff;
				decryptedMsg += (char)newVal;
				
			}

			else if (newVal > 122) {
				newVal = newVal - 122;
				int keyDiff = key + newVal;
				newVal = 122 - keyDiff;
				decryptedMsg += (char)newVal;
			}
		}
		println("Your message is now: " + decryptedMsg.toUpperCase());
		}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		String msg;
		int key;
		
		println("Please enter the task you want to do:");
		println("");
		println("----------------------------------");
		println("----------------------------------");
		println("");
		println("1. Encrypt a message.");
		println("2. Decrypt a message.");
		int userIn = kb.nextInt();
		
		// Switch statement used to simulate an "interface" for the user
		switch (userIn) {
			case 1:
				println("Please enter a message to encrypt: ");
				msg = kb.next();

				println("Please enter the key you want to encrypt the message with (1 to 26): ");
				key = kb.nextInt();
			
				// Ensures the key provided stays within the number of letters on the alphabet
				if (key <= 0 || key > 26) {
					println("Invalid value, please enter a valid value");
					key = kb.nextInt();
				}
				encrypt(msg, key); // Calls the method to encrypt the message
				break;
			case 2:
				println("Please enter a message to decrypt: ");
				msg = kb.next();
				
				println("Please enter the key used to decrypt the message with (1 to 26): ");
				key = kb.nextInt();
				
				if (key <= 0 || key > 26) {
					println("Invalid value, please enter a valid value");
					key = kb.nextInt();
				}
				decrypt(msg, key); // Calls the method to decrypt the message
				break;
		}

	}
}
