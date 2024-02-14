package org.adamtungleetcode.arrayandhashing;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeAndDecode {
    public static void main(String[] args) {
        String cipher = new StringEncodeAndDecode().encode(List.of("neet", "code", "love", "you"));
        System.out.println(cipher);
        new StringEncodeAndDecode().decode(cipher).forEach(s -> System.out.print(s + " "));
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                char encodedChar = (char) (str.charAt(i) + 5);
                sb.append(encodedChar);
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                c = (char) (c - 5);
                sb.append(c);
            } else {
                strs.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return strs;
    }
}
