
/****************************************************************************
Written by: Robert Carff
Date: November 26, 2019
Use: written for Dr. Buells 513 Computer Archtecture class 
*****************************************************************************/
/* IMPORTS */
import java.io.*;
import java.util.*;

/* MAIN CLASS */
public class Main {

	/****************************************************************************
	This is where we read in the text file 
	we're assuming our instructions are 32 bit binary MIPS
	****************************************************************************/
	public static void readBinary() {
		//read in 1's 0's here
		Scanner scan = new Scanner(System.in);
		System.out.println("\nReading in file\n");
		while(scan.hasNextLine()){
			String checkLine = scan.nextLine();
			try {
				// do something with 1's 0's here
				System.out.println(checkLine);
				System.out.println("\n");
			} catch(Exception e) {
				System.out.println("its broken");

			}
		}

	}
	/****************************************************************************
	The main method is where we can choose functions called to do the work
	****************************************************************************/
	public static void main(String[] args){
		readBinary(); 

	}
}