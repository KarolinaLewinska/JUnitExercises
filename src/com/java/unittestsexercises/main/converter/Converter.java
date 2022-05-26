package com.java.unittestsexercises.main.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {
    public static int convertStringToInteger(String numString) throws IncorrectArgumentException {
        if (isStringValid(numString)) {
            int convertedNumber = Integer.parseInt(numString.trim());
            if (isIntegerInRange(convertedNumber)) {
                return convertedNumber;
            } else {
                throw new IncorrectArgumentException();
            }
        }
        throw new IncorrectArgumentException();
    }

    private static boolean isStringValid(String numString) {
        return checkIfStringHasAllowedCharacters(numString);
    }

    private static boolean checkIfStringHasAllowedCharacters(String numString) {
        Matcher matcher = Pattern.compile(" ?-?[1-9][0-9]+").matcher(numString);
        return matcher.find();
    }

    private static boolean isIntegerInRange(int num) {
        final int MIN_VALUE = -32768;
        final int MAX_VALUE = 32767;
        return num >= MIN_VALUE && num <= MAX_VALUE;
    }
}