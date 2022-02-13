package com.epam.tc.homework1;

import static org.testng.Assert.assertEquals;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

public class CalculatorSumTest {

    @Test
    public void calculatorSumTest() {
        Calculator calculator = new Calculator();
        long actual = calculator.sum(2, 2);
        assertEquals(actual, 4);
    }

    @Test
    public void calculatorSum2Test() {
        Calculator calculator = new Calculator();
        long actual = calculator.sum(5, 2);
        assertEquals(actual, 7);
    }
}
