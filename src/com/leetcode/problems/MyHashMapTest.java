package com.leetcode.problems;

public class MyHashMapTest {
  public static void main(String[] args) {
    //    MyHashMap myHashSet = new MyHashMap();
    //    myHashSet.put(1, 1); // set = [1]
    //    myHashSet.put(2, 2); // set = [1, 2]
    //    myHashSet.put(94, 5); // set = [1, 2]
    //    System.out.println(myHashSet.get(1)); // return 1
    //    System.out.println(myHashSet.get(94)); // return 5
    //    myHashSet.put(94, 74); // set = [1, 2]
    //    System.out.println(myHashSet.get(94)); // return 74
    //    System.out.println(myHashSet.get(23)); // return -1
    //    myHashSet.put(74, 85); // set = [1, 2]
    //    System.out.println(myHashSet.get(94)); // return 74
    //    System.out.println(myHashSet.get(74)); // return 85
  }
}

////// Solution 2///////////
// class MyHashMap {
//
//  private static final int MAX_CAPACITY = 1000;
//  List<Pair>[] map = new ArrayList[MAX_CAPACITY];
//
//  public MyHashMap() {}
//
//  public void put(int key, int value) {
//    int hash = key % MAX_CAPACITY;
//    Pair pair = new Pair(key, value);
//    if (map[hash] != null) {
//      int index = findPairByKey(map[hash], key);
//      if (index != -1) {
//        map[hash].remove(index);
//        map[hash].add(pair);
//      }
//    } else {
//      map[hash] = new ArrayList<>();
//      map[hash].add(pair);
//    }
//  }
//
//  public int get(int key) {
//    int hash = key % MAX_CAPACITY;
//
//    if (map[hash] != null) {
//      int index = findPairByKey(map[hash], key);
//      if (index != -1) {
//        return map[hash].get(index).value;
//      }
//    }
//    return -1;
//  }
//
//  public void remove(int key) {
//    int hash = key % MAX_CAPACITY;
//    if (map[hash] != null) {
//      int index = findPairByKey(map[hash], key);
//      if (index != -1) {
//        map[hash].remove(index);
//      }
//    }
//  }
//
//  private int findPairByKey(List<Pair> list, Integer key) {
//    Iterator<Pair> iterator = list.iterator();
//    while (iterator.hasNext()) {
//      Pair pair = iterator.next();
//      if (pair.key == key) {
//        return list.indexOf(pair);
//      }
//    }
//    return -1;
//  }
// }

class Pair {
  int key, value;

  public Pair(int key, int value) {
    this.key = key;
    this.value = value;
  }

  public int getKey() {
    return key;
  }

  public int getValue() {
    return value;
  }
}
/////////////// Solution 1////////////////////////
// class MyHashMap {
//  /** Initialize your data structure here. */
//  public MyHashMap() {
//    lists = new List[kSize];
//
//    for (int i = 0; i < kSize; ++i)
//      lists[i] = new ArrayList<>();
//  }
//
//  /** value will always be non-negative. */
//  public void put(int key, int value) {
//    for (int[] pair : lists[key % kSize])
//      if (pair[0] == key) {
//        pair[1] = value;
//        return;
//      }
//    lists[key % kSize].add(new int[] {key, value});
//  }
//
//  /**
//   * Returns the value to which the specified key is mapped, or -1 if this map
//   * contains no mapping for the key
//   */
//  public int get(int key) {
//    for (int[] pair : lists[key % kSize])
//      if (pair[0] == key)
//        return pair[1];
//    return -1;
//  }
//
//  /**
//   * Removes the mapping of the specified value key if this map contains a mapping
//   * for the key
//   */
//  public void remove(int key) {
//    for (int i = 0; i < lists[key % kSize].size(); ++i)
//      if (lists[key % kSize].get(i)[0] == key) {
//        lists[key % kSize].remove(i);
//        return;
//      }
//  }
//
//  private static final int kSize = 10000;
//  List<int[]>[] lists; // Each slot store (key, value) list
// }
