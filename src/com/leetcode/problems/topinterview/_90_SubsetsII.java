package com.leetcode.problems.topinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_SubsetsII {

  public static void main(String[] args) {
    System.out.println(subsetsWithDup(new int[]{1,2,2})); //[[],[1],[1,2],[1,2,2],[2],[2,2]]
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  //  must not contain duplicate subsets
  private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
      if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
      tempList.add(nums[i]);
      backtrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}
