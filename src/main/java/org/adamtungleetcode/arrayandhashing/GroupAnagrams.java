package org.adamtungleetcode.arrayandhashing;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strToAnagramsMap = new HashMap<>();
        for (String str : strs) {
            String sortedStr = sortString(str);
            if (strToAnagramsMap.containsKey(sortedStr)) {
                strToAnagramsMap.get(sortedStr).add(str);
            } else {
                strToAnagramsMap.put(sortedStr, new ArrayList<>(Arrays.asList(str)));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : strToAnagramsMap.values()) {
            result.add(list);
        }
        return result;
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
