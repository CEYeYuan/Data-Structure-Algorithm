/*Write an algorithm to find the "next" node(i.e, in order successor) of a 
given node in a binary search tree. You may assume that each node has a link
to its parent.
### tree traversal
in-order traversal: left subtree -> current node -> right subtree

1.If this node has a right-subtree, we need to get the left-most node of the right subtree
2.If it does not has a right-subtree, we need look a level up, to find an unvisited parent 
  node (unvisited parent means it's a leftchild of a higher node; If we don't find one until
  root, we need return null)
*/
class TreeNode{
	int item;
	TreeNode parent;
	TreeNode leftChild;
	TreeNode rightChild;
	static int index;
	public TreeNode(int input){
		item=input;
	}
	public void setLeftChild(TreeNode node){
		leftChild=node;
		node.parent=this;
	}
	public void setRightChild(TreeNode node){
		rightChild=node;
		node.parent=this;
	}
	public static TreeNode findNext(TreeNode node){
		if (node.rightChild!=null){
			return findLeftMost(node.rightChild);
		}else{
			return findParent(node);
		}

	}
	//1st case
	public static TreeNode findLeftMost(TreeNode node){
		while(node.leftChild!=null){
			node=node.leftChild;
		}
		return node;
	}
	//2nd case
	public static TreeNode findParent(TreeNode node){

		while(node.parent.parent!=node.parent){
			if (node.parent==node.parent.parent.leftChild){
				return node.parent.parent;
			}
			node= node.parent;
		}
		return null;
	}
	
}
class Tree{
	TreeNode root;
	public Tree(int input){
		root=new TreeNode(input);
		root.parent=root;
	}
	public Tree(TreeNode input){
		root=input;
		root.parent=root;
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
		root.parent=root;
		root.setLeftChild(node1);
		root.setRightChild(node2);
		node1.setLeftChild(node3);
		node2.setRightChild(node4);
		node4.setRightChild(node5);
		node1.setLeftChild(node6);
		node1.setRightChild(node7);
		TreeNode next;
		next=TreeNode.findNext(node7);
		if(next==null){
			System.out.println("next is null !");
		}else{
			System.out.println("next is "+next.item);
		}
	}
}