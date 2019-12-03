
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
		System.out.println("** DECODED INSTRUCTION LIST **");
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

				/* DECODE STAGE) */
				BinarytoMipsDC(binaryString);


				/* EXECUTE STAGE */
				DoTheWork();
			
				
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
		System.out.println("binary String:" + binaryString);
		//list that will hold our 32 bit decoded instruction
		ArrayList<String> decodedMips = new ArrayList<>();
		//setup some sort of line structure here



		/* DECODING BINARY STRING HERE */ 
		String type = binaryString.substring(0,2);
		System.out.println("Instruction type: " + type);

		String register1 = binaryString.substring(2,8);
		System.out.println("Register1: " + register1);

		String register2 = binaryString.substring(8,14);
		System.out.println("Register2: " + register2);

		String register3 = binaryString.substring(14,20);
		System.out.println("Register3: " + register3);
		
		String register4 = binaryString.substring(20,26);
		System.out.println("Register4: " + register4);
		
		String register5 = binaryString.substring(26,32);
		System.out.println("Register5: " + register5);








		/* PRINTING AND STORING DECODED STRING */
		System.out.println("Decoded String:");
		for(String line : decodedMips) { 		      
	           System.out.println(line); 		
	      }
	    System.out.println("\n");

		instructionList.add(decodedMips);
	}

	/****************************************************************************
	* DoTheWork() is the simulation - it reads from the decoded list 
	* EXECUTE STAGE
	* MEMORY STAGE ??
	****************************************************************************/
	public static void DoTheWork() {

	}

	/****************************************************************************
	* The main() runs our methods
	****************************************************************************/
	public static void main(String[] args){
		readBinaryIF();
		printinstructionList();
	}
}