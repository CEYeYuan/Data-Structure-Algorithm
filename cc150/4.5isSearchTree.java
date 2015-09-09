/*Implement a function to check if a binary tree is a binary search tree*/
import java.util.*;
class TreeNode{
	int item;
	TreeNode leftChild;
	TreeNode rightChild;
	TreeNode(int input){
		item=input;
	}
}
class Tree{
	TreeNode root;
	Tree(int input){
		root =new TreeNode(input);
	}
	//do a preorder traversal and check if it's ordered
	static boolean isBST(TreeNode root){
		if (root==null)
			return true;
		else{
			ArrayList<Integer> list=new ArrayList<Integer>();
			treeToList(root,list);
			int size=list.size();
			int i=0;
			while (i<size-2){
				if (list.get(i+1)<list.get(i))
					return false;
				i++;
			}
			return true;
		}
	}

	static void treeToList(TreeNode node,ArrayList<Integer> list){
		if (node==null)
			return;
		if (node.leftChild!=null){
			treeToList(node.leftChild,list);
		}
		list.add(node.item);
		if (node.rightChild!=null){
			treeToList(node.rightChild,list);
		}
	}
}

class test{
	public static void main(String[] args){
		Tree tree=new Tree(1);
		tree.root.rightChild=new TreeNode(2);
		tree.root.rightChild.rightChild=new TreeNode(3);
		//tree.root.rightChild.leftChild=new TreeNode(0);
		tree.root.rightChild.rightChild.rightChild=new TreeNode(4);
		if (Tree.isBST(tree.root))
			System.out.println("I'm a BST");
		else
			System.out.println("I'm not a BST");

	}
}