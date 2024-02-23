package textrpg.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    @DisplayName("Test getBorderString with non-empty string")
    void testGetBorderStringWithNonEmptyString() {
        String word = "hello";
        String expected = "-----";
        String actual = Utils.getBorderString(word);
        assertEquals(expected, actual, "The border string does not match the expected output.");
    }

    @Test
    @DisplayName("Test getBorderString with empty string")
    void testGetBorderStringWithEmptyString() {
        String word = "";
        String expected = "";
        String actual = Utils.getBorderString(word);
        assertEquals(expected, actual, "The border string for an empty string should be empty.");
    }

    @Test
    @DisplayName("Test getBorderString with single character")
    void testGetBorderStringWithSingleCharacter() {
        String word = "a";
        String expected = "-";
        String actual = Utils.getBorderString(word);
        assertEquals(expected, actual, "The border string for a single character should be a single dash.");
    }

}