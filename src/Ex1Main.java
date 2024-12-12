import java.util.Arrays;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner to read user input
        String num1 = "", num2 = "", quit = "quit"; // Initialize variables for input and quit condition

        while (!num1.equals(quit) && !num2.equals(quit)) { // Loop until user enters "quit"
            System.out.println();
            System.out.println("Ex1 class solution:");

            // Read the first number from user
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.nextLine().trim(); // Trim removes extra spaces from the input

            if (!num1.equals(quit)) { // Check if the user wants to quit
                System.out.println("num1 = " + num1 + " is number: " + Ex1.isNumber(num1) + " value: " + Ex1.number2Int(num1));
                // Read the second number from user
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.nextLine().trim(); // Trim removes extra spaces from the input
                if (!num2.equals(quit)) { // Check if the user wants to quit
                    System.out.println("num2 = " + num2 + " is number: " + Ex1.isNumber(num2) + " value: " + Ex1.number2Int(num2));

                    // Validate both inputs
                    if (!Ex1.isNumber(num1) || !Ex1.isNumber(num2)) {
                        System.out.println("ERR: One of the numbers is in the wrong format!"); // Error if input is invalid
                        continue; // Skip to the next iteration
                    }

                    // Ask for the base for calculations
                    System.out.println("Enter a base for output: (a number [2,16])");
                    int base = sc.nextInt(); // Read base as integer
                    sc.nextLine(); // Clear the scanner buffer
                    // Convert base to string format for bases > 9

                    // Perform addition and display result
                    int addition = Ex1.number2Int(num1) + Ex1.number2Int(num2);
                    System.out.println(num1 + " + " + num2 + " = " + Ex1.int2Number(addition, base) );

                    // Perform multiplication and display result
                    int multiplication = Ex1.number2Int(num1) * Ex1.number2Int(num2);
                    System.out.println(num1 + " * " + num2 + " = " + Ex1.int2Number(multiplication, base));

                    // Prepare an array of results
                    String[] results = {num1, num2, Ex1.int2Number(addition, base) , Ex1.int2Number(multiplication, base)};
                    int maxIdx = Ex1.maxIndex(results); // Find the index of the maximum value

                    // Check if a valid maximum was found and display it
                    if (maxIdx != -1) {
                        System.out.println("Max number over: " + Arrays.toString(results) + " is: " + results[maxIdx] + " (index: " + maxIdx + ")");
                    } else {
                        System.out.println("No valid maximum found in the array."); // Error if all are invalid
                    }
                }
            }
        }
        System.out.println("Quitting now..."); // Exit message
    }
}
