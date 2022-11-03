package com.leetcode.problems.zalando;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OCR {

  public static void main(String[] args) {
    System.out.println(solution("A2Le", "2pL1"));
//    System.out.println(solution("a10", "a10"));
//    System.out.println(solution("100dd", "d100d"));
//    System.out.println(solution("3x2x", "8")); // false
//    System.out.println(solution("3x2x", "7"));
//    System.out.println(solution("24a", "b24"));
//    System.out.println(solution("ba1", "1Ad")); // false
  }

  public static boolean solution(String S, String T) {
    int assumedLengthOfFirstString = determineAssumedLength(S);
    int assumedLengthOfSecondString = determineAssumedLength(T);

    if (assumedLengthOfFirstString != assumedLengthOfSecondString)
      return false;

    Map<Integer, String> firstString = mapStringPositions(S);
    Map<Integer, String> secondString = mapStringPositions(T);

    System.out.println(firstString);
    System.out.println(secondString);

    int firstPointer, secondPointer;

    int size = Math.max(firstString.size(), secondString.size());

    for (int i = 1; i <= size; i++) {
      if (firstString.get(i) != null && secondString.get(i) != null && (!firstString.get(i).equals("ANY") && !secondString.get(i).equals("ANY")) && !firstString.get(i).equals(secondString.get(i)))
        return false;
    }

    return true;
  }

  private static Map<Integer, String> mapStringPositions(String input) {
    Map<Integer, String> positionsMap = new LinkedHashMap<>();
    int currentPosition = 0;
    StringBuilder numericBuffer = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        numericBuffer.append(Character.getNumericValue(input.charAt(i)));

        if (i == input.length() - 1 && numericBuffer.length() > 0) {
          currentPosition += Integer.valueOf(numericBuffer.toString());
          positionsMap.put(currentPosition, "ANY");
        }
      }
      else if (Character.isLetter(input.charAt(i))) {
        if (numericBuffer.length() > 0) {
          currentPosition += Integer.valueOf(numericBuffer.toString());
          positionsMap.put(currentPosition, "ANY");
          numericBuffer.delete(0, numericBuffer.length());
        }
        currentPosition += 1;
        positionsMap.put(currentPosition, Character.toString(input.charAt(i)));
      }
    }

    return positionsMap;
  }

  private static int determineAssumedLength(String input) {
    int assumedLength = 0;
    StringBuilder numericBuffer = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        numericBuffer.append(Character.getNumericValue(input.charAt(i)));

        if (i == input.length() - 1 && numericBuffer.length() > 0)
          assumedLength += Integer.valueOf(numericBuffer.toString());
      }
      else if (Character.isLetter(input.charAt(i))) {
       assumedLength += numericBuffer.length() > 0 ? Integer.valueOf(numericBuffer.toString()) + 1 : 1;
       numericBuffer.delete(0, numericBuffer.length());
      }
    }
    return assumedLength;
  }

//  private static int determineAssumedLength(String input) {
//
//    return input.chars().mapToObj(value -> (char)value).map(character -> {
//      if (Character.isDigit(character))
//        return Character.getNumericValue(character);
//      return 1;
//    }).reduce((integer, integer2) -> integer + integer2).orElse(0);
//  }

}
