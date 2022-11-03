package com.leetcode.problems;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InsertionSort {

  public static void main(String[] args) {
    Random rand = new Random();
    int[] numbers = new int[1000000]; //56.017

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(10000000);
    }

    System.out.println("Before:");
//    printArray(numbers);

    long start = System.nanoTime();
    insertionSort(numbers);
    long end = System.nanoTime();

    System.out.println("\nAfter:");
//    printArray(numbers);
    System.out.println("Time taken = " + (double) TimeUnit.NANOSECONDS.toMillis(end - start)/1000);
  }

  private static void insertionSort(int[] inputArray) {
    for (int i = 1; i < inputArray.length; i++) {

      int currentValue = inputArray[i];

      int j = i - 1;
      while (j >= 0 && inputArray[j] > currentValue) {
        inputArray[j + 1] = inputArray[j];
        j--;
      }
      inputArray[j + 1] = currentValue;
    }
  }

  private static void printArray(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }

}
