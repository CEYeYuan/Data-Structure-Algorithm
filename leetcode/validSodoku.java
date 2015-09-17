/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null) return true;
        int[] counterRow;
        int[] counterCol;
        int[] counterBox;
        for(int i=0;i<9;i++){
            counterRow=new int[9];
            counterCol=new int[9];
            counterBox=new int[9];
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'&&board[j][i]=='.')
                    continue;
                else{
                    if(board[i][j]!='.'){
                        counterRow[board[i][j]-'1']++;
                        if(counterRow[board[i][j]-'1']>1)
                            return false;
                    }
                     if(board[j][i]!='.'){
                        counterCol[board[j][i]-'1']++;
                        if(counterCol[board[j][i]-'1']>1)
                            return false;
                    }
                }
                    
            }
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    if(board[(i/3)*3+j][(i%3)*3+k]=='.')    continue;
                    else{
                        counterBox[board[(i/3)*3+j][(i%3)*3+k]-'1']++;
                        if( counterBox[board[(i/3)*3+j][(i%3)*3+k]-'1']>1)
                            return false;
                    }
                }
            }
            
        }
        return true;
    }
}