package com.practicalunittesting.chp03;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitParamsRunner.class)
public class StringUtilTest {

    @Test(expected = IllegalArgumentException.class)
    public void reverseOnNullThrowsIAE() {
        assertThrows(IllegalArgumentException.class, ()->StringUtils.reverse(null));
    }

    @Test
    public void reversesEmptyStringToEmptyString(){
        assertEquals("", StringUtils.reverse(""));
    }

    private static Object[] reverseString() {
        return new Object[] {
                new Object[] {"a", "a"},
                new Object[] {"ab", "ba"},
                new Object[] {"aba", "aba"},
                new Object[] {"ds_42<^", "^<24_sd"},
                new Object[] {"a ", " a"},
                new Object[] {" 2", "2 "}
        };
    }

    @Test
    @Parameters(method = "reverseString")
    public void reversesAGivenString(String strToRevert, String expectedAfterReverse) {
        assertEquals(expectedAfterReverse, StringUtils.reverse(strToRevert));
    }

    @Test
    public void reversesCaseSensitive(){
        String inputString = "AbCd";
        String expectedString = "dCbA";

        assertEquals(expectedString, StringUtils.reverse(inputString));
    }
}