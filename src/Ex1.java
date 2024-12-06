/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
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
            return false;
        }

        int bIndex = a.indexOf('b');
        if (bIndex == -1) {
            boolean allDigits = a.chars().allMatch(Character::isDigit);
            return allDigits;
        }

        if (bIndex == 0 || bIndex == a.length() - 1) {
            return false;
        }
        String numberPart = a.substring(0, bIndex).toUpperCase();
        String basePart = a.substring(bIndex + 1).toUpperCase();
        if(!numberPart.equals(a.substring(0, bIndex)))
            return false;
        int base;
        try {
            base = Integer.parseInt(basePart, 17);
        } catch (NumberFormatException e) {
            return false;
        }
        if (base < 2 || base > 16) {
            return false;
        }

        for (char c : numberPart.toCharArray()) {
            int digitValue = Character.digit(c, base);
            if (digitValue == -1 || digitValue >= base) {
                return false;
            }
        }

        return true;
    }

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format, returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return the decimal representation of the number or -1 if the format is invalid.
     */

    public static int number2Int(String num) {
        if (!isNumber(num)) {
            return -1;
        }

        int bIndex = num.indexOf('b');
        if (bIndex == -1) {
            return Integer.parseInt(num);
        }

        String numberPart = num.substring(0, bIndex).toUpperCase();
        String basePart = num.substring(bIndex + 1).toUpperCase();

        int base = Integer.parseInt(basePart, 17);
        int decimalValue = 0;
        for (char c : numberPart.toCharArray()) {
            int digitValue = Character.digit(c, base);
            decimalValue = decimalValue * base + digitValue;
        }
        return decimalValue;
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
        if (num < 0 || base < 2 || base > 16) {
            return "";
        }

        if (num == 0) {
            return "0";
        }

        StringBuilder output = new StringBuilder();

        while (num > 0) {
            int res = num % base;

            if (res >= 10) {
                output.append((char) ('A' + (res - 10)));
            } else {
                output.append(res);
            }

            num /= base;
        }

        return output.reverse().toString();
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same value, false otherwise.
     */

    public static boolean equals(String n1, String n2) {
        if (n1 == null || n2 == null) {
            return false;
        }

        int num1 = number2Int(n1);
        int num2 = number2Int(n2);

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
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int maxval = -1;
        int maxidx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }

            int val = number2Int(arr[i]);

            if (val > maxval) {
                maxval = val;
                maxidx = i;
            }
        }

        return maxidx;
    }
}