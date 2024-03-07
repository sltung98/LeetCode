package org.adamtungleetcode.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(new ContainerWithMostWater().maxArea(new int[] {2,3,10,5,7,8,9}));
        System.out.println(new ContainerWithMostWater().maxArea(new int[] {2,3,4,5,18,17,6}));
    }
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int heightAtLeft = height[left];
        int heightAtRight = height[right];
        int maxArea = (right - left) * Integer.min(heightAtLeft, heightAtRight);
        while (left < right) {
            //System.out.printf("left: %d, right: %d, heightAtLeft: %d, heightAtRight: %d\n", left, right, heightAtLeft, heightAtRight);
            int newArea;
            if (heightAtLeft < heightAtRight) {
                left++;
                heightAtLeft = height[left];
            } else {
                right--;
                heightAtRight = height[right];
            }
            newArea = (right - left) * Integer.min(heightAtLeft, heightAtRight);
            if (newArea >= maxArea) {
                maxArea = newArea;
            }
        }
        return maxArea;
    }

}
