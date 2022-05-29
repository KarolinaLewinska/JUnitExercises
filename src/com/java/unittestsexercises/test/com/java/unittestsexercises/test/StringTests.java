package com.java.unittestsexercises.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class StringTests {
    String testedString;

    @BeforeEach
    void beforeEach() {
        testedString = "This string is tested with JUnit ";
    }

    @Test
    void shouldConcatString() {
        //given
        String stringToAdd = "library";

        //when
        String concatedString = testedString.concat(stringToAdd);

        //then
        assertEquals("This string is tested with JUnit library", concatedString);
    }

    @Test
    void shouldReturnTrueWhenContains() {
        //given
        String stringToCheck = "JUnit";

        //when
        boolean trueResult = testedString.contains(stringToCheck);

        //then
        assertTrue(trueResult);
    }

    @Test
    void shouldReturnFalseWhenNotContains() {
        //given
        String stringToCheck = "Mockito";

        //when
        boolean falseResult = testedString.contains(stringToCheck);

        //then
        assertFalse(falseResult);
    }

    @Test
    void shouldReturnIndexOfString() {
        //given
        String textToCheck = "JUnit";

        //when
        int stringIndex = testedString.indexOf(textToCheck);

        //then
        assertEquals(27, stringIndex);
    }

    @Test
    void shouldReplaceOldStringToNewString() {
        //given
        String newString = "Mockito library";

        //when
        String replaceResult = testedString.replace("JUnit ", newString);

        //then
        assertEquals("This string is tested with Mockito library", replaceResult);
    }

    @Test
    void shouldConvertStringToLowerCase() {
        //given
        String expectedString = "this string is tested with junit ";

        //when
        String toLowerCaseResult = testedString.toLowerCase(Locale.ROOT);

        //then
        assertEquals(expectedString, toLowerCaseResult);
    }

    @Test
    void shouldSubstringText() {
        //given
        String expectedString = "This string";
        
        //when
        String substringResult = testedString.substring(0, 11);
        
        //then
        assertEquals(expectedString, substringResult);
    }

    @Test
    void shouldSplitStringByWhitespace() {
        //given
        String[] splittedString = {"This", "string", "is", "tested", "with", "JUnit"};

        //when
        String[] splitResult = testedString.split(" ");

        //then
        assertArrayEquals(splittedString, splitResult);
    }


    @AfterEach
    void afterEach() {
        testedString = null;
    }
}