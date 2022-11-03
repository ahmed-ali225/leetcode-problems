package com.leetcode.problems.topinterview;

public class _4_MedianTwoArrays {

  public static void main(String[] args) {

    // TODO watch https://www.youtube.com/watch?v=LPFhl65R7ww&t=248s
    System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

    double sum = 0;
    for (int i = 0; i < nums1.length; i++) {
      sum += nums1[i];
    }

    for (int i = 0; i < nums2.length; i++) {
      sum += nums2[i];
    }

    Double median = sum / (nums1.length + nums2.length);

    return median;
  }

}
