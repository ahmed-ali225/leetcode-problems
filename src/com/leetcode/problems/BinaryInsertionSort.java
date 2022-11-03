package com.leetcode.problems;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BinaryInsertionSort {


  public static void main(String[] args) {
    Random rand = new Random();
    int[] numbers = new int[1000000];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(10000000);
    }


    System.out.println("Before:");
//    printArray(numbers);

    long start = System.nanoTime();
//    insertionSort(numbers, numbers.length);
    sort(numbers);
    long end = System.nanoTime();

    System.out.println("\nAfter:");
//    printArray(numbers);
    System.out.println("Time taken = " + (double)TimeUnit.NANOSECONDS.toMillis(end - start)/1000);
  }

  // Driver Code
  public static void sort(int array[]) //23.741
  {
    for (int i = 1; i < array.length; i++)
    {
      int x = array[i];

      // Find location to insert
      // using binary search
      int j = Math.abs(
          Arrays.binarySearch(array, 0,
              i, x) + 1);

      // Shifting array to one
      // location right
      System.arraycopy(array, j,
          array, j + 1, i - j);

      // Placing element at its
      // correct location
      array[j] = x;
    }
  }

  // A binary search based function
// to find the position
// where item should be inserted
// in a[low..high]
  static int binarySearch(int a[], int item,
      int low, int high)  //135.037
  {
    if (high <= low)
      return (item > a[low]) ?
          (low + 1) : low;

    int mid = (low + high) / 2;

    if (item == a[mid])
      return mid + 1;

    if (item > a[mid])
      return binarySearch(a, item,
          mid + 1, high);
    return binarySearch(a, item, low,
        mid - 1);
  }

  // Function to sort an array a[] of size 'n'
  static void insertionSort(int a[], int n)
  {
    int i, loc, j, k, selected;

    for (i = 1; i < n; ++i)
    {
      j = i - 1;
      selected = a[i];

      // find location where selected should be inseretd
      loc = binarySearch(a, selected, 0, j);

      // Move all elements after location to create space
      while (j >= loc)
      {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = selected;
    }
  }

  private static void printArray(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }

}
