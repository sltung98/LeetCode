package org.adamtungleetcode.twopointers;

import java.util.Arrays;

public class TwoSumInputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
    }
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i + 1, j + 1};
    }
}
