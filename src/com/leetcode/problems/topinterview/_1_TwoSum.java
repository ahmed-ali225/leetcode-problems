package com.leetcode.problems.topinterview;

import com.leetcode.problems.AbstractTestClass;
import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum extends AbstractTestClass {

  public static void main(String[] args) {
    printArray(twoSum(new int[]{2,7,11,15}, 9)); //[0, 1]
    printArray(twoSum(new int[]{3,2,4}, 6)); //[1, 2]
    printArray(twoSum(new int[]{2, 5, 5, 11}, 10)); //[1, 2]
  }

  public static int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
      if (map.containsKey(target - numbers[i])) {
        result[1] = i;
        result[0] = map.get(target - numbers[i]);
        return result;
      }
      map.put(numbers[i], i);
    }
    return result;
  }
}
//  public static int[] twoSum(int[] nums, int target) {
//    int lp = 0, rp = 1;
//    for (int i=1; i <= nums.length; i++) {
//      if (nums[lp] + nums[rp] == target)
//        return new int[]{lp, rp};
//      else if (nums[lp] + nums[rp] < target)
//        rp++;
//      else
//        lp++;
//    }
//    return null;
//  }
//
//}

//for (int i=1; i < nums.length; i++) {
//    if (nums[i - 1] + nums[i] == target)
//    return new int[]{i - 1, i};
//    }
//    return null;

