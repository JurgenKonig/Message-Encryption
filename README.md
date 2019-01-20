# Message-Encryption

Programmer: Zach Elmer

Date Started: January 19, 2019

Last Updated: January 19, 2019

-----------------------------------------------

-----------------------------------------------

The purpose of this program was to create a simple but effective way to encrypt messages through a basic method of 
shifting letters on the alphabet by a given key. While this is a barebones program that doesn't offer anything to boast about, 
it does serve as a valuable foundation for me to create future programs upon. 

It takes in a String inputted by the user, and then reads over every letter of that String and records its ASCII value through the 
toASCII() method. From there, it records and saves a new value, this one being created by adding together the ASCII value and the key
provided by the user. From there, it determines whether the newVal is an alphabetical letter or not, and acts accordingly. 

-----------------------------------------------

-----------------------------------------------

SIDE NOTES: 

1. The program automatically converts everything to uppercase as an added layer of security. This allows the message to be less
apparent by the number of capital letters, while still being readable. 

2. I would like to enhance this program by being able to decode messages based on another given key, whether it's the same as the
encrypted key or different. This is the next step in the evolution of the program, if I continue to add onto this. 
