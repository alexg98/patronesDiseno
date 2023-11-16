package com.algorithms;

import java.util.Arrays;

public class Anagram_Demo {
    static void checkStrings(String s1, String s2) {
        s1.replaceAll("\\s", "");
        s2.replaceAll("\\s", "");
        boolean result = true;
        if (s1.length() != s2.length()) {
            result = false;
        }
        else {
            char[] s1Ch = s1.toLowerCase().toCharArray();
            char[] s2Ch = s2.toLowerCase().toCharArray();
            Arrays.sort(s1Ch);
            Arrays.sort(s2Ch);
            result = Arrays.equals(s1Ch, s2Ch);
        }

        if (result) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        }
        else {
            System.out.println(s1 + " and " + s2 + " are NOT anagrams");
        }
    }

    public static void main(String[] args) {
        checkStrings("keep", "Peek");
        checkStrings("Night", "Thing");
    }
}
