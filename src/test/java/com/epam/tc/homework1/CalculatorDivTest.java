package com.epam.tc.homework1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.testng.annotations.Test;

public class CalculatorDivTest extends CalculatorBaseTest {

    @Test
    public void calculatorDivTest() {

        long actual = calculator.div(2, 2);
        assertEquals(actual, 1);
    }

    @Test
    void exceptionTesting() {
        assertThrows(NumberFormatException.class, () ->
            calculator.div(1, 0));
    }
}
