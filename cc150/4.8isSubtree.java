/*You have two very large trees: T1,with millions of nodes, and T2, with hundreds
 of nodes. Create an algorithm to decide if T2 is a subtree of T1. 
 A tree T2 is a subtree of T1 there exists a node n in T1 such that the subtree of n 
 is identical to T2. That is, if you cut off the tree at node n, the two trees would 
 be identical. */
 class TreeNode{
 	int item;
 	TreeNode leftChild;
 	TreeNode rightChild;
 	public TreeNode(int input){
 		item=input;
 	}
 	static boolean isSubtree(TreeNode large,TreeNode small){
 		if(small==null)
 			return true;
 		if (large==null)
 			return false;
 		if(large.item==small.item){
 			if(checkIdentical(large,small))
 				return true;
 		}
 		return isSubtree(large.leftChild,small)||isSubtree(large.rightChild,small);
 	}

 	static boolean checkIdentical(TreeNode large,TreeNode small){
 		if (small==null && large==null)
 			return true;
 		else if ((small==null && large!=null)||(large==null&&small!=null))
 			return false;
 		else if(small.item==large.item)
 			return checkIdentical(large.leftChild,small.leftChild)&&checkIdentical(large.rightChild,small.rightChild);
 		else
 			return false;

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

		TreeNode node22=new TreeNode(2);
		TreeNode node27=new TreeNode(7);
		TreeNode node28=new TreeNode(8);
		node22.leftChild=node27;
		node22.rightChild=node28;
		boolean result=TreeNode.isSubtree(root,node22);
		if (result)
			System.out.println("I'm the subtree of the first tree");
		else
			System.out.println("I'm not the subtree of the first tree");
 	}
 }