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

-----------------------------------------------

-----------------------------------------------

UPDATE (1/21/2019) Part II:

1. The program's foundation for reading in files based on user input has been implemented. However, an InputMismatchException is being thrown with the way the program is written as of now. Also, the issue outlined in the 1/21 update concerning decryption involving the letter 'Z' is still being debugged. V3.0 of the program may still contain this error, as I have no idea where it's occurring or how to fix it. I know it's simply to do with the letter "wrapping" of the alphabet, but it will take more time to figure out exactly where the error is being caused. 
2. Everything else in the program, including the GUI presented in the Console, are working perfectly and the encryption/decryption "services" are working as intended, with consistent results. 

-----------------------------------------------

-----------------------------------------------

UPDATE (1/21/2019) Part III:

1. So, lots to add into this update! First off, the issue with 'Z' has been fixed! The problem was mainly in how I dealt with the leftover value of the key after passing a threshold. Now, instead of subtracting from 90 or 122 (i.e. 'Z' or 'z'), I subtract from 91 and 123, so 'Z'/'z' doesn't get skipped anymore.
2. The program can now successfully read over .txt files of any length and encrypt/decrypt the messages within using the keys given for each word, based on which option the user selects. 
3. I've started working on another feature as well. The shell for the program to be able to encrypt messages given by the user and write them to a .txt with a user-given filename is mostly finished. The only problem is that the program only writes the last encrypted message to the file, instead of the total number of messages the user provides. Once that's figured out though, then it should be an easy copy/paste and some very minor tweaking to get the program to be able to encrypt and decrypt messages and then write them to a file. 
4. Outside of that, minor things that have been added include an updated GUI with the now four different options you can choose, the option for the user to choose whether they want to continue using the program or shut it down, and a default switch case if the user provides an invalid value. 
5. For V3.1, I'd like to tweak the program to have the exportEncrypted() and exportDecrypted() methods work. In addition, I'd like to add a check to see if the user inputs includes the .txt extension for filenames, rather than assuming the user will include it and having a simple print statement to remind the user to include it. 

Overall, I'm very proud of the work I've done on this program. I'll probably take a couple of days off so I can focus on school stuff as that's far more important to me, but this won't be abandoned. 

Also, I streamed the latest development for this project on Twitch! I might continue this for every subsequent update, and leave a link to the VOD in here at the end of every update section. I've also included the .txt files I used to test the program, called encrypt.txt and decrypt.txt.

Today's link: https://www.twitch.tv/videos/367708028 (skip to about six minutes in to skip me fiddling around with the setup). 
