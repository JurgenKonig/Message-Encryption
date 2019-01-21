# Message-Encryption

Programmer: Zach Elmer

Date Started: January 19, 2019

Last Updated: January 21, 2019

-----------------------------------------------

-----------------------------------------------

The purpose of this program was to create a simple but effective way to encrypt messages through a basic method of 
shifting letters on the alphabet by a given key. While this is a barebones program that doesn't offer anything to boast about, 
it does serve as a valuable foundation for me to create future programs upon. 

It takes in a String inputted by the user, and then reads over every letter of that String and records its ASCII value. From there, it records and saves a new value, this one being created by adding together the ASCII value and the key provided by the user. And then, it determines whether the newVal is an alphabetical letter or not, and acts accordingly. 

-----------------------------------------------

-----------------------------------------------

SIDE NOTES (1/19/2019): 

1. The program automatically converts everything to uppercase as an added layer of security. This allows the message to be less obvious by the number of capital letters, while still being readable after being encrypted. 

2. I would like to enhance this program by being able to decode messages based on another given key, whether it's the same as the
encrypted key or different. This is the next step in the evolution of the program, if I continue to add onto this.

-----------------------------------------------

-----------------------------------------------

UPDATE (1/21/2019):

1. The program is now able to decrypt messages near perfectly with the decrypt(String s, int key) method. However, there lies a problem: messages that decrypt the message to include a 'Z' seem to be one letter off for the most part. For example, "Zach" encrypts to "EEGL", however, "EEGL" decrypts to "AACH". This problem will be addressed before moving on to whatever next step I decide to implement. 
2. The program also now outputs a pseudo-interface/GUI to the Console, and uses user input of an option number to determine whether a message will be encrypted or decrypted via Switch statements. This helps bring a lot of structure to the program, as well as keeping code executed in the main() wrapped together in one spot, increasing readability of the code. 
3. Comments have been added to the decrypt() method section. 
4. My hopeful next step, after solving the aforementioned decryption issue, is to allow the program to be able to read in a file of either encrypt unencrypted messages or decrypt encrypted messages. 
