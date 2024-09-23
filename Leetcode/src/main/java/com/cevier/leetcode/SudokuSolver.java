package com.cevier.leetcode;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * <a href="https://leetcode.cn/problems/sudoku-solver/description/">解数独</a>
 */
public class SudokuSolver {

    BitSet[] rows = new BitSet[9];
    BitSet[] col = new BitSet[9];
    BitSet[][] squire = new BitSet[3][3];
    ArrayList<int[]> spaces = new ArrayList<>();
    boolean flag = Boolean.TRUE;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (rows[i] == null) rows[i] = new BitSet(9);
            for (int j = 0; j < board[i].length; j++) {
                if (col[j] == null) col[j] = new BitSet(9);
                if (squire[i / 3][j / 3] == null) squire[i / 3][j / 3] = new BitSet(9);
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '0' - 1;
                    rows[i].set(num);
                    col[j].set(num);
                    squire[i / 3][j / 3].set(num);
                }
            }
        }

        solve(0, board);

    }

    void solve(int index, char[][] board) {
        if (spaces.size() <= index) {
            flag = Boolean.FALSE;
            return;
        }

        int[] idx = spaces.get(index);
        int i = idx[0], j = idx[1];
        for (int k = 0; k < 9 && flag; k++) {
            if (!rows[i].get(k) && !col[j].get(k) && !squire[i / 3][j / 3].get(k)) {
                board[i][j] = (char) (k + 1 + '0');
                rows[i].set(k);
                col[j].set(k);
                squire[i / 3][j / 3].set(k);
                solve(index + 1, board);
                // 如果上面的解失败了，删除当前解，开始尝试下一个答案
                rows[i].clear(k);
                col[j].clear(k);
                squire[i / 3][j / 3].clear(k);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        new SudokuSolver().solveSudoku(board);
    }

}
