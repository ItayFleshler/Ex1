# Ex1 – Number Formatter and Calculator

## Overview 

This project is a solution for the Ex1 assignment, which focuses on implementing a number formatting converter and calculator. The algorithm maintains numbers in string format with the structure `<number><b><base>` base , with base in the set {2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F, G}.

### Examples

  **Valid Numbers**

1011b2 (Binary representation)

123bA (Base 10 with default base representation)

FFbG (Hexadecimal representation)

  **Invalid Numbers**

B2, 123b, 135 b8 (Cannot be obtained due to the absence of or error in base or formatting).

## Implemented Functions

The main logic resides in the Ex1 class, and the following static functions reside in:.

 1. `isNumber(String a)`

Verifies whether a string is a valid number in the format `<number><b><base>`.

 #### Returns: 

true: If the string is valid.

false: If the string is invalid.

 #### Examples: 

Valid: "1011b2", "135bA"

Invalid: "b2", "135 b8"

 2. `number2Int(String num)`

Transforms a well-formed string-based number in decimal (base-10) style to its decimal (base-10) integer representation.

 #### Returns: 

The decimal value: If the input is valid.

-1: If the input is invalid.

 #### Examples: 

Input: "1011b2" → Output: 11

Input: "123bA" → Output: 123

 3. `int2Number(int num, int base)`

Transforms an integer to string representation in given base [2,16].

 #### Returns: 

The string representation: If inputs are valid.

"": Just do not accept an invalid negative number input or an invalid base.

 #### Examples: 

Input: 15, 16 → Output: "FbG"

Input: 26, 5 → Output: "101b5"

 4. `equals(String n1, String n2)`

Tests whether two numbers (that may be in different systems of base) are equal.

 #### Returns: 

true: If the numbers are equal.

false: But if they are not equal or one of them is not valid.

 #### Examples: 

Input: "1011b2", "11" → Output: true

Input: "123bA", "7b2" → Output: false

 5. `maxIndex(String[] arr)`

Gets the index of the biggest string-formatted number in an array of string-formatted numbers.

 #### Returns: 

The index of the largest number: If valid numbers exist.

-1: If the array is empty, nil or consists only invalid numbers.

 #### Examples: 

Input: {"1011b2", "135", "7b8"} → Output: 1

Input: {null, "invalid"} → Output: -1

## Features

 #### Format Validation

  `<number><b><base>`

 #### Conversion

  convert string numbers to decimal integers and vice versa.

 #### Arithmetic

  Add and multiply numbers in decimal representation.

  Convert the results to a specified base.

 #### Maximum Finder

   Given a list of string numbers so that each string represents an integer, determine the largest string integer in the given list.

## How to Run

Run the `Ex1Main` file.

Interactive prompts will appear. Input numbers to check or operate on.

specify a base (one of [2,16]) for the output.

Type quit to terminate the program.

### Sample Input and Output

Input: 

Enter a string as number#1: 1011b2

Enter a string as number#2: 10

Enter a base for output: 2

Output: 

1011b2 + 10 = 10101b2

1011b2 * 10 = 11010b2

Max number over: [1011b2, 10, 10101b2, 11010b2] is: 11010b2 (index: 3)

## Testing

JUnit tests are provided for correctness and robustness. Some key test categories include:

### Validation Tests

Valid and invalid number formats.

### Conversion Tests

Check correctness of string to decimal, and vice-versa conversions. Arithmetic Tests Test addition and multiplication across bases. Maximum Finder Tests Ensure the return of the appropriate index of the most extreme value, for both mixed valid/invalid inputs. Edge Cases Input validation for invalid, null, or edge cases (e.g., out-of-bound bases or incorrectly-formatted strings, etc). Files Included

## Code Files
`Ex1.java`: Contains all the core logic.

`Ex1Test.java`: Contains JUnit tests.

`Ex1Main.java`: The interactive interface.
