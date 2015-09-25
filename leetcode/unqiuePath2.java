/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0)  return 0;
        int[][] record=new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean[][] flag=new boolean[obstacleGrid.length][obstacleGrid[0].length];
        return recurse(obstacleGrid,0,0,record,flag);
    }
    
    private int recurse(int[][]obstacle,int x,int y,int[][]record,boolean[][]flag){
        int m=obstacle.length-1;
        int n=obstacle[0].length-1;
        if(obstacle[x][y]==1)   return 0;
        if(x==m&&y==n&&obstacle[x][y]==0)  return 1;
        if(x==m&&y==n&&obstacle[x][y]==1)  return 0;
        int moveX,moveY;
        moveX=moveY=0;
        //System.out.println("moveX="+moveX+"  moveY="+moveY);
       
        if(x+1<=m&&obstacle[x+1][y]==0){
            if(flag[x+1][y])
                moveX=record[x+1][y];
            else{
                moveX=recurse(obstacle,x+1,y,record,flag);
                flag[x+1][y]=true;
                record[x+1][y]=moveX;
            }
        }
        if(y+1<=n&&obstacle[x][y+1]==0){
            if(flag[x][y+1])
                moveY=record[x][y+1];
            else{
                moveY=recurse(obstacle,x,y+1,record,flag);
                flag[x][y+1]=true;
                record[x][y+1]=moveY;
            }
        }
        return moveX+moveY;
        
    }
}