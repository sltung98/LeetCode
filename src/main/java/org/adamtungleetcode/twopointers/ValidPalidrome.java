package org.adamtungleetcode.twopointers;
public class ValidPalidrome {
    public static void main(String[] args) {
        System.out.println(new ValidPalidrome().isPalindrome("adssda"));
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!isAlphaNumeric(s.charAt(i)) && i < j) {
                i++;
            }
            while (!isAlphaNumeric(s.charAt(j)) && i < j) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}
