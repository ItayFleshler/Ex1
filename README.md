# Ex1 – Number Formatter and Calculator

## Overview
This project provides a solution for the Ex1 assignment, focusing on implementing a number formatting converter and calculator. The algorithm processes numbers as strings in the format `<number>b<base>`, where `<base>` belongs to the set `{2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F, G}`.

---

## Examples

### **Valid Numbers**
- `1011b2` – Binary representation
- `123bA` – Decimal representation with default base
- `FFbG` – Base-G representation

### **Invalid Numbers**
- `B2` – Missing base specification
- `123b` – Missing base
- `135 b8` – Improper formatting

---

## Implemented Functions
The core logic resides in the `Ex1` class, with the following static methods:

### `isNumber(String a)`
**Purpose:** Verifies if a string is a valid number in the `<number>b<base>` format.

**Returns:**
- `true` if the string is valid.
- `false` if the string is invalid.

**Examples:**
- Input: `"1011b2"` → Output: `true`
- Input: `"b2"` → Output: `false`

### `number2Int(String num)`
**Purpose:** Converts a valid string-based number to its decimal (base-10) integer representation.

**Returns:**
- Decimal integer if valid.
- `-1` if invalid.

**Examples:**
- Input: `"1011b2"` → Output: `11`
- Input: `"123bA"` → Output: `123`

### `int2Number(int num, int base)`
**Purpose:** Converts an integer to a string representation in a given base (range: 2-16).

**Returns:**
- String representation if valid.
- Empty string (`""`) if input is invalid (negative number or unsupported base).

**Examples:**
- Input: `15, 16` → Output: `"FbG"`
- Input: `26, 5` → Output: `"101b5"`

### `equals(String n1, String n2)`
**Purpose:** Compares two numbers (potentially in different bases) for equality.

**Returns:**
- `true` if the numbers are equal.
- `false` if they are not equal or one is invalid.

**Examples:**
- Input: `"1011b2", "11"` → Output: `true`
- Input: `"123bA", "7b2"` → Output: `false`

### `maxIndex(String[] arr)`
**Purpose:** Finds the index of the largest valid string-formatted number in an array.

**Returns:**
- Index of the largest number if valid numbers exist.
- `-1` if the array is empty, null, or contains only invalid numbers.

**Examples:**
- Input: `{"1011b2", "135", "7b8"}` → Output: `1`
- Input: `{null, "invalid"}` → Output: `-1`

---

## Features

### **Validation**
- Ensures input adheres to the format `<number>b<base>`.

### **Conversion**
- Converts string-based numbers to decimal integers and vice versa.

### **Arithmetic**
- Performs addition and multiplication in decimal representation.
- Converts results back to the specified base.

### **Maximum Finder**
- Identifies the largest number from a list of string-formatted numbers.

---

## How to Run

### **Setup**
- Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).

### **Run**
- Execute the `Ex1Main` class.
- Follow interactive prompts to input numbers and specify operations or bases.
- Type `quit` to exit the program.

**Sample Input and Output:**

**Input:**
```
Enter a string as number#1: 1011b2
Enter a string as number#2: 10
Enter a base for output: 2
```

**Output:**
```
1011b2 + 10 = 10101b2
1011b2 * 10 = 11010b2
Max number over: [1011b2, 10, 10101b2, 11010b2] is: 11010b2 (index: 3)
```

---

## Testing

### **Validation Tests**
- **Test Name:** `isBasisNumberTest`
- **What it tests:** Verifies valid and invalid number formats.
- **Example:** Ensures strings like `"1b2"` are valid while `"135 b8"` are invalid.

### **Conversion Tests**
#### `computeNumberTest`
- **What it tests:** Validates the conversion of numbers between string and integer formats.
- **Example:** Ensures `"1011b2"` converts to `11` and back to `"1011b2"`.
#### `int2NumberTest`
- **What it tests:** Tests integer-to-string conversion across various bases.
- **Example:** Converts `15` to `"FbG"` and `26` to `"101b5"`.

### **Arithmetic Tests**
- **Test Name:** `computeNumberTest`
- **What it tests:** Checks equivalency of numbers and conversion integrity.
- **Example:** Ensures `"1011b2"` is equal to `"11"` after conversion.

### **Maximum Finder Tests**
#### `maxIndexTest`
- **What it tests:** Identifies the largest number's index in a mixed list of valid and invalid inputs.
- **Example:** For `{"1011b2", "135", "7b8"}`, the maximum index is `1`.

### **Additional Tests**
#### `additionalTests`
- **What it tests:** Handles edge cases such as spaces, invalid bases, and valid conversions.
- **Example:** Ensures `"135 b8"` fails, but `"FFbG"` returns `255`.
#### `isNumberAdditionalTests`
- **What it tests:** Validates strings in various formats to ensure compliance.
- **Example:** Ensures `"ABbG"` is valid and `"1234b11"` is invalid.
#### `number2IntAdditionalTests`
- **What it tests:** Converts valid numbers and ensures invalid numbers return `-1`.
- **Example:** `"FFbG"` converts to `255`, while `"ZZb16"` fails.
#### `int2NumberAdditionalTests`
- **What it tests:** Confirms correct conversion for integers to different bases.
- **Example:** Converts `5` to `"101b2"` and `15` to `"FbG"`.

---

## Code Files

- **Ex1.java:** Contains all core logic.
- **Ex1Test.java:** Includes JUnit tests.
- **Ex1Main.java:** Provides an interactive interface.

