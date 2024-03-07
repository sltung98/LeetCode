package org.adamtungleetcode.arrayandhashing;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println(new ValidSudoku().isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}})
        );
        System.out.println(new ValidSudoku().isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}})
        );
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> currRowSet = new HashSet<>();
        HashSet<Character> currColSet = new HashSet<>();
        HashSet<Character>[][] subBoxSetArray = new HashSet[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subBoxSetArray[i][j] = new HashSet();
            }
        }
        char c;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                c = board[i][j];
                if (c >= 49 && c <= 57) {
                    if (currRowSet.contains(c) || findElementInSubBoxSetArray(subBoxSetArray,
                            getIndexForSubBoxSetArray(i), getIndexForSubBoxSetArray(j), c)) {
                        return false;
                    } else {
                        currRowSet.add(c);
                    }
                }

                c = board[j][i];
                if (c >= 49 && c <= 57) {
                    if (currColSet.contains(c)) {
                        return false;
                    } else {
                        currColSet.add(c);
                    }
                }
            }
            currRowSet.clear();
            currColSet.clear();
        }
        return true;
    }

    private boolean findElementInSubBoxSetArray(HashSet<Character>[][] subBoxSetArray, int rowIndex, int colIndex, Character element) {
        if (subBoxSetArray[rowIndex][colIndex].contains(element)) {
            //System.out.printf("try to add %c to sub box %d, %d but...\n", element, rowIndex, colIndex);
            //System.out.println("found in sub box");
            return true;
        } else {
            subBoxSetArray[rowIndex][colIndex].add(element);
            //System.out.printf("add %c to sub box %d, %d\n", element, rowIndex, colIndex);
            return false;
        }
    }

    private int getIndexForSubBoxSetArray(int i) {
        i = i - 3;
        if (i < 0) {
            return 0;
        } else if (i >= 3) {
            return 2;
        } else {
            return 1;
        }
    }
}
