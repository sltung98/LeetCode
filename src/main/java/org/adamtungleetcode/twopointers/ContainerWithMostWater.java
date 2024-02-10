package org.adamtungleetcode.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(new ContainerWithMostWater().maxArea(new int[] {2,3,10,5,7,8,9}));
    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int j = i + 1;
            int heightI = height[i];
            int heightJ = height[j];
            int areaIJ = Math.min(heightI, heightJ) * (j - i);
            if (areaIJ > maxArea) {
                maxArea = areaIJ;
            }
        }
        return maxArea;
    }

}
