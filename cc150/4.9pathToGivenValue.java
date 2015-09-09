/*You are given a binary tree in which each node contains a value. Design an 
algorithm to print all paths which sume to a given value. The path does not 
need to start or end at the root or a leaf, but it must go in a straight line 
down.
1. Need a recursive funtion findSum, which starts from the starting point to
current node, if sum==aim, then we call the print funciton. No matter whether 
we found sum==aim, we need to recurse until the leaf. (This approach include 
all the potential path that start at an particular level (Either end up with 
leaves or not doesn't matter, because in both case we already printed it up ))
2. Change the starting point, one level down

*/
import java.util.*;
class TreeNode{
 	int item;
 	TreeNode leftChild;
 	TreeNode rightChild;
 	static int level;
 	public TreeNode(int input){
 		item=input;
 	}

 	static void printAllPath(TreeNode root,int aim){
 		int height=getHeight(root);
 		getPath(root,height,aim);
 	}
 	static void getPath(TreeNode root,int height,int aim){
 		if (root==null || height==0)
 			return;
 		level=height;
 		int[] path=new int[height];
 		getSum(root,path,aim);
 		if (root.leftChild!=null)
 			getPath(root.leftChild,height-1,aim);
 		if(root.rightChild!=null)
 			getPath(root.rightChild,height-1,aim);
 	}
 	
 	static void getSum(TreeNode root,int[] path,int aim){
 		if (root==null || level==0)
 			return ;
 		path[level-1]=root.item;
 		level--;
 		if (isEqual(path,aim))
 			printPath(path,level);
 		getSum(root.leftChild,path,aim);
 		getSum(root.rightChild,path,aim);

 	}

 	static boolean isEqual(int[] input,int aim){
 		int length=input.length;
 		int sum=0;
 		for (int i=0;i<length;i++){
 			sum+=input[i];
 		}
 		if (sum==aim)
 			return true;
 		else
 			return false;
 	}

 	static void printPath(int[] input,int index){
 		int length=input.length;
 		for (int i=length-1;i>=index;i--){
 			System.out.print(input[i]+" ");
 		}
 		System.out.println();
 	}


 	static int getHeight(TreeNode node){
 		if (node == null)
 			return 0;
 		else
 			return Math.max(getHeight(node.leftChild),getHeight(node.rightChild))+1;
 	}
 }
 class test{
 	public static void main(String [] args){
 		TreeNode root=new TreeNode(0);
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
		TreeNode node8=new TreeNode(8);
		root.leftChild=node1;
		root.rightChild=node2;
		node1.leftChild=node3;
		node1.rightChild=node4;
		node4.rightChild=node5;
		node5.rightChild=node6;
		node2.leftChild=node7;
		node2.rightChild=node8;
		node7.leftChild=new TreeNode(0);

		TreeNode.printAllPath(root,9);
		
 	}
 }