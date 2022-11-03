package com.leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 3, 5, 9, 12};
    System.out.println(search(nums, 9));
    System.out.println(runBinarySearchRecursively(nums, 9, 0, nums.length));
    System.out.println(Arrays.binarySearch(nums, 9));
  }

  public static int runBinarySearchRecursively(int[] sortedArray, int key, int low, int high) {
    int middle = low + ((high - low) / 2);

    if (high < low) {
      return -1;
    }

    if (key == sortedArray[middle]) {
      return middle;
    } else if (key < sortedArray[middle]) {
      return runBinarySearchRecursively(sortedArray, key, low, middle - 1);
    } else {
      return runBinarySearchRecursively(sortedArray, key, middle + 1, high);
    }
  }

  public static int search(int[] nums, int target) {
    List<Integer> arrayList = Arrays.stream(nums).boxed().collect(Collectors.toList());
    return arrayList.stream()
        .filter(value -> value == target)
        .map(operand -> arrayList.indexOf(operand))
        .findFirst()
        .orElse(-1);
  }
}
