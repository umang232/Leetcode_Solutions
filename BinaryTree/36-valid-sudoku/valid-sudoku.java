class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> hs;
        for(int i=0;i<board.length;i++){
            hs = new HashSet<>();
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] != '.' && hs.contains(board[i][j])){
                    return false;
                }else{
                    if(board[i][j] != '.'){
                        hs.add(board[i][j]);
                    }
                }
            }
        }
        for(int j=0;j<board.length;j++){
            hs = new HashSet<>();
            for(int i=0;i<board[j].length;i++){
                if(board[i][j] != '.' && hs.contains(board[i][j])){
                    return false;
                }else{
                    if(board[i][j] != '.'){
                        hs.add(board[i][j]);
                    }
                }
            }
        }
        for(int i = 0;i<=2;i++){
            for(int j =0;j<=2;j++){
                hs = new HashSet<>();
                for(int r=i*3;r<(i*3)+3;r++){
                    for(int c=j*3;c<(j*3)+3;c++){
                        if(board[r][c] != '.' && hs.contains(board[r][c])){
                    return false;
                }else{
                    if(board[r][c] != '.'){
                        hs.add(board[r][c]);
                    }
                }
                    }
                }
            }
        }
        return true;


    }
}