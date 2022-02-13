package com.epam.tc.homework1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorMultiplyTest extends CalculatorBaseTest {

    @Test
    public void calculatorMultiplyTest() {

        long actual = calculator.mult(2, 2);
        assertEquals(actual, 4);
    }
}
