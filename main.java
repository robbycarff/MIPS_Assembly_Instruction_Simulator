
/******************************************************************************
Written by: Robert Carff
Date: November 26, 2019
Use: written for Dr. Buells 513 Computer Archtecture class, project 4

// each method could be a stage 
// 5 steps 5 methods

*******************************************************************************/
/* IMPORTS */
import java.io.*;
import java.util.*;
/* MAIN CLASS */
public class Main {
	/****************************************************************************
	* gobal data structures and resources declared here
	****************************************************************************/
	/* RESOURCE VARIABLES */
	int _if_  = 0;
	int _id_  = 1;
	int _ex_  = 2;
	int _mem_ = 3;
	int _wb_  = 4;
	/* REGISTERS */
	int r1 = 0;
	int r2 = 0;
	int r3 = 0;
	/* LISTS */
	private static ArrayList<ArrayList<String>> instructionList = new ArrayList<ArrayList<String>>();
	/* DICTIONARY */


	/* PRINT FUNCTION */
	public static void printinstructionList(){
		System.out.println("** DECODED INSTRUCTIONS **");
		for(ArrayList line : instructionList)
		  { 		      
	           System.out.println(line); 		
	      }
	      System.out.println("\n");
	}
	/****************************************************************************
	* we're assuming our instructions are 32 bit binary MIPS
	* IF STAGE - fetching 32 bit lines from a piped in file 
	* feeds the 32 bit string to the decode method
	****************************************************************************/
	public static void readBinaryIF() {
		Scanner scan = new Scanner(System.in);
		//for each line (each instruction)
		while(scan.hasNextLine()){
			//this is a binary 32-bit instruction (FETCH)
			try {
				/* IF STAGE */
				String binaryString = scan.nextLine();
				System.out.println(binaryString); 
				/* DECODE STAGE) */
				BinarytoMipsDC(binaryString);
				/* EXECUTE STAGE */

				//
				
			} catch(Exception e) {
				System.out.println("its broken");

			}
		}
	}
	/****************************************************************************
	* BinarytoMips() takes a 32 bit string (binary) and returns the instruction
	* DECODE STAGE
	****************************************************************************/
	public static void BinarytoMipsDC(String binaryString) {
		// declaring our list that will hold our 32 bit decoded instruction
		ArrayList<String> decodedMips = new ArrayList<>();
		

		//begin converting here
		System.out.println(binaryString);
		

		//adding our decoded instruction to the list
		instructionList.add(decodedMips);

	}

	/****************************************************************************
	* DoTheWork() takes the converted list of lists and schedules
	* EXECUTE STAGE
	* MEMORY STAGE ??
	****************************************************************************/
	public static void DoTheWork() {

	}
	/****************************************************************************
	* prints out our final formatted answer
	****************************************************************************/

	/****************************************************************************
	* The main() runs our methods + formats
	****************************************************************************/
	public static void main(String[] args){
		readBinaryIF();
		DoTheWork(); 
		printinstructionList();


	}
}