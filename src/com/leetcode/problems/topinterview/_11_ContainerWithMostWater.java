package com.leetcode.problems.topinterview;

public class _11_ContainerWithMostWater {

  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
    System.out.println(maxArea(new int[]{1,2,1})); // 2
  }

  public static int maxArea(int[] height) {

    if (height.length < 1)
      return height[0];

    int maxArea = 0, maxWidth = 0, currentHeight = 0, left = 0, right = height.length - 1;
    while (left < right) {
//      if (right - left > maxWidth) {
        maxWidth = right - left;
        currentHeight = Math.min(height[left], height[right]);
        maxArea = Math.max(maxArea, currentHeight * maxWidth);
//      }

      if(height[left] < height[right]) left++;
      else if(height[left] > height[right]) right--;
      else {
        left++;
        right--;
      }
    }

    return maxArea;
  }
}
