/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/
public class Solution {
    public int uniquePaths(int m, int n) {
       
        int [][] res=new int[m+1][n+1];
        boolean[][] calculated=new boolean[m+1][n+1];
        return find(m,n,res,calculated);
       
    }
    private int find(int m,int n,int[][]res,boolean[][]calculated){
         if(m==1||n==1)  return 1;
        int moveM=calculated[m-1][n]?res[m-1][n]:find(m-1,n,res,calculated);
        int moveN=calculated[m][n-1]?res[m][n-1]:find(m,n-1,res,calculated);
        res[m-1][n]=moveM;
        res[m][n-1]=moveN;
        calculated[m-1][n]=calculated[m][n-1]=true;
        return moveM+moveN;
    }
}