/*Given a binary tree, design an algorithm which creates a linked list of all
the nodes at each depth(e.g. if you have a tree with depth D,you'll have D 
linked lists). */
import java.util.*;
class TreeNode{
	int item;
	TreeNode leftChild;
	TreeNode rightChild;
	TreeNode(int input){
		item=input;
	}
	TreeNode(){}
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
class BinarySearchTree{
	TreeNode root;
	BinarySearchTree(int input){
		root=new TreeNode(input);
	}
	BinarySearchTree(TreeNode node){
		root=node;
	}

	static TreeNode arrToNode(int[] input, int start,int end){
		if (start>end)
			return null;
		else if (start==end){
			return new TreeNode(input[start]);
		}
		else{
			TreeNode root= new TreeNode(input[(start+end)/2]);
			root.leftChild=arrToNode(input,start,(start+end)/2-1);
			root.rightChild=arrToNode(input,(start+end)/2+1,end);
			return root;
		}

	}

	static BinarySearchTree arrToBST(int[] input,int start,int end){
		TreeNode node=arrToNode(input,start,end);
		BinarySearchTree tree = new BinarySearchTree(node);
		return tree;
	}

}
class Node{
	int item;
	Node next;
	
	static LinkedList<Level> queue ;
	static int level;
	static Node buffer;
	Node(int input){
		item=input;
	}
	Node(){}
	public void toStringPrint(){
		Node current=this;
		while(true){
			if(current!=null){
				System.out.print(current.item+" ");
				current=current.next;
			}
			else
				break;
		}
	}
	static LinkedL[] levelOrderTraversal(BinarySearchTree input){
		queue = new LinkedList<Level>();
		level=1;
		buffer=null;
		if (input==null)
			return null;
		int height=TreeNode.Height(input.root);
		LinkedL[] nodes= new LinkedL[height];
		nodes=levelOrder(nodes,input.root);
		return nodes;
	}
	static LinkedL[] levelOrder(LinkedL[] nodes,TreeNode node){
			
			
			//add children
			if (node.leftChild!=null)
				queue.add(new Level(node.leftChild,level));
			if (node.rightChild!=null)
				queue.add(new Level(node.rightChild,level));
			//visit itself
			if (nodes[level-1]==null)
				nodes[level-1]=new LinkedL(node.item);
			else
				nodes[level-1].add(node.item);
			//check if recursion terminate
			if (!queue.isEmpty()){
				level=queue.getFirst().level+1;
				levelOrder(nodes,queue.pollFirst().level_node);	
			}			
			return nodes;
	}
}
class LinkedL{
	Node start;
	Node current;
	LinkedL(int input){
		start = new Node(input);
		current=start;
	}
	void add(int input){
		current.next=new Node(input);
		current=current.next;
	}

}
class Level{
	TreeNode level_node;
	int level;
	Level(TreeNode a, int b){
		level_node=a;
		level=b;
	}
}
class test{
	public static void main (String[] args){
		int size=7;
		int[] arr =new int[size];
		for (int i=0;i<size;i++){
			arr[i]=i;
		}
		int start=0;
		int end=arr.length-1;
		BinarySearchTree tree = BinarySearchTree.arrToBST(arr,start,end);
		/*BinarySearchTree tree=new BinarySearchTree(3);
		tree.root.leftChild=new TreeNode(1);
		tree.root.rightChild=new TreeNode(5);
		tree.root.leftChild.leftChild=new TreeNode(0);
		tree.root.leftChild.rightChild=new TreeNode(2);
		tree.root.rightChild.leftChild=new TreeNode(4);
		tree.root.rightChild.rightChild=new TreeNode(6);*/
		int height=TreeNode.Height(tree.root);
		System.out.println("The height of the tree is "+ height);
		LinkedL[] linkedlist = Node.levelOrderTraversal(tree);
		//linkedlist[0].toStringPrint();
		for (int i=0;i<linkedlist.length;i++){
			linkedlist[i].start.toStringPrint();
			System.out.println();
		}
		

	}
}