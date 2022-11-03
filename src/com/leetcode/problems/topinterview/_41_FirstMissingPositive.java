package com.leetcode.problems.topinterview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class _41_FirstMissingPositive {

  public static void main(String[] args) {
    System.out.println(firstMissingPositive(new int[]{1,2,0})); // 3
    System.out.println(firstMissingPositive(new int[]{3,4,-1,1})); // 2
    System.out.println(firstMissingPositive(new int[]{-5})); // 1
    System.out.println(firstMissingPositive(new int[]{1,2,3,4,5,6,7,8,9,20})); // 10
  }

  public static int firstMissingPositive(int[] nums) {
    Set<Integer> positiveSet = new TreeSet<>();

    for(int i = 0; i < nums.length; i++) {
      if (nums[i] > 0)
        positiveSet.add(nums[i]);
    }

    int missing = 1;

    if (positiveSet.size() == 0)
      return missing;

//    for (int i = 1; i <= positiveSet.size(); i++ ) {
//      if (!positiveSet.contains(i))
//        return i;
//    }
    Iterator<Integer> iterator = positiveSet.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().intValue() != missing)
        return missing;

      missing++;
    }

    return ((TreeSet<Integer>) positiveSet).last() + 1;
  }
}
