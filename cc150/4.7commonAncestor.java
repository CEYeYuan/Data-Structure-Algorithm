/*Design an algorithm and write code to find the first common ancestor of two
nodes in a binary tree. Avoid storing additional nodes in a data structure. 
Note:This is not necessarily a binary search tree*/
class TreeNode{
	int item;
	TreeNode leftChild;
	TreeNode rightChild;
	public TreeNode(int input){
		item=input;
	}
	static TreeNode commonAncestor(TreeNode root,TreeNode node1,TreeNode node2){
		if (node1==root ||node2==root)
			return null;
		while (true){
			if (isChild(root.leftChild,node1) && isChild(root.leftChild,node2))
				root=root.leftChild;
			else if (isChild(root.rightChild,node1) && isChild(root.rightChild,node2))
				root=root.rightChild;
			else
				return root;
		}
	}

	static boolean isChild(TreeNode root, TreeNode node){
		if (root==null)
			return false;
		if (root.leftChild==node || root.rightChild==node)
			return true;
		else
			return isChild(root.leftChild,node) || isChild(root.rightChild,node);
	}
}


class test{
	public static void main(String[] args){
		
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
		TreeNode result=TreeNode.commonAncestor(root,node3,node6);
		if (result==null)
			System.out.println("No common ancestor");
		else
			System.out.println(result.item);
		
		
	}
}