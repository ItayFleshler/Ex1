/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..,G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”, ”012b5", “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */

public class Ex1 {

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true if the given String is in a valid number format, false otherwise.
     */

    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) {
            // Return false for null or empty strings
            return false;
        }

        if (a.contains(" ")) {
            return false;
        }

        if (!a.equals(a.trim())) {
            return false;
        }

        int bIndex = a.indexOf('b');
        if (bIndex == -1) {
            // If 'b' is missing, check if the entire string represents a valid decimal number
            return a.chars().allMatch(Character::isDigit);
        }

        if (bIndex == 0 || bIndex == a.length() - 1) {
            // Return false if 'b' is at the start or end of the string
            return false;
        }

        // Split the string into number part (before 'b') and base part (after 'b')
        String numberPart = a.substring(0, bIndex).toUpperCase(); // Convert number part to uppercase for uniformity
        String basePart = a.substring(bIndex + 1).toUpperCase(); // Convert base part to uppercase for uniformity

        // Ensure the original number part matches its uppercase version (to reject invalid characters)
        if (!numberPart.equals(a.substring(0, bIndex))) {
            return false;
        }

        int base;
        try {
            // Parse the base part as an integer in hexadecimal
            base = Integer.parseInt(basePart, 17);
        } catch (NumberFormatException e) {
            // Return false if the base part cannot be parsed
            return false;
        }

        // Check if the base is within the valid range [2,16]
        if (base < 2 || base > 16) {
            return false;
        }

        // Validate each character in the number part against the specified base
        for (char c : numberPart.toCharArray()) {
            int digitValue = Character.digit(c, base);
            if (digitValue == -1 || digitValue >= base) {
                // Return false if any character is invalid or exceeds the base
                return false;
            }
        }

        // The string is a valid number in the specified format
        return true;
    }

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format, returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return the decimal representation of the number or -1 if the format is invalid.
     */

    public static int number2Int(String num) {
        // First, check if the number is valid using isNumber
        if (!isNumber(num)) {
            return -1; // Invalid format
        }

        int bIndex = num.indexOf('b'); // Find the position of 'b' which separates the number and base
        if (bIndex == -1) { // If there is no 'b', it's a decimal number
            return Integer.parseInt(num); // Parse as decimal
        }

        String numberPart = num.substring(0, bIndex).toUpperCase(); // Extract number part and make uppercase
        String basePart = num.substring(bIndex + 1).toUpperCase(); // Extract base part and make uppercase

        int base = Integer.parseInt(basePart, 17); // Parse the base part in hexadecimal.
        int decimalValue = 0; // Initialize the result in decimal

        // Convert the number part to a decimal value using the given base
        for (char c : numberPart.toCharArray()) {
            int digitValue = Character.digit(c, base); // Get numeric value of the character in the given base
            decimalValue = decimalValue * base + digitValue; // Update the decimal value
        }
        return decimalValue; // Return the final decimal value
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num < 0 or base is not in [2,16], the function should return "" (the empty String).
     * @param num the natural number (including 0)
     * @param base the basis [2,16]
     * @return a String representing a number in the given base or an empty String for invalid inputs.
     */

    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) { // Check for invalid inputs
            return ""; // Return an empty string for invalid cases
        }

        if (num == 0) { // Handle the case for zero
            return "0";
        }

        StringBuilder output = new StringBuilder(); // Use StringBuilder for efficient string construction

        // Convert the number to the target base
        while (num > 0) {
            int res = num % base; // Find the remainder

            if (res >= 10) { // For values >= 10, convert to character representation (A, B, ...)
                output.append((char) ('A' + (res - 10)));
            } else { // For values < 10, append directly
                output.append(res);
            }

            num /= base; // Reduce the number
        }
        if (Integer.valueOf(base) < 10)
            return output.reverse() + "b" + base;
        else
            return output.reverse() + "b" + (char) ('A' + (base - 10));
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same value, false otherwise.
     */

    public static boolean equals(String n1, String n2) {
        if (n1 == null || n2 == null) { // If either of the numbers is null, return false
            return false;
        }

        int num1 = number2Int(n1); // Convert first number to decimal
        int num2 = number2Int(n2); // Convert second number to decimal

        // Check if both numbers are valid and equal in value
        return num1 != -1 && num1 == num2;
    }

    /**
     * This static function searches for the array index with the largest number (in value).
     * In case there is more than one maximum, returns the first index.
     * Note: The array is not null or empty but may contain null or invalid numbers (value -1).
     * @param arr an array of numbers
     * @return the index in the array with the largest number in value.
     */

    public static int maxIndex(String[] arr) {
        if (arr == null || arr.length == 0) { // If the array is null or empty
            return -1; // Return -1 indicating invalid input
        }

        int maxval = -1; // Initialize max value
        int maxidx = -1; // Initialize max index

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) { // Skip null elements
                continue;
            }

            int val = number2Int(arr[i]); // Convert to decimal value

            // Update max value and index if a larger value is found
            if (val > maxval) {
                maxval = val;
                maxidx = i;
            }
        }

        return maxidx; // Return the index of the maximum value
    }
}