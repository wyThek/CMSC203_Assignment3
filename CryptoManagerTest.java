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

public class CryptoManagerTest  {

	public static void main(String[] args) {

		String str1 = "\"THIS TEST SHOULD SUCCEED\"";
		String str2 = "\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\"";
		String str3 = "\"This test should fail because of lowercase letters\""; 
		String str4 = "THIS IS ANOTHER TEST";
		String bellasoStr = "CMSC203";
		String str5 = "WKLV#LV#DQRWKHU#WHVW";
		String str6 = "WU\\VR9F#N!RF88U-'HED";

		boolean good = CryptoManager.stringInBounds(str1);
		boolean bad = CryptoManager.stringInBounds(str2);
		
		System.out.println(str1+" Is it in bounds? "+good);
		System.out.println(str2+" Is it in bounds? "+bad);
		bad = CryptoManager.stringInBounds(str3);
		System.out.println(str3+" Is it in bounds? "+bad);
		System.out.println("Caesar cipher of \""+str4+"\" should return \"WKLV#LV#DQRWKHU#WHVW\":   "+ CryptoManager.encryptCaesar(str4, 3));
		System.out.println("Bellaso cipher of \""+str4+"\" should return \"WU\\VR9F#N!RF88U-'HED\":    "+ CryptoManager.encryptBellaso(str4, bellasoStr));
		System.out.println("Caesar decryption of \""+str5+"\" should return \"THIS IS ANOTHER TEST\":    "+ CryptoManager.decryptCaesar(str5, 3));
		System.out.println("Bellaso decryption of \""+str6+"\" should return \"THIS IS ANOTHER TEST\":    "+ CryptoManager.decryptBellaso(str6, bellasoStr));
	}

}