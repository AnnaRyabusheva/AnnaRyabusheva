package com.epam.tc.homework1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorSubtractTest extends CalculatorBaseTest {

    @Test
    public void calculatorSubTest() {

        long actual = calculator.sub(2, 2);
        assertEquals(actual, 0);
    }

    @Test
    public void calculatorSub2Test() {

        long actual = calculator.sub(6, 2);
        assertEquals(actual, 4);
    }
}
