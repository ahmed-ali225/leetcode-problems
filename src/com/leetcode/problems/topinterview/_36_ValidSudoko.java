package com.leetcode.problems.topinterview;

import java.util.HashSet;
import java.util.Set;

public class _36_ValidSudoko {

  public static void main(String[] args) {
    System.out.println(isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}}));
  }

//  public static boolean isValidSudoku(char[][] board) {
//    Set seen = new HashSet();
//    for (int i=0; i<9; ++i) {
//      for (int j=0; j<9; ++j) {
//        char number = board[i][j];
//        if (number != '.')
//          if (!seen.add(number + " in row " + i) ||
//              !seen.add(number + " in column " + j) ||
//              !seen.add(number + " in block " + i/3 + "-" + j/3))
//            return false;
//      }
//    }
//    return true;
//  }

  public static boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      Set row = new HashSet();
      Set col = new HashSet();
      Set box = new HashSet();

      for (int j = 0; j < 9; j++) {
        char _row = board[i][j];
        char _col = board[j][i];
        char _box = board[(int) (3*Math.floor(i/3)+Math.floor(j/3))][3*(i%3)+(j%3)];

        if (_row != '.') {
          if (!row.add(_row)) return false;
        }
        if (_col != '.') {
          if (!col.add(_col)) return false;
        }

        if (_box != '.') {
          if (!box.add(_box)) return false;
        }
      }
    }
    return true;
  }

//  public static boolean isValidSudoku(char[][] board) {
//    int [] vset = new int [9];
//    int [] hset = new int [9];
//    int [] bckt = new int [9];
//    int idx = 0;
//    for (int i = 0; i < 9; i++) {
//      for (int j = 0; j < 9; j++) {
//        if (board[i][j] != '.') {
//          idx = 1 << (board[i][j] - '0') ;
//          if ((hset[i] & idx) > 0 ||
//              (vset[j] & idx) > 0 ||
//              (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
//          hset[i] |= idx;
//          vset[j] |= idx;
//          bckt[(i / 3) * 3 + j / 3] |= idx;
//        }
//      }
//    }
//    return true;
//  }

}
