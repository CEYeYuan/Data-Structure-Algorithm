/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/
public class Solution {
    public void rotate(int[][] matrix) {
        recurse(matrix,0);
    }
    private void recurse(int [][]matrix, int layer){
        if(layer==matrix.length/2)  return;
        else{
            for(int i=0;i<matrix.length-layer*2-1;i++){
                int tmp=matrix[layer][layer+i];
                matrix[layer][layer+i]=matrix[matrix.length-1-layer-i][layer];
                matrix[matrix.length-1-layer-i][layer]=matrix[matrix.length-1-layer][matrix.length-1-layer-i];
                matrix[matrix.length-1-layer][matrix.length-1-layer-i]=matrix[layer+i][matrix.length-1-layer];
                matrix[layer+i][matrix.length-1-layer]=tmp;
            }   
        }
        recurse(matrix,layer+1);
    }
}