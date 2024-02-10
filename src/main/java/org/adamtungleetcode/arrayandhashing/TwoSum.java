package org.adamtungleetcode.arrayandhashing;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum2(new int[]{1, 3}, 4)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numToIndicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = nums[i];
            if (numToIndicesMap.containsKey(value)) {
                numToIndicesMap.get(value).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                numToIndicesMap.put(value, indices);
            }
        }
        numToIndicesMap.forEach((k, v) -> System.out.println(k + ": " + v));
        nums = Arrays.stream(nums).sorted().toArray();
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int left = nums[i];
            int right = nums[j];
            int sum = left + right;
            if (sum == target) {
                if (left == right) {
                    List<Integer> result = numToIndicesMap.get(left);
                    return new int[]{result.get(0), result.get(1)};
                } else {
                    return new int[]{numToIndicesMap.get(left).get(0), numToIndicesMap.get(right).get(0)};
                }

            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int difference = target - value;
            if (numToIndexMap.containsKey(difference)) {
                return new int[] {i, numToIndexMap.get(difference)};
            } else {
                numToIndexMap.put(value, i);
            }
        }
        return new int[]{0, 0};
    }


}
