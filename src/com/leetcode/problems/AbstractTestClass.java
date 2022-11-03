package com.leetcode.problems;

public class AbstractTestClass {

  public static void printArray(int[] numbers) {
    System.out.print("Result: [");
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i]);
      if (i != numbers.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

}
