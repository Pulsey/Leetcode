class Solution {
    int ROWS, COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(dfs(board, word, i, j, 0))
                return true;
            }
        }   
        return false; 
    }
    public boolean dfs(char[][] board, String word, int row, int col, int start){
        if( start == word.length()) return true;

        if( row >= ROWS || col >= COLS || row < 0 || col < 0 || board[row][col] != word.charAt(start) || board[row][col] == '#'){
            return false;
        }
        board[row][col] = '#';
        boolean res = dfs(board, word, row+1, col, start+1) || dfs(board, word, row, col -1, start +1) || dfs(board, word, row -1, col, start + 1) || dfs(board, word, row, col + 1, start +1);
        board[row][col] = word.charAt(start);
        return res;
    }
}