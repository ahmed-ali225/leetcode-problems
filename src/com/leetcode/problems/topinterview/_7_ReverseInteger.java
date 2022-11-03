package com.leetcode.problems.topinterview;

public class _7_ReverseInteger {


  public static void main(String[] args) {
    System.out.println(reverse(123)); //321
    System.out.println(reverse(-123)); //-321
    System.out.println(reverse(120)); //21
  }

  public static int reverse(int x) {
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
    if (stringBuilder.charAt(0) == '-') {

      stringBuilder.deleteCharAt(0);
      stringBuilder.append("-");
    }

    stringBuilder.reverse();
    Integer result = Integer.valueOf(stringBuilder.toString());
    return result < MIN || result > MAX ? 0 : result;
  }

  private static final double MIN = Math.pow(-2, 31);
  private static final double MAX = Math.pow(2, 31) - 1;
}
