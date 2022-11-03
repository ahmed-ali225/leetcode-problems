package com.leetcode.problems.topinterview;

import java.math.BigInteger;

public class _2_AddTwoNumbers {

  public static void main(String[] args) {

    ListNode a1 = new ListNode(2, new ListNode(4, new ListNode(9)));
    ListNode b1 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
    ListNode a2 = new ListNode(9);
    ListNode b2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

    ListNode resultNode = addTwoNumbers(a1, b1);
    printResult(resultNode);

    resultNode = addTwoNumbers(a2, b2);
    printResult(resultNode);
  }

  private static void printResult(ListNode resultNode) {
    StringBuilder result = new StringBuilder();

    while (resultNode != null) {
      result.append(resultNode.val);
      resultNode = resultNode.next;
    }

    System.out.println(result);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode p, dummy = new ListNode(0);
    p = dummy;
    while (l1 != null || l2 != null || carry != 0) {
      if (l1 != null) {
        carry += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        carry += l2.val;
        l2 = l2.next;
      }
      p.next = new ListNode(carry%10);
      carry /= 10;
      p = p.next;
    }
    return dummy.next;
  }

//  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//    if (l1 == null || l2 == null)
//      return null;
//    StringBuilder firstNumber = new StringBuilder();
//    StringBuilder secondNumber = new StringBuilder();
//
//
//    while (l1 != null) {
//      firstNumber.append(l1.val);
//      l1 = l1.next;
//    }
//
//    while (l2 != null) {
//      secondNumber.append(l2.val);
//      l2 = l2.next;
//    }
//
//    String firstReversed = firstNumber.reverse().toString();
//    String secondReversed = secondNumber.reverse().toString();
//    System.out.println("l1: " + firstReversed);
//    System.out.println("L2: " + secondReversed);
//
//    BigInteger sum = new BigInteger(firstReversed).add(new BigInteger(secondReversed));
//
//    System.out.println("sum: " + sum);
//
//    if ( sum.compareTo(BigInteger.ZERO) == 0)
//      return new ListNode(0);
//
//    System.out.println("sum " + sum);
//    String sumString = String.valueOf(sum);
//
//    return createListNode(sumString.toString(), null, 0);
//  }
//
//  public static ListNode createListNode(String sum, ListNode nextNode, int index) {
//    if (index == sum.length())
//      return nextNode;
//
//    return createListNode(sum, new ListNode(Character.getNumericValue(sum.charAt(index)), nextNode), ++index);
//  }
}

class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
