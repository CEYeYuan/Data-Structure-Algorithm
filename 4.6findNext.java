/*Write an algorithm to find the "next" node(i.e, in order successor) of a 
given node in a binary search tree. You may assume that each node has a link
to its parent.

### tree traversal
in-order traversal: left subtree -> current node -> right subtree
*/
class TreeNode{
	int item;
	TreeNode leftChild;
	TreeNode rightChild;
	static int index;
	static TreeNode result;
	public TreeNode(int input){
		item=input;
	}
	public static TreeNode findNext(TreeNode root,TreeNode node){
		index=0;
		result=null;
		find(root,node);
		System.out.println(index);
		TreeNode result=findNode(root,index+1);
		return result;
	}

	static void find(TreeNode root, TreeNode node){
		if (root==null || node == null)
			return ;
		
		if (root.leftChild!=null){
			find(root.leftChild,node);
			index++;
		}
		if (root==node){
			return ;
		}
		if (root.rightChild!=null){
			find(root.rightChild,node);
			index++;
		}
	}

	static	TreeNode findNode(TreeNode root, int n){ 
		System.out.println(n);
		if (root.leftChild!=null){
			result=findNode(root.leftChild,n-1);
		}
		else if (n==0){
			return result ;
		}
		else if (root.rightChild!=null){
			result=findNode(root.rightChild,n-1);
		}
		
	}
}
class Tree{
	TreeNode root;
	public Tree(int input){
		root=new TreeNode(input);
	}
	public Tree(TreeNode input){
		root=input;
	}
}
class test{
	public static void main(String[] args){
		
		TreeNode root=new TreeNode(1);
		TreeNode node=new TreeNode(2);
		TreeNode next;
		Tree tree=new Tree(root);
		root.leftChild=node;
		root.leftChild.leftChild=new TreeNode(3);
		root.leftChild.rightChild=new TreeNode(4);
		next=TreeNode.findNext(root,node);
		if (next==null){
			System.out.println("next is null !");
		}else
			System.out.println(next.item);

	}
}