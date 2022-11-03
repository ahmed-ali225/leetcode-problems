package com.leetcode.problems.topinterview;

import com.leetcode.problems.AbstractTestClass;
import java.util.HashMap;

public class _3_SubStringNoRepetition extends AbstractTestClass {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
    System.out.println(lengthOfLongestSubstring("dvdf")); // 3
    System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
    System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
  }

  public static int lengthOfLongestSubstring(String s) {
    if (s.length()==0) return 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int max=0;
    for (int i=0, j=0; i<s.length(); ++i){
      if (map.containsKey(s.charAt(i))){
        j = Math.max(j,map.get(s.charAt(i))+1);
      }
      map.put(s.charAt(i),i);
      max = Math.max(max,i-j+1);
    }
    return max;
  }

//  public static int lengthOfLongestSubstring(String s) {
//    if (s == null || s.isEmpty())
//      return 0;
//
//    int lp = 0, rp=0, length = 0;
//    StringBuilder subString = new StringBuilder();
//
//    while (rp < s.length()) {
//      if (subString.indexOf(String.valueOf(s.charAt(rp))) == -1) {
//        subString.append(s.charAt(rp));
//        rp++;
//      } else {
//        subString.delete(0, subString.length());
//        lp++;
//        rp = lp + 1;
//        subString.append(s.charAt(lp));
//      }
//      length = Math.max(length, subString.length());
//    }
//    return length;
//  }
}
