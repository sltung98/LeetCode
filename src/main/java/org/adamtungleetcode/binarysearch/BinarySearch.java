package org.adamtungleetcode.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {
    public static void main(String[] args) {
        //System.out.println(new BinarySearch().search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(new BinarySearch().search(new int[]{2, 5}, 5));

    }
    public int search(int[] nums, int target) {
        int middleIndex;
        int left = 0;
        int right = nums.length - 1;
        do {
            middleIndex = (left + right) / 2;
            int middleElement = nums[middleIndex];
            if (target > middleElement) {
                left = middleIndex + 1;
            } else if (target < middleElement) {
                right = middleIndex - 1;
            } else {
                return middleIndex;
            }
        } while (left <= right);
        return -1;
    }
}
