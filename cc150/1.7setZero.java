/*Write an algorithm such that if an element in an M*N matrix is 0, its 
entire row and column are set to 0*/
/*potential improvement:O(1) space : use the first 0 elment's row/column 
  as the 1-dimensional array to store should-set-0 rows/columns; Don't forget
  to set that row/column to 0 in the end
*/
import java.util.*;
class setZero{
	public static void main (String[] args){
		int[][] input=new int [][]{
			{1,0,0,8},
			{1,2,5,9},
			{1,0,5,6}
		};
		int row=input.length;
		int column=input[0].length;

		for (int i=0;i<row;i++){
			for (int j=0;j<column;j++){
				System.out.print(input[i][j]+" ");
			}
			System.out.print("\n");
		}

		System.out.print("\n");
		ZeroLize(input);
		//ZerolizeInplace(input);
		for (int i=0;i<row;i++){
			for (int j=0;j<column;j++){
				System.out.print(input[i][j]+" ");
			}
			System.out.print("\n");
		}
	}

	public static int[][] ZeroLize(int[][] input){
		int row=input.length;
		int column=input[0].length;
		//#Potential bug: if there're many zeros inside the matrix, the int array 
		//may over flow; use a boolean array to flag each row/columns
		int [] rows=new int [row];
		int [] columns=new int [column];
		for (int i=0;i<row;i++)
			rows[i]=-1;
		for (int i=0;i<column;i++)
			columns[i]=-1;
		int flagR=0;
		int flagC=0;		

		
//search for all the 0 element, store there rows and columns
		for (int i=0;i<row;i++){
			for (int j=0;j<column;j++){
				if (input[i][j]==0){
					rows[flagR]=i;
					columns[flagC]=j;
					flagR++;
					flagC++;
				}
				
			}
		}

// set all the rows to be 0
		for (int i=0;i<row;i++){
			if (rows[i]!=-1){
				for(int j=0;j<column;j++){
					input[rows[i]][j]=0;
				}
			}
			else
				break;	
		}
//set all these columns to be 0
		for (int i=0;i<column;i++){
			if (columns[i]!=-1){
				for(int j=0;j<row;j++){
					input[j][columns[i]]=0;
				}
			}
			else
				break;	
		}

		return input;
	}


	public static int[][] ZerolizeInplace(int[][] input){
		int numOfRows=input.length;
		int numOfColumn=input[0].length;
		int [] flag=findFirstZero(input);
		if (flag[0]==-1)
			return input;
		else{
			//mark all the rows/columns should be set to zero
			for (int i=0;i<numOfRows;i++){
				for (int j=0;j<numOfColumn;j++){
					if (input[i][j]==0){
						input[i][flag[1]]=0;
						input[flag[0]][j]=0;
					}
				}
			}

			// set all the rows to be zero except the row restore the column info
			for (int i=0;i<numOfRows;i++){
				if (input[i][flag[1]]==0 &&i!=flag[0]){
					for (int j=0;j<numOfColumn;j++){
						input[i][j]=0;
					}
				}
			}

			//set all the columns to be zero
			for (int i=0;i<numOfColumn;i++){
				if (input[flag[0]][i]==0){
					for (int j=0;j<numOfRows;j++){
						input[j][i]=0;
					}
				}
			}

			// set the 'flag' row to be zero

			for (int i=0;i<numOfColumn;i++)
				input[flag[0]][i]=0;
			
		}
		return input;
		
	}


//how can we break a nested loop?? Use a function return instead !
	public static int[] findFirstZero(int[][]input){
		int numOfRows=input.length;
		int numOfColumn=input[0].length;
		int[] first=new int[]{-1,-1};
		for (int i=0;i<numOfRows;i++){
			for (int j=0;j<numOfColumn;j++){
				if (input[i][j]==0){
					first[0]=i;
					first[1]=j;
					return first;
				}
					
			}
		}

		return first;
	}
}