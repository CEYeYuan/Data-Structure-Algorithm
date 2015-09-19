/*

###
For recursion call, if there's one visited array, all the intermediate loop will
point to the same array, even if one step is wrong then we backtrack, the visited 
array is already changed. which can cause potential bugs.
###

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null&&word==null) return true;
        else if(board==null||word==null)    return false;
        else if(word.length()==0) return true;
        int row=board.length;
        int col=board[0].length;
       for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                
                if(word.charAt(0)==board[i][j]){
                     boolean[][]visited=new boolean[row][col];
                     for(int p=0;p<row;p++){
                        for(int q=0;q<col;q++){
                            visited[p][q]=false;
                        }
                     }
                     if(DFS(board,i,j,word,visited))
                        return true;
                }
                    
            }
       }
       return false;
        
       
    }
    private boolean DFS(char[][]board,int i,int j,String word,boolean[][]visited){
        if(word.length()==0||word==""||word==null)  return true;
        int row=board.length;
        int col=board[0].length;
        if(i<0||i>=row||j<0||j>=col)  return false;
        if(board[i][j]!=word.charAt(0))   return false;
        if(visited[i][j])   return false;
        visited[i][j]=true;
         boolean[][] cp1=new boolean[row][col];
         boolean[][] cp2=new boolean[row][col];
         boolean[][] cp3=new boolean[row][col];
         boolean[][] cp4=new boolean[row][col];
         for(int p=0;p<row;p++){
                        for(int q=0;q<col;q++){
                            cp1[p][q]= cp2[p][q]= cp3[p][q]= cp4[p][q]= visited[p][q];
                        }
                     }
        word=word.substring(1);
        return DFS(board,i,j-1,word,cp1)||DFS(board,i,j+1,word,cp2)||DFS(board,i-1,j,word,cp3)||DFS(board,i+1,j,word,cp4);
    
    }
}