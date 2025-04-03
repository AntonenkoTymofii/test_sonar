package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final Main main = new Main();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testPrintMessage() {
        main.printMessage();
        assertEquals("Hello, World!" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testDisplayMessage() {
        main.displayMessage();
        assertEquals("Hello, World!" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testPrintAndDisplayMessageEquality() {
        outContent.reset();
        main.printMessage();
        String printResult = outContent.toString();

        outContent.reset();
        main.displayMessage();
        String displayResult = outContent.toString();

        assertEquals(printResult, displayResult);
    }

    @Test
    void testGetValueWithNull() {
        assertThrows(NullPointerException.class, () -> {
            main.getValue(null);
        });
    }

    @Test
    void testGetValueWithValidInput() {
        String input = "test";
        assertEquals(input, main.getValue(input));
    }

    @Test
    void testCalculate() {
        outContent.reset();
        main.calculate(5, 10);
        assertEquals("Result: 15" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testCalculateWithNegativeNumbers() {
        outContent.reset();
        main.calculate(-3, -7);
        assertEquals("Result: -10" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testUnusedMethod() {
        main.unusedMethod();
        assertEquals("", outContent.toString());
    }

    @Test
    void testMainMethod() {
        assertThrows(NullPointerException.class, () -> {
            Main.main(new String[]{});
        });
    }
}