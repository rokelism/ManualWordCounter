package com.example.manualwordcounter;

public class TextCounter {
    public int countNumbers(String text) {
        int count = 0;
        boolean insideNumber = false;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!insideNumber) {
                    insideNumber = true;
                    count++;
                }
            } else {
                insideNumber = false;
            }
        }
        return count;
    }
    public int countWords(String text) {
        int count = 0;
        boolean insideWord = false;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if (!insideWord) {
                    insideWord = true;
                    count++;
                }
            } else {
                insideWord = false;
            }
        }
        return count;
        }
    public int countSentences(String text) {
        int count = 0;
        String[] sentences = text.split("[.!?]+");

        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                count++;
            }
        }

        return count;
    }
    public int countPunctuation(String text) {
        int count = 0;

        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?' || c == ',' || c == ';' || c == ':' || c == '\'' || c == '"' || c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}' || c == '<' || c == '>' || c == '/') {
                count++;
            }
        }
        return count;
    }
}




