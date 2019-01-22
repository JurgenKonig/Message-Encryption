/*
 * Name: Zach Elmer

 * Date Started: January 19, 2019
 * Last Updated: January 21, 2019
 * Purpose: To create a program capable of encrypting and decrypting messages. 
 */

import java.util.*;
import java.io.*;
public class Encryption {

	public static void println(String s) {
		System.out.println(s);
	}

	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void println(int i) {
		System.out.println(i);
	}
	
	public static void print(int i) {
		System.out.print(i);
	}

	// Method for encrypting a message. It reads in the user's message, and then works over 
	// every letter of the message and adds the key onto each letter to shift it forwards.
	// So if the message is "Has", and the key is four (4), then it will encrypt the message to "MFX".
	public static String encrypt(String s, int key) {
		String msg = s;
		String encryptedMsg = "";

		for (int i = 0; i < msg.length(); i++) {
			int newVal = msg.charAt(i) + key; // Gives encrypted letter (A + key 3 = D)

			// START
			// Determines if the newVal represents an alphabetical letter on the ASCII table
			if (newVal >= 65 && newVal <= 90) {
				encryptedMsg += (char)newVal;
			}

			else if (newVal >= 97 && newVal <= 122) {
				encryptedMsg += (char)newVal;
			}
			// END

			// START
			// If the ASCII value does not correspond to an alphabetical letter, the value automatically
			// shifts to the first number in the range (65 for upper case letters, 97 for lower case).
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
		return encryptedMsg.toUpperCase();
	}

	// Method for decrypting a message. It reads in the user's message, and then works over 
	// every letter of the message and subtracts the key from each letter to shift it backwards.
	// So if the message is "MFX", and the key is four (4), then it will decrypt the message to "Has".
	public static String decrypt(String s, int key) {
		String msg = s;
		String decryptedMsg = "";
		int temp;
		int diff;
		int newKey;

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
			// shifts to the last number in the range (90 for upper case letters, 122 for lower case).
			if (newVal < 65) { // Boundaries for upper case chars
				temp = newVal + key; // Store original ASCII value of the char, before key. (EX is 68, key is 5);
				diff = temp - 65; // How far original ASCII value of char is from 65. (Diff = 68 - 65 == 3);
				newKey = key - diff; // Key is 5, then 5 - 3 == 2, which means the key will shift 2 from 90. 
				newVal = 91 - newKey; // 
				decryptedMsg += (char)newVal;
				temp = 0;
				diff = 0;
				newKey = 0;
			}
			
			else if (newVal > 90 && newVal < 97) { // Boundaries for lower case chars
				temp = newVal;
				diff = temp - 97; // How far original ASCII value of char is from 65. (Diff = 98 - 97 == 1);
				newKey = key - diff; // Key is 3, then 4 - 1 == 3, which means the key will shift 2 from 122.
				newVal = 123 - newKey;
				decryptedMsg += (char)newVal;
				temp = 0;
				diff = 0;
				newKey = 0;
			}
		}
		return decryptedMsg.toUpperCase();
	}

	public static void encryptFile(String name) throws IOException {
		File file = new File(name);
		Scanner fileReader = new Scanner(file);
		String msg = "";
		int key;

		while (fileReader.hasNext()) {
			msg = fileReader.next();
			key = fileReader.nextInt();
			encrypt(msg, key);
		}
		fileReader.close();
	}

	public static void decryptFile(String name) throws IOException {
		File file = new File(name);
		Scanner fileReader = new Scanner(file);
		String msg = "";
		int key;

		while (fileReader.hasNext()) {
			msg = fileReader.next();
			key = fileReader.nextInt();
			decrypt(msg, key);
		}
		fileReader.close();
	}
	
