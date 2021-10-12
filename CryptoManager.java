/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: A program that encrypt and decrypt a phrase by using 
 * Caesar Cipher approach and Giovan Battista Bellaso approach.
 * Due: 11/12/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Yei Thek Wang
*/

public class CryptoManager {

	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds(String plainText) {
		// create a boolean variable
		boolean inBound = true;

		// for loop to check if the char within the String is out of bound
		for (int i = 0; i < plainText.length(); i++) {
			// compare the char within the string with the lower and upper bound characters
			if (plainText.charAt(i)< LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) {
				inBound = false;
			}
		}
		// Return the boolean result
		return inBound;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		// If the string is not in bounds, return a empty string
		if (!stringInBounds(plainText)) {
			return "";
		}

		// Create a String variable to store the encrypted char by char
		String encryptedString = "";

		// for loop, loop through every char, and encrypt them one by one
		for (int i = 0; i < plainText.length(); i++) {

			char c = plainText.charAt(i); // get the character at index i of string plainText
			int encryptedAscii = (int) c + key;		// convert the char to ASCII number and then add the key

			// subtract the char that is out of bound with range until it is within the ASCII 32 - 95
			while (encryptedAscii > UPPER_BOUND) {
				encryptedAscii -= RANGE;
			}

			// change the ascii number back to char , and then combine them character by character
			encryptedString += (char) encryptedAscii;
		}

		// Return the encrypted string
		return encryptedString;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		// Create a String variable to store the encrypted char by char
		String encryptedString = "";
		int bl = bellasoStr.length(); // Belasso string's length

		// for loop, loop through every char, and encrypt them one by one
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);		// get the character at index i of string plainText
			// convert the char to Ascii number and add the ascii number of the corresponding key
			int encryptedAscii = (int) c + (int) bellasoStr.charAt(i % bl);

			// subtract the char that is out of bound with range until it is within the ASCII 32 - 95
			while (encryptedAscii > UPPER_BOUND) {
				encryptedAscii -= RANGE;
			}

			// change the ascii number back to char , and then combine them character by character
			encryptedString += (char) encryptedAscii;
		}

		// Return the encrypted string
		return encryptedString;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		// Create a String variable to store the decrypted char by char
		String decryptedString = ""; // Decrypted text string, needs to be built character by character

		// for loop, loop through every char, and decrypt them one by one
		for (int i = 0; i < encryptedText.length(); i++) {
			char c = encryptedText.charAt(i); // get the character at index i of string plainText
			int decryptedAscii = (int) c - key;

			// Add the char that is out of bound with range until it is within the ASCII 32 - 95
			while (decryptedAscii < LOWER_BOUND) {
				decryptedAscii += RANGE;
			}

			// change the ascii number back to char , and then combine them character by character
			decryptedString += (char) decryptedAscii;
		}

		// Return the decrypted string
		return decryptedString;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		// Create a String variable to store the decrypted char by char
		String decryptedString = ""; // To be built, char by char
		int bl = bellasoStr.length(); // Bellaso string length

		// for loop, loop through every char, and decrypt them one by one
		for (int i = 0; i < encryptedText.length(); i++) {
			// Variables
			char c = encryptedText.charAt(i); // get the character at index i of string plainText
			// convert the char to Ascii number and subtract the ascii number of the corresponding key
			int decryptedAscii = (int) c - (int) bellasoStr.charAt(i % bl);
			// Add the char that is out of bound with range until it is within the ASCII 32 - 95
			while (decryptedAscii < LOWER_BOUND) {
				decryptedAscii += RANGE;
			}

			// change the ascii number back to char , and then combine them character by character
			decryptedString += (char) decryptedAscii;
		}

		// Return the decrypted string
		return decryptedString;
	}
}