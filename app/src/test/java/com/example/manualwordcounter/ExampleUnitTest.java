package com.example.manualwordcounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleUnitTest {

    @Test
    public void countWords_twoWords_returnsTwo() {
        TextCounter counter = new TextCounter();

        int result = counter.countWords("Hello World");

        assertEquals(2, result);
    }

    @Test
    public void countSentences_threeSentences_returnsThree() {
        TextCounter counter = new TextCounter();

        int result = counter.countSentences("Hello World. Nice to meet you. Bye.");

        assertEquals(3, result);
    }

    @Test
    public void countPunctuation_twoMarks_returnsTwo() {
        TextCounter counter = new TextCounter();

        int result = counter.countPunctuation("Hello World I'm here!");

        assertEquals(2, result);
    }

    @Test
    public void countNumbers_twoNumbers_returnsTwo() {
        TextCounter counter = new TextCounter();

        int result = counter.countNumbers("Hello World 1234 56789");

        assertEquals(2, result);
    }

    @Test
    public void countWords_emptyText_returnsZero() {
        TextCounter counter = new TextCounter();

        int result = counter.countWords("");

        assertEquals(0, result);
    }

    @Test
    public void countWords_extraSpaces_returnsTwo() {
        TextCounter counter = new TextCounter();

        int result = counter.countWords("   Hello    World   ");

        assertEquals(2, result);
    }

    @Test
    public void countSentences_repeatedEndMarks_returnsTwo() {
        TextCounter counter = new TextCounter();

        int result = counter.countSentences("Hello!!! World???");

        assertEquals(2, result);
    }

    @Test
    public void countPunctuation_noMarks_returnsZero() {
        TextCounter counter = new TextCounter();

        int result = counter.countPunctuation("Hello World");

        assertEquals(0, result);
    }

    @Test
    public void countNumbers_noDigits_returnsZero() {
        TextCounter counter = new TextCounter();

        int result = counter.countNumbers("Hello World");

        assertEquals(0, result);
    }
}