	public static void exportEncrypted(String name, String msg, int numWords) throws IOException {
        FileWriter output = null;
        
        for (int i = 0; i < numWords; i++) {
            try{
                output = new FileWriter(name);
                BufferedWriter writer = new BufferedWriter(output);
                writer.write(msg);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (i == numWords) {
                    try {
                        output.flush();
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            
        }
	}

	public static void main(String [] args) throws IOException {
		Scanner kb = new Scanner(System.in);
		boolean cont = true;
		String leave;
		String msg;
		int key;

		while (cont == true) {
			println("");
			println("Please enter the service you want to use: ");
			println("");
			println("----------------------------------");
			println("----------------------------------");
			println("");
			println("1. Encrypt a message.");
			println("2. Decrypt a message.");
			println("3. Read from file.");
			println("4. Export to file.");
			println("0. Exit the program.");

			int userIn = kb.nextInt();

			// Switch statement used to simulate an "interface" for the user
			switch (userIn) {
			case 1: // Encryption service
				println("Please enter a message to encrypt: ");
				msg = kb.next();

				println("Please enter the key you want to encrypt the message with (1 to 26): ");
				key = kb.nextInt();

				// Ensures the key provided stays within the number of letters on the alphabet
				if (key <= 0 || key > 26) {
					println("Invalid value, please enter a valid value");
					key = kb.nextInt();
				}
				println("Your message is now: " + encrypt(msg, key)); // Calls the method to encrypt the message
				println("Would you like to continue using the program? (Y/N)");
				leave = kb.next();
				
				if (leave.equalsIgnoreCase("y")) {
					break;
				}
				
				else {
					println("Shutting down program...");
					cont = false;
					break;
				}
			case 2: // Decryption service
				println("Please enter a message to decrypt: ");
				msg = kb.next();

				println("Please enter the key used to decrypt the message with (1 to 26): ");
				key = kb.nextInt();

				if (key <= 0 || key > 26) {
					println("Invalid value, please enter a valid value");
					key = kb.nextInt();
				}
				println("Your message is now: " + decrypt(msg, key)); // Calls the method to decrypt the message
				println("Would you like to continue using the program? (Y/N)");
				leave = kb.next();
				
				if (leave.equalsIgnoreCase("y")) {
					break;
				}
				
				else {
					println("Shutting down program...");
					cont = false;
					break;
				}
			case 3: // Read from a file and either encrypt or decrypt the messages within
				println("Please enter the name of the filename you want to read from (include .txt extension: ");
				String fileName = kb.next();
				
				println("");
				println("Please enter the service you'd like to use: ");
				println("");
				println("1. Encrypt a message.");
				println("2. Decrypt a message.");

				userIn = kb.nextInt();

				if (userIn == 1) {
					encryptFile(fileName);
					println("Would you like to continue using the program? (Y/N)");
					leave = kb.next();
					
					if (leave.equalsIgnoreCase("y")) {
						break;
					}
					
					else {
						println("Shutting down program...");
						cont = false;
						break;
					}
				}

				else if (userIn == 2) {
					decryptFile(fileName);
					println("Would you like to continue using the program? (Y/N)");
					leave = kb.next();
					
					if (leave.equalsIgnoreCase("y")) {
						break;
					}
					
					else {
						println("Shutting down program...");
						cont = false;
						break;
					}
				}
			case 4:
				println("Please enter the name you'd like to save the file as (include .txt extension: ");
				fileName = kb.next();
				
				println("");
				println("Please enter the service you'd like to use: ");
				println("");
				println("1. Encrypt one or more messages.");
				println("2. Decrypt one or more messages.");

				userIn = kb.nextInt();
				
				if (userIn == 1) {
					println("How many words would you like to encrypt? ");
					int numWords = kb.nextInt();
					
					for (int i = 0; i < numWords; i++) {
						println("Please enter the word you'd like to encrypt: ");
						msg = kb.next();
						
						println("Please enter the key you'd like to encrypt with: ");
						key = kb.nextInt();
						
						String encryptedMsg = encrypt(msg, key);
						exportEncrypted(fileName, encryptedMsg, numWords);
					}
					println("The file has now been written.");
					
					println("");
					println("Would you like to continue using the program? (Y/N)");
					leave = kb.next();
					
					if (leave.equalsIgnoreCase("y")) {
						break;
					}
					
					else {
						println("Shutting down program...");
						cont = false;
						break;
					}
				}
			case 0:
				println("Shutting down program...");
				cont = false;
				break;
			default:
				println("Invalid value");
				break;
			}
		}
	}
}
