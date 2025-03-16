import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize board with '.'
        for (char[] row : board) Arrays.fill(row, '.');
        
        // HashSets to track column and diagonals
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> posD = new HashSet<>();
        HashSet<Integer> negD = new HashSet<>();
        
        backtrack(0, n, board, result, col, posD, negD);
        return result;
    }
    
    private void backtrack(int row, int n, char[][] board, List<List<String>> result,
                           HashSet<Integer> col, HashSet<Integer> posD, HashSet<Integer> negD) {
        // Base case: If all queens are placed, add board to result
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }
        
        // Try placing a queen in each column
        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posD.contains(row + c) || negD.contains(row - c)) continue;
            
            // Place queen
            board[row][c] = 'Q';
            col.add(c);
            posD.add(row + c);
            negD.add(row - c);
            
            // Recur for next row
            backtrack(row + 1, n, board, result, col, posD, negD);
            
            // Backtrack
            board[row][c] = '.';
            col.remove(c);
            posD.remove(row + c);
            negD.remove(row - c);
        }
    }
    
    private List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}
