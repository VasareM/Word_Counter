package com.example.wordcounter;

import org.junit.Test;

import static org.junit.Assert.*;

import NewClass.CounterClass;

public class CounterUnitTest {
    // chars tests
    @Test
    public void testGetCharsCount_normalText() {
        String given = "Hello";
        int actual = CounterClass.getCharsCount(given);
        int expected = 5;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetCharsCount_emptyBox() {
        String given = "";
        int actual = CounterClass.getCharsCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetCharsCount_sentenceWithChars() {
        String given = "Hello world! Welcome to 2025.";
        int actual = CounterClass.getCharsCount(given);
        int expected = 29;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetCharsCount_onlyNumbers() {
        String given = "123,5 0.8";
        int actual = CounterClass.getCharsCount(given);
        int expected = 9;
        assertEquals(expected, actual);
    }
    @Test(expected = NullPointerException.class)
    public void testGetCharsCount_null() {
        String given = null;
        int actual = CounterClass.getCharsCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetCharsCount_spaceSymbol() {
        String given = " ";
        int actual = CounterClass.getCharsCount(given);
        int expected = 1;
        assertEquals(expected, actual);
    }

    // numbers tests
    @Test
    public void testGetNumbersCount_normalText() {
        String given = "Hello";
        int actual = CounterClass.getNumbersCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetNumbersCount_emptyBox() {
        String given = "";
        int actual = CounterClass.getNumbersCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetNumbersCount_sentenceWithChars() {
        String given = "Hello world! Welcome to 2025.";
        int actual = CounterClass.getNumbersCount(given);
        int expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetNumbersCount_onlyNumbers() {
        String given = "123,5 0.8";
        int actual = CounterClass.getNumbersCount(given);
        int expected = 4;
        assertEquals(expected, actual);
    }
    public void testGetNumbersCount_sentenceWithNumbers() {
        String given = "Hello 1 world! Welcome to 2025. 897954685,75798.8975 87965 46 0 5";
        int actual = CounterClass.getNumbersCount(given);
        int expected = 9;
        assertEquals(expected, actual);
    }
    @Test(expected = NullPointerException.class)
    public void testGetNumbersCount_null() {
        String given = null;
        int actual = CounterClass.getNumbersCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetNumbersCount_spaceSymbol() {
        String given = " ";
        int actual = CounterClass.getNumbersCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }

    // words tests
    @Test
    public void testGetWordsCount_normalText() {
        String given = "Hello";
        int actual = CounterClass.getWordsCount(given);
        int expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetWordsCount_emptyBox() {
        String given = "";
        int actual = CounterClass.getWordsCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetWordsCount_sentenceWithChars() {
        String given = "Hello world! Welcome to 2025.";
        int actual = CounterClass.getWordsCount(given);
        int expected = 5;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetWordsCount_sentenceWithWords() {
        String given = "Hello world! Welcome to 2025. there,are words ,words.words word";
        int actual = CounterClass.getWordsCount(given);
        int expected = 11;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetWordsCount_onlyNumbers() {
        String given = "123,5 0.8";
        int actual = CounterClass.getWordsCount(given);
        int expected = 4;
        assertEquals(expected, actual);
    }
    @Test(expected = NullPointerException.class)
    public void testGetWordsCount_null() {
        String given = null;
        int actual = CounterClass.getWordsCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetWordsCount_spaceSymbol() {
        String given = " ";
        int actual = CounterClass.getWordsCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }

    // sentences tests
    @Test
    public void testGetSentencesCount_normalText() {
        String given = "Hello";
        int actual = CounterClass.getSentencesCount(given);
        int expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetSentencesCount_emptyBox() {
        String given = "";
        int actual = CounterClass.getSentencesCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetSentencesCount_sentenceWithChars() {
        String given = "Hello world! Welcome to 2025.";
        int actual = CounterClass.getSentencesCount(given);
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetSentencesCount_sentenceWithDifferentEndings() {
        String given = "Hello world! Welcome to 2025. What is this? this";
        int actual = CounterClass.getSentencesCount(given);
        int expected = 4;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetSentencesCount_sentenceWithManyCharacters() {
        String given = "Hello world! Welcome to 2025. this is a sentence, it is 1.now_another_sentence .. cat";
        int actual = CounterClass.getSentencesCount(given);
        int expected = 5;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetSentencesCount_onlyNumbers() {
        String given = "123,5 0.8";
        int actual = CounterClass.getSentencesCount(given);
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test(expected = NullPointerException.class)
    public void testGetSentencesCount_null() {
        String given = null;
        int actual = CounterClass.getSentencesCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetSentencesCount_spaceSymbol() {
        String given = " ";
        int actual = CounterClass.getSentencesCount(given);
        int expected = 0;
        assertEquals(expected, actual);
    }

}