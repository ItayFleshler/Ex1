import java.util.Arrays;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        String[] results;
        String baseres = "";
        int base, addition, multiplication;

        while (true) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (num1.equals(quit)) {
                break;
            }

            boolean isNum1Valid = Ex1.isNumber(num1);
            int num1Value = Ex1.number2Int(num1);
            System.out.println("num1 = " + num1 + " is number: " + isNum1Valid + " value: " + num1Value);
            if (!isNum1Valid) {
                System.out.println("ERR: num1 is in the wrong format!");
                continue;
            }

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals(quit)) {
                break;
            }

            boolean isNum2Valid = Ex1.isNumber(num2);
            int num2Value = Ex1.number2Int(num2);
            System.out.println("num2 = " + num2 + " is number: " + isNum2Valid + " value: " + num2Value);
            if (!isNum2Valid) {
                System.out.println("ERR: num2 is in the wrong format!");
                continue;
            }

            System.out.println("Enter a base for output: (a number [2,16])");
            base = sc.nextInt();
            if (base < 2 || base > 16) {
                System.out.println("ERR: Base must be in the range [2,16]!");
                continue;
            }

            baseres = base > 9 ? Integer.toString(base, 16).toUpperCase() : String.valueOf(base);
            addition = num1Value + num2Value;
            multiplication = num1Value * num2Value;

            System.out.println(num1 + " + " + num2 + " = " + Ex1.int2Number(addition, base) + "b" + baseres);
            System.out.println(num1 + " * " + num2 + " = " + Ex1.int2Number(multiplication, base) + "b" + baseres);

            results = new String[]{
                    num1,
                    num2,
                    Ex1.int2Number(addition, base) + "b" + baseres,
                    Ex1.int2Number(multiplication, base) + "b" + baseres
            };

            int maxIndex = Ex1.maxIndex(results);
            if (maxIndex == -1) {
                System.out.println("ERR: No valid numbers to compare.");
            } else {
                System.out.println("Max number over: " + Arrays.toString(results) +
                        " is: " + results[maxIndex] +
                        " (index: " + maxIndex + ")");
            }
        }
        System.out.println("Quitting now...");
    }
}
