/*Write an algorithm such that if an element in an M*N matrix is 0, its 
entire row and column are set to 0*/
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
}