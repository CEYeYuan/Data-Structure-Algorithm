/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null)    return;
        boolean firstRow,firstCol;
        firstRow=firstCol=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                    if(i==0)    firstRow=true;
                    if(j==0)    firstCol=true;     
                }
            }
        }
        //set row
         for(int i=1;i<matrix.length;i++){
              if(matrix[i][0]==0){
                  for(int j=1;j<matrix[0].length;j++)
                     matrix[i][j]=0;
            }
        }
        //set col
        for(int j=1;j<matrix[0].length;j++){
             if(matrix[0][j]==0){
                  for(int i=1;i<matrix.length;i++)
                     matrix[i][j]=0;
             }
        }
        
        if(firstRow){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
        
        if(firstCol){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
      
        
    }
}