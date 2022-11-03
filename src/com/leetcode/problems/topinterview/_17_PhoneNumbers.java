package com.leetcode.problems.topinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class _17_PhoneNumbers {

  public static void main(String[] args) {

//    Input: digits = "23"
//    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//    System.out.println(letterCombinations("23"));
//    System.out.println(letterCombinations("2"));
    System.out.println(letterCombinations("234"));
  }

  static List<String> result=null;
  static String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

  public static List<String> letterCombinations(String digits) {
    result = new ArrayList<>();
    if(digits.length()==0) return result;
    dfs(0,digits,new StringBuilder());
    return result;
  }

  static void dfs(int length,String digits,StringBuilder temp){
    if(length == digits.length()){
      result.add(temp.toString());
      return;
    }

    //loop digit present at length index of digits string;
    char ch= digits.charAt(length);
    String str = mapping[ch-'0'];
    for(char c:str.toCharArray()){
      temp.append(c);
      dfs(length+1,digits,temp);
      temp.deleteCharAt(temp.length()-1);
    }
  }

//  public static List<String> letterCombinations(String digits) {
//    LinkedList<String> ans = new LinkedList<String>();
//    if(digits.isEmpty()) return ans;
//    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//    ans.add("");
//    for(int i =0; i<digits.length();i++){
//      int x = Character.getNumericValue(digits.charAt(i));
//      while(ans.peek().length()==i){
//        String t = ans.remove();
//        for(char s : mapping[x].toCharArray())
//          ans.add(t+s);
//      }
//    }
//    return ans;
//  }

//  public static List<String> letterCombinations(String digits) {
//
//    Map<Character, String> phoneNumbers = new HashMap<>();
//
//    phoneNumbers.put('2', "abc");
//    phoneNumbers.put('3', "def");
//    phoneNumbers.put('4', "ghi");
//    phoneNumbers.put('5', "jkl");
//    phoneNumbers.put('6', "mno");
//    phoneNumbers.put('7', "pqrs");
//    phoneNumbers.put('8', "tuv");
//    phoneNumbers.put('9', "wxyz");
//
//    List<String> stringList = new ArrayList<>();
//    for (int i = 0; i < digits.length(); i++) {
//      stringList.add(phoneNumbers.get(digits.charAt(i)));
//    }
//
//    Integer size = stringList.stream().map(s -> s.length()).reduce((o, o2) -> o * o2).orElse(0);
//
//    List<String> result = new ArrayList<>();
//
//    int lp = -1, rp = 0, digit = 0;
//    for (int i = 0; i < size; i++) {
//
//      if (stringList.size() > 1)
//        rp = i % stringList.get(digit + 1).length();
//
//      if (rp == 0)
//        lp++;
//
//      String value = String.valueOf(stringList.get(digit).charAt(lp));
//
//      if (stringList.size() > 1)
//        value+=String.valueOf(stringList.get(digit + 1).charAt(rp));
//
//      result.add(value);
//
//      if (lp == stringList.get(digit).length() - 1 ) {
//        lp = 0;
//        digit++;
//      }
//    }
//
//    return result;
//  }
}
