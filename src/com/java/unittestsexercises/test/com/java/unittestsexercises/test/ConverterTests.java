package com.java.unittestsexercises.test;

import com.java.unittestsexercises.main.converter.Converter;
import com.java.unittestsexercises.main.converter.IncorrectArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ConverterTests {

    @Test
    public void whenConvertNumberStringToIntThenReturnInt() throws IncorrectArgumentException {
        //given
        String numberText = "10";

        //when
        int result = Converter.convertStringToInteger(numberText);

        //then
        assertEquals(10, result);
    }

    @Test
    public void whenConvertTextStringToIntThenThrowIncorrectArgumentException() {
        //given
        String text = "abc";

        //when
        try {
            Converter.convertStringToInteger(text);
            //then
            fail();
        } catch(IncorrectArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenConvertNegativeStringToIntThenReturnNegativeInt() throws IncorrectArgumentException {
        //given
        String negativeNumText = "-303";

        //when
        int result = Converter.convertStringToInteger(negativeNumText);

        //then
        assertEquals(-303, result);
    }

    @Test
    public void whenNumberStringStartsWithZeroThenThrowIncorrectArgumentException() {
        //given
        String incorrectNum = "003";

        //when
        try {
            Converter.convertStringToInteger(incorrectNum);
            //then
            fail();
        } catch (IncorrectArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenNumberStringStartsWithZeroAndHasTrailingSpaceThenThrowIncorrectArgumentException() {
        //given
        String incorrectNum = " 003";

        //when
        try {
            Converter.convertStringToInteger(incorrectNum);
            //then
            fail();
        } catch (IncorrectArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenConvertNegativeStringWithTrailingSpaceToIntThenReturnNegativeInt() throws IncorrectArgumentException {
        //given
        String negativeNumText = " -303";

        //when
        int result = Converter.convertStringToInteger(negativeNumText);

        //then
        assertEquals(-303, result);
    }

    @Test
    public void whenMinValueStringThenReturnInt() throws IncorrectArgumentException {
        //given
        String minValue = " -32768";

        //when
        int result = Converter.convertStringToInteger(minValue);

        //then
        assertEquals(-32768, result);
    }

    @Test
    public void whenMaxValueStringThenReturnInt() throws IncorrectArgumentException {
        //given
        String maxValue = "32767";

        //when
        int result = Converter.convertStringToInteger(maxValue);

        //then
        assertEquals(32767, result);
    }

    @Test
    public void whenMoreThanMaxValueStringThenThrowIncorrectArgumentException() {
        //given
        String numString = "32768";

        //when
        try {
            Converter.convertStringToInteger(numString);
            //then
            fail();

        } catch (IncorrectArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenLessThanMinValueStringThenThrowIncorrectArgumentException() {
        //given
        String numString = "-32769";

        //when
        try {
            Converter.convertStringToInteger(numString);
            //then
            fail();

        } catch (IncorrectArgumentException e) {
            e.printStackTrace();
        }
    }
}