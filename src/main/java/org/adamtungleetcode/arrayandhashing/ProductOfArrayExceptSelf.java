package org.adamtungleetcode.arrayandhashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] prefixProductsArray = new int[nums.length];
        int[] suffixProductsArray = new int[nums.length];
        int[] productsExceptSelfArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0) {
                prefixProductsArray[i] = nums[i] * prefixProductsArray[i - 1];
            } else {
                prefixProductsArray[i] = nums[i];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 1 < nums.length) {
                suffixProductsArray[i] = nums[i] * suffixProductsArray[i + 1];
            } else {
                suffixProductsArray[i] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int suffixProduct = 1;
            int prefixProduct = 1;
            if (i - 1 >= 0) {
                prefixProduct = prefixProductsArray[i - 1];
            }
            if (i + 1 < nums.length) {
                suffixProduct = suffixProductsArray[i + 1];
            }
            productsExceptSelfArray[i] = prefixProduct * suffixProduct;
        }
        return productsExceptSelfArray;
    }
}
