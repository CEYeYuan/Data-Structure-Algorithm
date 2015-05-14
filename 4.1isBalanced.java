/*Implement a function to check if a binary tree is balanced. for the purpose
of this question, a balanced tree is defined to be a tree such that the heights
of the two subtrees of any node never differ by more than one.*/
class TreeNode{
	Object data;
	TreeNode leftChild;
	TreeNode rightChild;
	public TreeNode(Object input){
		data=input;
	}

	static boolean isBalanced(TreeNode node){
		boolean result;
		if(node==null){
			return true;
		}
		if (node.leftChild==null && node.rightChild==null)
			return true;
		if (node.leftChild==null){
			if (node.rightChild!=null && node.rightChild.leftChild==null 
				&& node.rightChild.rightChild==null)
				return true;
			else
				return false;
		}

		if (node.rightChild==null){

			if (node.leftChild!=null && node.leftChild.leftChild==null 
				&& node.leftChild.rightChild==null)
				return true;
			else
				return false;
		}
		else{
			return isBalanced(node.leftChild) && isBalanced (node.rightChild);
		}

	}

	static int Height (TreeNode node){
		int height;
		if (node==null){
			return 0;
		}
		else{
			height=max(Height(node.leftChild),Height(node.rightChild))+1;
		}
		return height;
	}

	static int max(int a,int b){
		if (a>=b){
			return a;
		}else{
			return b;
		}
	}

}
class Tree {
	TreeNode root;
	int height_lc=0;
	int height_rc=0;
	public Tree(Object input){
		root=new TreeNode(input);
	}


}