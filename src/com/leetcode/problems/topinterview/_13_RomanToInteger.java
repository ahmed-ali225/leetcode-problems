package com.leetcode.problems.topinterview;

import java.util.HashMap;
import java.util.Map;

public class _13_RomanToInteger {

  public static void main(String[] args) {
    System.out.println(romanToInt("III")); // 3
    System.out.println(romanToInt("LVIII")); // 58
    System.out.println(romanToInt("MCMXCIV")); // 1994
  }

//  public static int romanToInt(String s) {
//    if (s == null || s.length() == 0)
//      return -1;
//    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//    map.put('I', 1);
//    map.put('V', 5);
//    map.put('X', 10);
//    map.put('L', 50);
//    map.put('C', 100);
//    map.put('D', 500);
//    map.put('M', 1000);
//
//    s = s.replace("IV", "IIII").replace("IX", "VIIII");
//    s = s.replace("XL", "XXXX").replace("XC", "LXXXX");
//    s = s.replace("CD", "CCCC").replace("CM", "DCCCC");
//
//    int sum = 0;
//    for (int i = 0; i < s.length(); i++) {
//        sum += map.get(s.charAt(i));
//    }
//    return sum;
//  }

  public static int romanToInt(String s) {
    if (s == null || s.length() == 0)
      return -1;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int len = s.length(), result = map.get(s.charAt(len - 1));
    for (int i = len - 2; i >= 0; i--) {
      if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
        result += map.get(s.charAt(i));
      else
        result -= map.get(s.charAt(i));
    }
    return result;
  }

//  Symbol       Value
//  I             1
//  V             5
//  X             10
//  L             50
//  C             100
//  D             500
//  M             1000
//
//  I can be placed before V (5) and X (10) to make 4 and 9.
//  X can be placed before L (50) and C (100) to make 40 and 90.
//  C can be placed before D (500) and M (1000) to make 400 and 900.
//  public static int romanToInt(String s) {
//    Map<String, Integer> symbols = new HashMap<>();
//    symbols.put("I", 1);
//    symbols.put("V", 5);
//    symbols.put("X", 10);
//    symbols.put("L", 50);
//    symbols.put("C", 100);
//    symbols.put("D", 500);
//    symbols.put("M", 1000);
//    symbols.put("IV", 4);
//    symbols.put("IX", 9);
//    symbols.put("XL", 40);
//    symbols.put("XC", 90);
//    symbols.put("CD", 400);
//    symbols.put("CM", 900);
//    Integer sum = 0, pointer = 0;
//
//    while (pointer < s.length()) {
//      String key = String.valueOf(s.charAt(pointer));
//      if (pointer + 1 < s.length() && (key.equals("I") || key.equals("X") || key.equals("C"))) {
//        if (symbols.get(s.substring(pointer, pointer + 2)) != null) {
//
//          sum += symbols.get(s.substring(pointer, pointer + 2));
//          pointer+=2;
//          continue;
//        }
//      }
//      sum += symbols.get(key);
//      pointer++;
//    }
//
//    return sum;
//  }
}
