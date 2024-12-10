import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */

public class Ex1Test {

    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (String s : good) {
            boolean ok = Ex1.isNumber(s);
            Assertions.assertTrue(ok, "Failed on: " + s);
        }

        String[] notGood = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2", "", " 135", "135 ", "1 b2", "AB bG"};
        for (String s : notGood) {
            boolean notOk = Ex1.isNumber(s);
            assertFalse(notOk, "Failed on: " + s);
        }
    }


    @Test
    void int2NumberTest() {
        assertEquals("0", Ex1.int2Number(0, 10));
        assertEquals("10b2", Ex1.int2Number(2, 2));
        assertEquals("FbG", Ex1.int2Number(15, 16));
        assertEquals("7b8", Ex1.int2Number(7, 8));
        assertEquals("101b5", Ex1.int2Number(26, 5));
        assertEquals("4b8", Ex1.int2Number(4, 8));

        // Invalid inputs
        assertEquals("", Ex1.int2Number(-1, 10)); // Negative number
        assertEquals("", Ex1.int2Number(10, 1)); // Base less than 2
        assertEquals("", Ex1.int2Number(10, 17)); // Base greater than 16
        assertEquals("", Ex1.int2Number(-10, 20)); // Negative number and invalid base
    }

    @Test
    void maxIndexTest() {
        assertEquals(0, Ex1.maxIndex(new String[]{"5", "2", "3", "0"})); // max = 5 at index 0
        assertEquals(0, Ex1.maxIndex(new String[]{"27", "6", "1", "0"})); // max = 27 at index 0
        assertEquals(1, Ex1.maxIndex(new String[]{"1", "102", "3", "101"})); // max = 102 at index 1

        // Array with invalid and null values
        assertEquals(0, Ex1.maxIndex(new String[]{"10", null, "invalid", "2"})); // max = 10 at index 0
        assertEquals(-1, Ex1.maxIndex(new String[]{null, "invalid"})); // No valid numbers
    }

    @Test
    void equalsTest() {
        assertTrue(Ex1.equals("10", "10"));
        assertTrue(Ex1.equals("5", "5"));
        assertTrue(Ex1.equals("1000", "1000"));
        assertTrue(Ex1.equals("0", "0"));

        // Not good
        assertFalse(Ex1.equals("1", "10"));
        assertFalse(Ex1.equals("1", "0"));
        assertFalse(Ex1.equals("11", "1222"));
        assertFalse(Ex1.equals(null, "10")); // Null check
        assertFalse(Ex1.equals("10", null));
        assertFalse(Ex1.equals(null, null));
    }

    @Test
    void number2intTest() {
        assertEquals(10, Ex1.number2Int("1010b2"));
        assertEquals(11, Ex1.number2Int("1011b2"));
        assertEquals(0, Ex1.number2Int("0b5"));
        assertEquals(135, Ex1.number2Int("135")); // Decimal input without 'b'
        assertEquals(93, Ex1.number2Int("135b8"));
        assertEquals(-1, Ex1.number2Int("57b16"));

        // Not good
        assertEquals(-1, Ex1.number2Int("b2"));
        assertEquals(-1, Ex1.number2Int("2b"));
        assertEquals(-1, Ex1.number2Int("13b2"));
        assertEquals(-1, Ex1.number2Int("3b3"));
        assertEquals(-1, Ex1.number2Int("5b4"));
        assertEquals(-1, Ex1.number2Int("Gb16"));
        assertEquals(-1, Ex1.number2Int("7b6"));
        assertEquals(-1, Ex1.number2Int(" ")); // Empty string
    }

    @Test
    void additionalTests() {
        // בדיקות עם רווחים
        assertEquals(-1, Ex1.number2Int(" 135 "));
        assertEquals(-1, Ex1.number2Int("135 b2"));

        // בסיסים לא חוקיים
        assertEquals(-1, Ex1.number2Int("123b17"));
        assertEquals(-1, Ex1.number2Int("123b1"));

        // מספרים חוקיים
        assertEquals(93, Ex1.number2Int("135b8"));
        assertEquals(255, Ex1.number2Int("FFbG"));
        assertEquals(29, Ex1.number2Int("1DbG"));
    }


    @Test
    void isNumberAdditionalTests() {
        String[] validNumbers = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA", "FFbG"};
        for (String s : validNumbers) {
            assertTrue(Ex1.isNumber(s), "Failed on: " + s);
        }

        String[] invalidNumbers = {"b2", "0b1", "123b", "1234b11", "3b3", "-3b5", "3 b4", "GbG", "", null, "135 b8"};
        for (String s : invalidNumbers) {
            assertFalse(Ex1.isNumber(s), "Failed on: " + s);
        }
    }


    @Test
    void number2IntAdditionalTests() {
        assertEquals(255, Ex1.number2Int("FFbG"), "Failed to convert FFbG");
        assertEquals(27, Ex1.number2Int("1BbG"), "Failed to convert 1BbG");
        assertEquals(120, Ex1.number2Int("AAbB"), "Failed to convert AAbB");
        assertEquals(-1, Ex1.number2Int("ZZb16"), "Invalid number passed as valid");
    }

    @Test
    void int2NumberAdditionalTests() {
        assertEquals("101b2", Ex1.int2Number(5, 2), "Binary representation failed");
        assertEquals("FbG", Ex1.int2Number(15, 16), "Hexadecimal representation failed");
    }
}
