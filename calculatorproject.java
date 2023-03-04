package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;


public class Main {


	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to my calculator");
		startCalc(); // calling the start calc method
		System.out.println("Goodbye");

		

	}

	public static void startCalc() {
		String Q;
		String s;
		Scanner answer = new Scanner(System.in);
		
		do {
			System.out.println("Enter an  expression remember use spaces");
			 s = answer.nextLine();
			 if(!(s.equalsIgnoreCase("quit"))){
				 if (calculate(s).equalsIgnoreCase("error")) {
					 System.out.println("ERROR");
				 } else {
					 System.out.println(s + " = " + calculate(s));
				 }
			}

		} while (!(s.equalsIgnoreCase("quit")));

	}

	public static String calculate(String s) {

		double numberscanned = 0;
		double num1 = 0;
		double num2 = 0;
		Double numberscanned2;
		Scanner answer2 = new Scanner(s);
		String operation = "";


		if (answer2.hasNextDouble()) {

			numberscanned = answer2.nextDouble();
			num1 = numberscanned;
			operation = answer2.next();
			if (answer2.hasNextDouble()) {
				numberscanned2 = answer2.nextDouble();
				num2 = numberscanned2;
			} else return "ERROR";
             if (answer2.hasNext()) {
             	return "ERROR";
			 } else return TwoOperand(answer2, num1, num2, operation);
		} else if (answer2.hasNext()) {
			String symbol = answer2.next();
			if(answer2.hasNextDouble()) {
				numberscanned = answer2.nextDouble();
				num1 = numberscanned;
              if(answer2.hasNext()){
              	return "ERROR" ;
			  }
              else return OneOP(answer2, symbol, num1);
			} else return "ERROR";
		}
		else return "ERROR";
	}

	public static String OneOP(Scanner answer2,String symbol,double num1) {

		String result="";
		if (!(symbol.equals("v")||symbol.equals("|")|| symbol.equals("s") || symbol.equals("c") || symbol.equals("tan") )) {
		return "ERROR";

		}
		if (symbol.equals("v")){

			double an= Math.sqrt(num1);
			return String.valueOf(an);
		}
		else
		if (symbol.equals("|")) {
			double an= Math.abs(num1);
			return String.valueOf(an);
		}
		else
		if (symbol.equals("s")) {
			double an= Math.sin(num1);
			return String.valueOf(an);
		}
		else
		if (symbol.equals("c")) {
			double an= Math.cos(num1);
			return String.valueOf(an);
		}
		else
		if (symbol.equals("t")) {
			double an= Math.tan(num1);
			return String.valueOf(an);
		}
		else
		return "ERROR";
	}

	public static String TwoOperand(Scanner answer2, double num1, double num2, String operation){
		String majic;

		if (operation.equals("+")) {
			double an=num1 + num2;
			majic= Double. toString(an);
			return majic;
		}
		else if (operation.equals("-")) {
			double an=num1 - num2;
			majic= Double.toString(an);
			return majic;
		}

		else if (operation.equals("/")) {
			double an= num1/num2;
			majic= Double. toString(an);
			return majic;
		}
		else if (operation.equals("*")) {
			double an= num1*num2;
			return Double. toString(an);


		} else return "ERROR";
	}
	
	public static void testCalc() throws FileNotFoundException{
		ArrayList<String> problems = new ArrayList<>();
		ArrayList<String> results = new ArrayList<>();
		// load problems from a file
		File fProblems = new File("problems.txt");
		Scanner sc = new Scanner(fProblems);
		int count = 0;
		String line = "";
		int problemCount = 0;
		int resultCount = 0;
		while (sc.hasNextLine()){
			line = sc.nextLine();
			if (!line.startsWith("//") && !line.trim().equals("")){        // ignore comments at the beginning
				problems.add(line.substring(3).trim());
				problemCount++;
				if (sc.hasNextLine()){
					line = sc.nextLine();
					if (!line.startsWith("//") && !line.trim().equals("")){
						results.add(line.substring(3).trim());
						resultCount++;
					}
				}
				count++;
			}
		}
		if (problemCount == resultCount){
			// now run the tests
			for (int i=0; i<problemCount; i++){
				String prob = problems.get(i);
				String result = calculate(prob);
				if (result == null){
					System.out.println("FAILED test " + i);
					System.out.println("Expression: " + problems.get(i));
					System.out.println("Expected result: " + results.get(i));
					System.out.println("Actual: null String returned from calculate()");
				} else {
					if (result.equals(results.get(i))){
						System.out.println("PASSED test " + i);
					} else {
						System.out.println("FAILED test " + i);
						System.out.println("Expression: " + problems.get(i));
						System.out.println("Expected result: " + results.get(i));
						System.out.println("Actual: " + result);
					}
				}

			}
		} else {
			System.out.println("problem file error");
		}

	}




}
