package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;


public class calculatorproject {




        public static void main(String[] args) throws FileNotFoundException
        { startCalc();









            // add a welcome message here

            // comment out either startCalc() or testCalc() (just the method call below)
            // based on how you want to run the project:
            // uncomment startCalc() to call your method for an interactive calculator
            // uncomment testCalc() to try out a bunch of

            // startCalc();   // you have to write this method below
            // it should ask the user for input and print
            // results until the user enters "quit" to stop


            // use this to validate your project (the calculator part, anyways)
            // testCalc();     // testCalc will call a calculate(String s) method that you create
            // as part of your overall project. This method will take the user's
            // input, and return a String with the appropriate output.

            // add a goodbye message here

        }
        public static void startCalc(){
            // your code here to get user input, and calculate/print results. You'll call
            // the calculate(String s) as part of your code here, which returns a String
            // with the result to print.
            System.out.println("Welcome to my calculator");
            Scanner answer = new Scanner(System.in);
            System.out.println("Enter an  expression remember use spaces");
            String s = answer.nextLine();
            System.out.println(calculate(s));

        }

        public static String calculate(String s){
            int numberscanned = 0;
            double num1 = 0;
            double num2 = 0;
            int numberscanned2 = 0;
            Scanner answer2= new Scanner(s);
            String operation = "";

            if (answer2.hasNextInt()) {

                numberscanned = answer2.nextInt();
                num1 = numberscanned;
               operation = answer2.next();
                if (answer2.hasNextInt()) {

                    numberscanned2 = answer2.nextInt();
                    num2 = numberscanned2;
                }

                return TwoOperand(answer2,num1,num2,operation);
            } else {
                String symbol = answer2.next();
                numberscanned = answer2.nextInt();
                num1 = numberscanned;
              /*  numberscanned2 = answer2.nextInt();
                num2 = numberscanned2;*/

                return OneOP(answer2, symbol, num1, num2);
            }
        }
    public static String OneOP(Scanner answer2,String symbol,double num1,double num2) {

            String lmfao="";

              if (symbol.equals("v")){

                  double an= Math.sqrt(num1);
                  String baka= Double. toString(an);
                  lmfao=baka;
              }

          return lmfao;
    }

            public static String TwoOperand(Scanner answer2, double num1, double num2, String operation){
                String majic="";


                if (operation.equals("+")) {
                    double an=num1 + num2;
                    String baka= Double. toString(an);
                    majic=baka;

                }
                if (operation.equals("-")) {
                    double an=num1 - num2;
                    String baka= Double.toString(an);
                    majic=baka;
                }

                if (operation.equals("/")) {
                    double an= num1/num2;
                    String baka= Double. toString(an);
                    majic=baka;
                }
                if (operation.equals("*")) {
                    double an= num1*num2;
                    String baka= Double. toString(an);
                    majic=baka;

                }

                return majic;
            }
            // you add code here to take a String as a parameter, and return a String with the result

            // you'll probably call other methods (that you write) here to do work,
            // like deciding if it's a 2-part or 3-part expression, or calculating the result of a
            // 2-part expression or a 3-part expression



        // add more methods here

        //
        // DO NOT MODIFY THE METHOD BELOW!!!
        // YOU WILL CALL IT FROM MAIN TO TEST OUT YOUR OTHER CODE/METHODS
        //
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

