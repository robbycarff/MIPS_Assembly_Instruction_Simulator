
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

	/* LISTS */
	private static ArrayList<ArrayList<String>> instructionList = new ArrayList<ArrayList<String>>();

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
		System.out.println("binary String:  " + binaryString);

		// new list for storing the decoded instruction
		ArrayList<String> decodedMips = new ArrayList<String>();

		/* DECODING BINARY STRING HERE */ 
		String type = binaryString.substring(0,6); // this is our parse code
		
		//  type 01
		if(type.equals("000000")){
			String rs = binaryString.substring(6,11);
			String rt = binaryString.substring(11,16);
			String rd = binaryString.substring(16,21);
			String register4 = binaryString.substring(21,26);
			String register5 = binaryString.substring(26,32);
			if(register5.equals("100000")){ // add
				// fist half of list
				decodedMips.add(type);
				decodedMips.add(rs);
				decodedMips.add(rt);
				decodedMips.add(rd);
				decodedMips.add(register4);
				decodedMips.add(register5);
				//delimeter
				decodedMips.add("*");
				//second half of list
				decodedMips.add("add");
				decodedMips.add("01");
				decodedMips.add(type);
				decodedMips.add("rs");
				decodedMips.add("rt");
				decodedMips.add("rd");
				decodedMips.add(register4);
				decodedMips.add(register5);
				/* STORING DECODED STRING */
				instructionList.add(decodedMips);	
				System.out.println(decodedMips.size());
			}
			if(register5.equals("101010")){ // add
				// fist half of list
				decodedMips.add(type);
				decodedMips.add(rs);
				decodedMips.add(rt);
				decodedMips.add(rd);
				decodedMips.add(register4);
				decodedMips.add(register5);
				//delimeter
				decodedMips.add("*");
				//second half of list
				decodedMips.add("slt");
				decodedMips.add("01");
				decodedMips.add(type);
				decodedMips.add("rs");
				decodedMips.add("rt");
				decodedMips.add("rd");
				decodedMips.add(register4);
				decodedMips.add(register5);
				/* STORING DECODED STRING */
				instructionList.add(decodedMips);	
				System.out.println(decodedMips.size());
			}
			if(register5.equals("001100")){ //syscall
				// fist half of list
				decodedMips.add(type);
				decodedMips.add(rs);
				decodedMips.add(rt);
				decodedMips.add(rd);
				decodedMips.add(register4);
				decodedMips.add(register5);
				//delimeter
				decodedMips.add("*");
				//second half of list
				decodedMips.add("syscall");
				decodedMips.add("09");
				decodedMips.add(type);
				decodedMips.add("code");
				decodedMips.add(register5);
				decodedMips.add(" ");
				decodedMips.add(" ");
				decodedMips.add(" ");
				/* STORING DECODED STRING */
				instructionList.add(decodedMips);	
				System.out.println(decodedMips.size());
			}
			if(register5.equals("000000")){ // sll
				// fist half of list
				decodedMips.add(type);
				decodedMips.add(rs);
				decodedMips.add(rt);
				decodedMips.add(rd);
				decodedMips.add(register4);
				decodedMips.add(register5);
				//delimeter
				decodedMips.add("*");
				//second half of list
				decodedMips.add("sll");
				decodedMips.add("02");
				decodedMips.add(type);
				decodedMips.add(rs);
				decodedMips.add("rt");
				decodedMips.add("rd");
				decodedMips.add("sa");
				decodedMips.add(register5);
				/* STORING DECODED STRING */
				instructionList.add(decodedMips);	
				System.out.println(decodedMips.size());
			}
		}

		if(type.equals("001001")){ //addiu
			String rs = binaryString.substring(6,11);
			String rt = binaryString.substring(11,16);
			String rd = binaryString.substring(16,21);
			String register4 = binaryString.substring(21,26);
			String register5 = binaryString.substring(26,32);
			// fist half of list
			decodedMips.add(type);
			decodedMips.add(rs);
			decodedMips.add(rt);
			decodedMips.add(rd);
			decodedMips.add(register4);
			decodedMips.add(register5);
			//delimeter
			decodedMips.add("*");
			//second half of list
			decodedMips.add("addiu");
			decodedMips.add("26");
			decodedMips.add(type);
			decodedMips.add("rs");
			decodedMips.add("rt");
			decodedMips.add("immediate");
			decodedMips.add(" ");
			decodedMips.add(" ");
			/* STORING DECODED STRING */
			instructionList.add(decodedMips);	
			System.out.println(decodedMips.size());
			}
		if(type.equals("001000")){ //addiu
			String rs = binaryString.substring(6,11);
			String rt = binaryString.substring(11,16);
			String rd = binaryString.substring(16,21);
			String register4 = binaryString.substring(21,26);
			String register5 = binaryString.substring(26,32);
			// fist half of list
			decodedMips.add(type);
			decodedMips.add(rs);
			decodedMips.add(rt);
			decodedMips.add(rd);
			decodedMips.add(register4);
			decodedMips.add(register5);
			//delimeter
			decodedMips.add("*");
			//second half of list
			decodedMips.add("addi");
			decodedMips.add("26");
			decodedMips.add(type);
			decodedMips.add("rs");
			decodedMips.add("rt");
			decodedMips.add("immediate");
			decodedMips.add(" ");
			decodedMips.add(" ");
			/* STORING DECODED STRING */
			instructionList.add(decodedMips);	
			System.out.println(decodedMips.size());
			}
		if(type.equals("001111")){ //lui
			String rs = binaryString.substring(6,11);
			String rt = binaryString.substring(11,16);
			String rd = binaryString.substring(16,21);
			String register4 = binaryString.substring(21,26);
			String register5 = binaryString.substring(26,32);
			// fist half of list
			decodedMips.add(type);
			decodedMips.add(rs);
			decodedMips.add(rt);
			decodedMips.add(rd);
			decodedMips.add(register4);
			decodedMips.add(register5);
			//delimeter
			decodedMips.add("*");
			//second half of list
			decodedMips.add("lui");
			decodedMips.add("20");
			decodedMips.add(type);
			decodedMips.add(rs);
			decodedMips.add("rt");
			decodedMips.add("immediate");
			decodedMips.add(" ");
			decodedMips.add(" ");
			/* STORING DECODED STRING */
			instructionList.add(decodedMips);	
			System.out.println(decodedMips.size());
			}
		if(type.equals("001101")){ //ori
			String rs = binaryString.substring(6,11);
			String rt = binaryString.substring(11,16);
			String rd = binaryString.substring(16,21);
			String register4 = binaryString.substring(21,26);
			String register5 = binaryString.substring(26,32);
			// fist half of list
			decodedMips.add(type);
			decodedMips.add(rs);
			decodedMips.add(rt);
			decodedMips.add(rd);
			decodedMips.add(register4);
			decodedMips.add(register5);
			//delimeter
			decodedMips.add("*");
			//second half of list
			decodedMips.add("ori");
			decodedMips.add("26");
			decodedMips.add(type);
			decodedMips.add("rs");
			decodedMips.add("rt");
			decodedMips.add("immediate");
			decodedMips.add(" ");
			decodedMips.add(" ");
			/* STORING DECODED STRING */
			instructionList.add(decodedMips);	
			System.out.println(decodedMips.size());
			}
		if(type.equals("000101")){ //bne
			String rs = binaryString.substring(6,11);
			String rt = binaryString.substring(11,16);
			String rd = binaryString.substring(16,21);
			String register4 = binaryString.substring(21,26);
			String register5 = binaryString.substring(26,32);
			// fist half of list
			decodedMips.add(type);
			decodedMips.add(rs);
			decodedMips.add(rt);
			decodedMips.add(rd);
			decodedMips.add(register4);
			decodedMips.add(register5);
			//delimeter
			decodedMips.add("*");
			//second half of list
			decodedMips.add("bne");
			decodedMips.add("26");
			decodedMips.add(type);
			decodedMips.add("rs");
			decodedMips.add("rt");
			decodedMips.add("offset");
			decodedMips.add(" ");
			decodedMips.add(" ");
			/* STORING DECODED STRING */
			instructionList.add(decodedMips);	
			System.out.println(decodedMips.size());
			}
		if(type.equals("000010")){ //j
			String rs = binaryString.substring(6,11);
			String rt = binaryString.substring(11,16);
			String rd = binaryString.substring(16,21);
			String register4 = binaryString.substring(21,26);
			String register5 = binaryString.substring(26,32);
			// fist half of list
			decodedMips.add(type);
			decodedMips.add(rs);
			decodedMips.add(rt);
			decodedMips.add(rd);
			decodedMips.add(register4);
			decodedMips.add(register5);
			//delimeter
			decodedMips.add("*");
			//second half of list
			decodedMips.add("j");
			decodedMips.add("24");
			decodedMips.add(type);
			decodedMips.add("instrindex");
			decodedMips.add(" ");
			decodedMips.add(" ");
			decodedMips.add(" ");
			decodedMips.add(" ");
			/* STORING DECODED STRING */
			instructionList.add(decodedMips);	
			System.out.println(decodedMips.size());
			}
	}

	/****************************************************************************
	* DoTheWork() is the simulation - it reads from the decoded list 
	* EXECUTE STAGE
	* MEMORY STAGE ??
	****************************************************************************/
	public static void DoTheWork() {
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

		//simulate 

	}


	/****************************************************************************
	* format function
	****************************************************************************/
	public static void printSchedule(){
		System.out.println("\n");

		for (int j = 0; j < instructionList.size(); j++){
				System.out.format("%8s%8s%8s%8s%8s%8s%8s%8s%8s%8s%8s%8s%12s%8s%8s", instructionList.get(j).get(0), instructionList.get(j).get(1), 
															  instructionList.get(j).get(2), instructionList.get(j).get(3), 
															  instructionList.get(j).get(4), instructionList.get(j).get(5),
															  instructionList.get(j).get(6), instructionList.get(j).get(7),
															  instructionList.get(j).get(8), instructionList.get(j).get(9), 
															  instructionList.get(j).get(10), instructionList.get(j).get(11),
															  instructionList.get(j).get(12), instructionList.get(j).get(13),
															  instructionList.get(j).get(14));
			System.out.println("\n");
		}
	}

	/****************************************************************************
	* The main() runs our methods
	****************************************************************************/
	public static void main(String[] args){
		readBinaryIF();
		printSchedule();
	}
}