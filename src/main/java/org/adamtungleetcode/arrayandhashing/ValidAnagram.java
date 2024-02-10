package org.adamtungleetcode.arrayandhashing;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("adam", "mada"));
        System.out.println(new ValidAnagram().isAnagram2("adam", "mada"));
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> occurrenceMap1 = new HashMap<>();
        HashMap<Character, Integer> occurrenceMap2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            processChar(s.charAt(i), occurrenceMap1);
            processChar(t.charAt(i), occurrenceMap2);
        }

        if (occurrenceMap1.equals(occurrenceMap2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (sortString(s).equals(sortString(t))) {
            return true;
        } else {
            return false;
        }
    }

    private void processChar(char c, HashMap<Character, Integer> map) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
