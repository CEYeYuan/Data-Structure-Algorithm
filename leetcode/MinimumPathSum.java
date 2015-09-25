/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0)  return 0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] total=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                total[i][j]=-1;
        }
        return recurse(grid,total,m-1,n-1);
    }
    
    private int recurse(int[][]grid,int[][]total,int x,int y){
        if(total[x][y]!=-1) return total[x][y];
        else if(x==0&&y==0){
            total[x][y]=grid[x][y];
        }
        else if(x==0){
            int tmp=recurse(grid,total,x,y-1);
            total[x][y]=tmp+grid[x][y];
        }
        else if(y==0){
            int tmp=recurse(grid,total,x-1,y);
            total[x][y]=tmp+grid[x][y];
        }
        else{
            int tmp1=recurse(grid,total,x-1,y);
            int tmp2=recurse(grid,total,x,y-1);
            total[x][y]=Math.min(tmp1,tmp2)+grid[x][y];
        }
        return total[x][y];
    }
}