package org.adamtungleetcode.slidingwindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aab")); //2
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf")); //3
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("ckilbkd")); //5
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("tmmzuxt")); //5
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("wobgrovw")); //6
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j;
        int longestLength = 0;
        int currLength;
        for (int k = 0; k < s.length(); k++) {
            char currChar = s.charAt(k);
            j = k;
            if (set.contains(currChar)) {
                int l;
                boolean isShift = false;
                for (l = i; l < k; l++) {
                    char charAtL = s.charAt(l);
                    if (charAtL == currChar) {
                        isShift = true;
                        break;
                    }
                }
                if (isShift) {
                    i = l + 1;
                }
            }
            set.add(currChar);
            currLength = j - i + 1;
            if (currLength > longestLength) {
                longestLength = currLength;
            }
        }
        return longestLength;
    }
}
