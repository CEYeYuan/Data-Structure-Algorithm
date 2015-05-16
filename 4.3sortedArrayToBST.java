/*Given a sorted(inreasing) order array with unique integer elements,write an 
algorithm to create a binary search tree with minimal height */
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
class test{
	public static void main (String[] args){
		int size=32;
		int[] arr =new int[size];
		for (int i=0;i<size;i++){
			arr[i]=i;
		}
		int start=0;
		int end=arr.length-1;
		BinarySearchTree tree = BinarySearchTree.arrToBST(arr,start,end);
		int height=TreeNode.Height(tree.root);
		System.out.println("The height of the tree is "+ height);

	}
}