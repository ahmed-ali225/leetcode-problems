package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class MyHashSetTest {
  public static void main(String[] args) {
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(1); // set = [1]
    myHashSet.add(2); // set = [1, 2]
    System.out.println(myHashSet.contains(1)); // return True
    System.out.println(myHashSet.contains(3)); // return False, (not found)
    myHashSet.add(2); // set = [1, 2]
    System.out.println(myHashSet.contains(2)); // return True
    myHashSet.remove(2); // set = [1]
    System.out.println(myHashSet.contains(2)); // return False, (already removed)
  }
}

class MyHashSet {

  private static final int MAX_CAPACITY = 1000;
  List<Integer>[] set = new ArrayList[MAX_CAPACITY];

  public MyHashSet() {}

  public void add(int key) {
    int hash = key % MAX_CAPACITY;
    if (set[hash] != null) {
      if (!set[hash].contains(key)) {
        set[hash].add(key);
      }
    } else {
      set[hash] = new ArrayList<>();
      set[hash].add(key);
    }
  }

  public void remove(int key) {
    int hash = key % MAX_CAPACITY;
    if (set[hash] != null && set[hash].contains(key)) {
      set[hash].remove(set[hash].indexOf(key));
    }
  }

  public boolean contains(int key) {
    int hash = key % MAX_CAPACITY;
    if (set[hash] != null) {
      return set[hash].contains(key);
    }

    return false;
  }
}
