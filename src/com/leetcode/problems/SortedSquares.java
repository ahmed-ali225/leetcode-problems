package com.leetcode.problems;

import java.util.Arrays;

public class SortedSquares {

  public static void main(String[] args) {
    Arrays.stream(sortedSquares(new int[] {-4, -1, 0, 3, 10})).boxed().forEach(System.out::print);
    System.out.println();
  }

  public static int[] sortedSquares(int[] nums) {

    int[] sortedSq = new int[nums.length];
    int high = nums.length - 1, low = 0, mid = 0;

    while (low < high) {
      mid = low + (high - low) / 2;

      if (nums[mid] == 0) {
        high = mid;
        low = mid;
      } else if (nums[mid] > 0) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    low -= 1;
    int counter = 0;

    while ((low >= 0 && high < nums.length) || counter < nums.length) {
      if (low >= 0 && nums[low] * nums[low] < nums[high] * nums[high]) {
        sortedSq[counter] = nums[low] * nums[low];
        low--;
      } else {
        sortedSq[counter] = nums[high] * nums[high];
        high++;
      }
      counter++;
    }

    return sortedSq;
  }
}
