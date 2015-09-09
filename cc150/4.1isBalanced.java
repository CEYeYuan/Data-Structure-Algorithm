/*Implement a function to check if a binary tree is balanced. for the purpose
of this question, a balanced tree is defined to be a tree such that the heights
of the two subtrees of any node never differ by more than one.
The brute force recursion works, but it may check the same node over and 
over again.

We can use a more aggressive way, we implemented a method called check 
height, if it's a balanced node, we return it's height, else we directly 
return false


*/

class TreeNode{
	Object data;
	TreeNode leftChild;
	TreeNode rightChild;
	public TreeNode(Object input){
		data=input;
	}

	/*public static boolean isBalanced(TreeNode node){
		boolean result;
		if(node==null){
			return true;
		}

		else{
			result=Math.abs(Height(node.leftChild)-Height(node.rightChild))<=1;
			if (!result) 
				return false;
			return isBalanced(node.leftChild) && isBalanced (node.rightChild);
		}

	}

	public static int Height (TreeNode node){
		int height;
		if (node==null){
			return 0;
		}
		else{
			height=max(Height(node.leftChild),Height(node.rightChild))+1;
		}
		return height;
	}*/

	public static boolean isBalanced(TreeNode node){
		if (Height(node)==-1)
			return false;
		else 
			return true;

	}

	public static int Height(TreeNode node){
		if (node==null){
			return 0;
		}
		else if (Height(node.leftChild)==-1 || Height(node.rightChild)==-1){
			return -1;
		}
		else{
			int lh=Height(node.leftChild);
			int rh=Height(node.rightChild);
			if (Math.abs(lh-rh)>1)
				return -1;
			else
				return max(lh,rh)+1;
		} 
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

class test{
	public static void main(String[] args){
		Tree tree=new Tree(1);
		tree.root.leftChild=new TreeNode(2);
		tree.root.leftChild.rightChild=new TreeNode(2);
		tree.root.rightChild=new TreeNode(3);
		tree.root.rightChild.leftChild=new TreeNode(3);
		tree.root.rightChild.rightChild=new TreeNode(3);
		tree.root.rightChild.rightChild.rightChild=new TreeNode(3);
		tree.root.leftChild.leftChild=new TreeNode(2);
		tree.root.leftChild.leftChild.leftChild=new TreeNode(2);
		int height=TreeNode.Height(tree.root);
		System.out.println("The height of the tree is "+ height);
		if (TreeNode.isBalanced(tree.root))
			System.out.println("I'm balanced");
		else
			System.out.println("I'm not a balanced tree");
	}
}