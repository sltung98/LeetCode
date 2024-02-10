package org.adamtungleetcode.arrayandhashing;

import java.util.*;

public class TopKfrequentElements {
    public static void main(String[] args) {
        new TopKfrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int num : nums) {
            if (occurrenceMap.containsKey(num)) {
                occurrenceMap.put(num, occurrenceMap.get(num) + 1);
            } else {
                occurrenceMap.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> sortedEntryList = new ArrayList<>(occurrenceMap.entrySet());
        sortedEntryList.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue)
                .reversed());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedEntryList.get(i).getKey();
        }
        return result;
    }
}
